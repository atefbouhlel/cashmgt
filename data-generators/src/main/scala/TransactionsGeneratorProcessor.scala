import batch.sink.BatchSink
import batch.processor.DefaultBatchProcessor
import batch.source.BatchSource
import org.apache.spark.sql.{DataFrame, SparkSession}

class TransactionsGeneratorProcessor(batchSource: BatchSource, batchSink: BatchSink, spark: SparkSession) extends DefaultBatchProcessor(batchSource, batchSink, spark) {
  override def operations(): Function[DataFrame, DataFrame] = {
    inputDF => {
      val namesDf = inputDF.filter(tuple => tuple.anyNull)
      namesDf
//      inputDF
    }
  }
}
