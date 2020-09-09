package batch.source

import org.apache.spark.sql.{DataFrame, SparkSession}

trait BatchSource {
  def get(spark: SparkSession) : DataFrame
}
