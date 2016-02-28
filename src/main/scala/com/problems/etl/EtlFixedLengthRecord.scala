package com.problems.etl

import scala.util.Try

case class MetaData[T](name: String, startIndex: Int, endIndex: Int, convert: String => Option[T])

sealed trait TypeCheck[T] {
  def toType(x: String): Option[T]
}

object IntType extends TypeCheck[Int] {
  def toType (x: String): Option[Int] = Try(x.toInt).toOption
}

object DoubleType extends TypeCheck[Double] {
  def toType (x: String): Option[Double] = Try(x.toDouble).toOption
}

object SampleFileSchema {
  val mainSchema = List(
    MetaData[String]("empname", 0, 16, Some(_)),
    MetaData[Int]("empid", 17, 23, IntType.toType(_)),
    MetaData[String]("location", 24, 30, Some(_)),
    MetaData[String]("team",31, 48, Some(_)),
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
          case Some(x) => x
          case None    => ""
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
