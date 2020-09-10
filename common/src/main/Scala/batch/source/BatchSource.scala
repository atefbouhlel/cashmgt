package batch.source

import org.apache.spark.sql.{DataFrame, SparkSession}

trait BatchSource {
  /**
    * It retrieves data from a source
    * @return dataframe containing the data from the source
    */
  def get(spark: SparkSession) : DataFrame
}
