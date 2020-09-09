package batch.processor

import batch.sink.BatchSink
import batch.source.BatchSource
import org.apache.spark.sql.{DataFrame, SparkSession}

abstract class DefaultBatchProcessor(batchSource: BatchSource, batchSink: BatchSink, sparkSession: SparkSession) extends BatchProcessor {
  override def process(): Unit = {
    val inputDf = batchSource.get(sparkSession)
    val filtredInputDf = inputDf.filter(row => !row.anyNull)
    val outputdDf = operations().apply(filtredInputDf)
    batchSink.save(outputdDf)
  }

  def operations() : Function[DataFrame, DataFrame]
}
