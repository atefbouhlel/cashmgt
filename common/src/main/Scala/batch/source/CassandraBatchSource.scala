package batch.source

import config.ApplicationConfiguration
import org.apache.spark.sql.{DataFrame, SparkSession}

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
//    https://stackoverflow.com/questions/62308511/how-to-use-sparksession-in-dataframe-write-in-pyspark-using-spark-cassandra-conn
    /*val createDDL = """CREATE OR REPLACE TEMPORARY VIEW words
     USING org.apache.spark.sql.cassandra
     OPTIONS (
     table "words",
     keyspace "bdcluster",
     cluster "Test Cluster",
     pushdown "true")"""
    spark.sql(createDDL)*/

    table_df
  }
}
