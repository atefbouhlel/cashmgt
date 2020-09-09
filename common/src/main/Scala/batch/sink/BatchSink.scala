package batch.sink

import org.apache.spark.sql.DataFrame

trait BatchSink extends Serializable {
  def save(finalDf: DataFrame)
}
