package batch.sink

import org.apache.spark.sql.DataFrame

/**
  * This class is for Test only. It prints the dataframe on the console
  */
class ConsoleBatchSink extends BatchSink {
  override def save(finalDf: DataFrame): Unit = finalDf.show()
}
