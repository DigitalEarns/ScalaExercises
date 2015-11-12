package com.scala.sessions.etl

import scala.util.Try

case class MetaData[T](name: String, startIndex: Int, endIndex: Int, convert: String => Either[String, T])

sealed trait TypeCheck[T] {
  def toType(x: String): Either[String, T]
}

object IntType extends TypeCheck[Int] {
  def toType (x: String): Either[String, Int] = Try(x.toInt).isFailure match {
    case true => Left("Interger Was expected")
    case false => Right(x.toInt)
  }
}

object DoubleType extends TypeCheck[Double] {
  def toType (x: String): Either[String, Double] = Try(x.toDouble).isFailure match {
    case true => Left("Interger Was expected")
    case false => Right(x.toDouble)
  }
}

object SampleFileSchema {
  val mainSchema = List(
    MetaData[String]("empname", 0, 16, Right(_)),
    MetaData[Int]("empid", 17, 23, IntType.toType(_)),
    MetaData[String]("location", 24, 30, Right(_)),
    MetaData[String]("team",31, 48, Right(_)),
    MetaData[Double]("salary",49, 56, DoubleType.toType(_))
  )
}

object EtlFixedLengthRecord {
  // function to decode a record as per the metadata (based on index)
  def decoder(record: String, schemaDetails: List[MetaData[_]]) = {
    schemaDetails.map {
      f => {
        // if the type is not matched, field value is defaulted to ""
        f.convert(record.substring(f.startIndex, f.endIndex).trim) match {
          case Right(x) => x
          case Left(_)    => ""
        }
      }
    }
  }

  // converting the decodedRecord of type List to a Map, by making field name as the Key
  def decodedRecordsToMap (record: List[String], fieldSchema: List[MetaData[_]]) = {
    // get the fieldNames alone from the schema
    val fieldNames = fieldSchema.map((m: MetaData[_]) => m.name)

    // Decode the input record one by one to a List of values per record
    val decodedRecordsList = record.map(decoder(_, fieldSchema))
    decodedRecordsList.map(l => Map(fieldNames.zip(l).toArray: _*))
  }
}

object EtlFixedLengthRecordJob {
  def main(args: Array[String]): Unit = {
    // input records are specified as List in this code, within this object itself (which wont be the case in real)
    val input = List(
      "SUJESHCHIRACKKAL 179870 KOCHI  DigitalEnterprise 2000.00",
      "SNEHAL VIDYAN    232234 SYDNEY BankingDomain     1800.00",
      "VINEETH MM       444455 SYDNEY DataProducts      3000.60",
      "111111111        SSSSSS @!@#@$ $$$$$$$$$$$$$$$$$ !#$@#$@"
    )
    val recordMap = EtlFixedLengthRecord.decodedRecordsToMap(input, SampleFileSchema.mainSchema)
    recordMap.foreach(println(_))
  }
}
