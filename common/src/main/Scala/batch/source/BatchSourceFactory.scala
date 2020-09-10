package batch.source

import org.apache.spark.sql.DataFrame

object BatchSourceFactory {

  /**
    * It retrieves data from a Cassandra Table
    * @return Cassandra batch source
    */
  def getCassandraSource() : BatchSource = {
    new CassandraBatchSource()
  }

  /**
    * It creates dataframe from fake data lists
    * @return a fake transactions batch source
    */
  def getFakeTransactionsBatchSource(): BatchSource = {
    new FakeTransactionsBatchSource
  }

  /**
    * It retrieves data from HDFS
    */
  def getHdfsSource(dataFrame: DataFrame) : Unit = {
    println("hdfs sink")
  }

}
