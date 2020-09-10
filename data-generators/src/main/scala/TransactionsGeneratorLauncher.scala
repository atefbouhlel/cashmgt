import batch.sink.BatchSinkFactory
import batch.source.BatchSourceFactory
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * This job will get the random generated transactions and save them to Cassandra table.
  */
object TransactionsGeneratorLauncher {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host", "dse_node_seed")

    val spark = SparkSession.builder
      .appName("cashmgt")
      .config(conf)
      .getOrCreate()

    val processor = new TransactionsGeneratorProcessor(
      BatchSourceFactory.getFakeTransactionsBatchSource(),
      BatchSinkFactory.getCassandraSink(),
      spark)

    processor.process()
  }
}