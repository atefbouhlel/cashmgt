import batch.sink.BatchSinkFactory
import batch.source.BatchSourceFactory
import config.ApplicationConfiguration
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object TransactionsGeneratorLauncher {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host", "dse_node_seed")

    val spark = SparkSession.builder
      .appName("cashmgt")
      .config(conf)
      .getOrCreate()

    val processor = new TransactionsGeneratorProcessor(BatchSourceFactory.getCassandraSource(), BatchSinkFactory.getCassandraSink(), spark)
    processor.process()
  }
}