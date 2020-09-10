package batch.processor

import batch.sink.BatchSink
import batch.source.BatchSource
import org.apache.spark.sql.{DataFrame, SparkSession}

abstract class DefaultBatchProcessor(batchSource: BatchSource, batchSink: BatchSink, sparkSession: SparkSession) extends BatchProcessor {
  /**
    * It does all the ETL flow: get dataSource, apply transformations and outputs the result to a data sink
    */
  override def process(): Unit = {
    val inputDf = batchSource.get(sparkSession)
    val filtredInputDf = inputDf.filter(row => !row.anyNull)
    val outputdDf = operations().apply(filtredInputDf)
    batchSink.save(outputdDf)
  }

  /**
    * It contains the transformations that will be applied on the input DataFrame
    * @return the output DataFrame
    */
  def operations() : Function[DataFrame, DataFrame]
}
