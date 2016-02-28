package com.problems.etl

import scala.util.Try

/*
 * This job improvise the EtlFixedLengthRecord Job to use Either, Right & Left
 * for handling exceptions
 */

case class MetaData2[T](name: String, startIndex: Int, endIndex: Int, convert: String => Either[String, T])

sealed trait TypeCheckEither2[String, T] {
  def toType(x: String): Either[String, T]
}

object IntType2 extends TypeCheckEither2[String, Int] {
  // function returns an Instance of String (for failure, it is a message) or Int (if value is converted successfully)
  def toType (x: String): Either[String, Int] = {
    if (Try(x.toInt).isFailure) {
      Left(s"Unable to convert $x to Int")
    }
    else
      Right(x.toInt)
  }
}

object DoubleType2 extends TypeCheckEither2[String, Double] {
  // function returns an Instance of String (for failure, it is a message) or Int (if value is converted successfully)
  def toType (x: String): Either[String, Double] = {
    if (Try(x.toDouble).isFailure) {
      Left(s"Can not convert $x to Double")
    }
    else
      Right(x.toDouble)
  }
}

object SampleFileSchema2 {
  val mainSchema = List(
    MetaData2[String]("empname", 0, 16, Right(_)),
    MetaData2[Int]("empid",17, 23, IntType2.toType(_)),
    MetaData2[String]("location", 24, 30, Right(_)),
    MetaData2[String]("team",31, 48, Right(_)),
    MetaData2[Double]("salary",49, 56, DoubleType2.toType(_))
  )
}

object EtlFixedLengthRecordWithExceptionHandling {
  // function to decode a record as per the metadata (based on index)
  def decoder(record: String, schemaDetails: List[MetaData2[_]]) = {
    schemaDetails.map {
      f => {
        // if the type is not matched, field value is defaulted to ""
        f.convert(record.substring(f.startIndex, f.endIndex).trim) match {
          case Right(x) => x
          case Left(x)  => x
        }
      }
    }
  }

  // converting the decodedRecord of type List to a Map, by making field name as the Key
  def decodedRecordsToMap (record: List[String], fieldSchema: List[MetaData2[_]]) = {
    // get the fieldNames alone from the schema
    val fieldNames = fieldSchema.map((m: MetaData2[_]) => m.name)

    // Decode the input record one by one to a List of values per record
    val decodedRecordsList = record.map(decoder(_, fieldSchema))
    decodedRecordsList.map(l => Map(fieldNames.zip(l).toArray: _*))
  }
}

object EtlFixedLengthRecordJob2 {
  def main(args: Array[String]): Unit = {
    // input records are specified as List in this code, within this object itself (which wont be the case in real)
    val input2 = List(
      "SUJESHCHIRACKKAL 179870 KOCHI  DigitalEnterprise 2000.00",
      "SNEHAL VIDYAN    232234 SYDNEY BankingDomain     1800.00",
      "VINEETH MM       444455 SYDNEY DataProducts      3000.60",
      "111111111        SSSSSS @!@#@$ $$$$$$$$$$$$$$$$$ !#$@#$@"
    )
    val recordMap = EtlFixedLengthRecordWithExceptionHandling.decodedRecordsToMap(input2, SampleFileSchema2.mainSchema)
    recordMap.foreach(println(_))
  }
}
