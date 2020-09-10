package batch.source

import config.ApplicationConfiguration
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * It reads from a cassandra table.
  */
class CassandraBatchSource extends BatchSource {
  private val keyspaceName = ApplicationConfiguration.getCassandraSourceConfig().ks
  private val tableName = ApplicationConfiguration.getCassandraSourceConfig().table

  override def get(spark: SparkSession): DataFrame = {
//    val c = CassandraConnector(spark.sparkContext.getConf)
//    val resultDf = c.withSessionDo ( session => session.execute(s"select * from $keyspaceName.$tableName"))

    val table_df = spark.read
      .format("org.apache.spark.sql.cassandra")
      .options(Map( "table" -> tableName, "keyspace" -> keyspaceName))
      .load()


    table_df
  }
}
