package batch.sink

import config.ApplicationConfiguration
import org.apache.spark.sql.{DataFrame, SaveMode}

class CassandraBatchSink extends BatchSink {
    private val keyspaceName = ApplicationConfiguration.getCassandraSinkConfig().ks
    private val tableName = ApplicationConfiguration.getCassandraSinkConfig().table
//    private val tableColumns = ApplicationConfiguration.getCassandraSinkConfig().columns

    def save(finalDf: DataFrame): Unit = {
      finalDf
        .write
        .format("org.apache.spark.sql.cassandra")
        .options(Map("table" -> tableName, "keyspace" -> keyspaceName))
        .mode(SaveMode.Append)
        .save()
    }

}
