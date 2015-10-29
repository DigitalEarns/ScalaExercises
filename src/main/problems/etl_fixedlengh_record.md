### An exercise to create a small ETL kind of job

Question

   Input Records -> N number of records which are fixed in length (there is no delimiter)
     ex:

        val inputRecord = """
	  SUJESHCHIRACKKAL 179870 KOCHI    DigitalEnterprise
          SNEHAL VIDYAN    232234 SYDNEY   BankingDomain
          VINEETH MM       444455 SYDNEY   DataProducts
        """
   
        Fields : 

		Name : Position 1-17
                EmpID: Position 18-24
                Location: Position 25-34
                Team: Position 35-51


       Note: Records are delimited by new line character

       Input can be in a file or a string for doing this exercise.

    Output Expected:

		Each record being decoded and mapped to fields (could be a Map of records)

                print the output to console as

		"""
		Record1 --> Name -> SUJESHCHIRACKKAL, EmpId -> 179870, Place -> Kochi,  Team -> DigitalEnterprise
                Record2 --> Name -> SNEHAL VIDYAN   , EmpId -> 232234, Place -> Sydney, Team -> BankingDomain
                Record3 --> Name -> VINEETH MM      , EmpId -> 444455, Place -> Sydney, Team -> DataProducts    

    Note: It is fine to consider all field and values as String in this exercise.
   
