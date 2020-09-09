package batch.source

import org.apache.spark.sql.DataFrame

object BatchSourceFactory {

  def getCassandraSource() : BatchSource = {
    println("cassandra batch source")
    new CassandraBatchSource()
  }

  def getHdfsSource(dataFrame: DataFrame) : Unit = {
    println("hdfs sink")
  }

}
