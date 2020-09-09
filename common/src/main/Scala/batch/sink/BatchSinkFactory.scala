package batch.sink

object BatchSinkFactory {
  def getCassandraSink() : BatchSink = {
    println("cassandra batch sink")
    new CassandraBatchSink()
  }

  def getHdfsSink() : Unit = {
     println("hdfs sink")
  }
}
