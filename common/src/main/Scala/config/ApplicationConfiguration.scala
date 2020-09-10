package config

import com.typesafe.config.ConfigFactory
/**
  * a Singleton class to read the config file a map it to config objects
  */
object ApplicationConfiguration extends Serializable {
  case class CassandraSourceConfig(ks : String, table : String)
  case class CassandraSinkConfig(ks : String, table : String)//, columns : List[String])

  val conf = ConfigFactory.load()

  private val cassandraSinkConfig: CassandraSinkConfig = CassandraSinkConfig(conf.getString("cassandra-sink.keyspaceName"), conf.getString("cassandra-sink.tableName"))//, conf.getStringList("cassandra-sink.columns").asScala.toList)
  private val cassandraSourceConfig: CassandraSourceConfig = CassandraSourceConfig(conf.getString("cassandra-source.keyspaceName"), conf.getString("cassandra-source.tableName"))



  def getCassandraSinkConfig() = cassandraSinkConfig
  def getCassandraSourceConfig() = cassandraSourceConfig
}
