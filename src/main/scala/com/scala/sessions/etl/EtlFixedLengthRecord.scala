package com.scala.sessions.etl

case class MetaData(name: String, startIndex: Int, endIndex: Int)

object SampleFileSchema {
  val mainSchema = List(
    MetaData("empname", 0, 16),
    MetaData("empid", 17, 23),
    MetaData("location", 24, 30),
    MetaData("team",31, 47)
  )
}

object EtlFixedLengthRecord {
  // function to decode a record as per the metadata (based on index)
  def decoder(record: String, schemaDetails: List[MetaData]) = {
    schemaDetails.map { f => record.substring(f.startIndex, f.endIndex) }
  }

  // converting the decodedRecord of type List to a Map, by making field name as the Key
  def decodedRecordsToMap (record: List[String], fieldSchema: List[MetaData]) = {
    // get the fieldNames alone from the schema
    val fieldNames = fieldSchema.map((m: MetaData) => m.name)

    // Decode the input record one by one to a List of values per record
    val decodedRecordsList = record.map(decoder(_, fieldSchema))
    decodedRecordsList.map(l => Map(fieldNames.zip(l).toArray: _*))
  }
}

object EtlFixedLengthRecordJob {
  def main(args: Array[String]): Unit = {
    // input records are specified as List in this code, within this object itself (which wont be the case in real)
    val input = List(
      "SUJESHCHIRACKKAL 179870 KOCHI  DigitalEnterprise",
      "SNEHAL VIDYAN    232234 SYDNEY BankingDomain    ",
      "VINEETH MM       444455 SYDNEY DataProducts     ",
      "WRONG ONE        SSSSSS @!@#@$ $$$$$$$$$$$$$$$$$"
    )
    val recordMap = EtlFixedLengthRecord.decodedRecordsToMap (input, SampleFileSchema.mainSchema)
    recordMap.foreach(println(_))
  }
}
