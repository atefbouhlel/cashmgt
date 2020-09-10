package batch.sink

/**
  * The BatchSinkFactory creates different data sinks.
  */
object BatchSinkFactory {
  /**
    * It saves the dataframe in a cassandra table
    */
  def getCassandraSink() : BatchSink = {
    println("cassandra batch sink")
    new CassandraBatchSink()
  }
  /**
    * It displays the dataframe on the console
    * @return a console batch sink
    */
  def getConsoleSink(): BatchSink = {
    new ConsoleBatchSink()
  }

  /**
    * It saves the dataframe in HDFS
    * @return a hdfs batch sink
    */
  def getHdfsSink() : Unit = {
     println("hdfs sink loading")
  }
}
