package batch.source

import batch.Entity.Transaction
import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.collection.mutable

/**
  * The FakeTransactionsBatchSource generates transactions with random data
  */
class FakeTransactionsBatchSource extends BatchSource {

  override def get(spark: SparkSession): DataFrame = {
    import spark.implicits._

    val currenciesList = Seq("EUR", "USD", "CAD", "JPY", "TND")
    val clientsList = Seq("198217", "176920", "167021", "116210")
    val dataList = mutable.MutableList[Transaction]()

    for( i <- 0 to 10)
    {
      val currencyIndex = scala.util.Random.nextInt(currenciesList.size)
      val counterCurrencyIndex = scala.util.Random.nextInt(currenciesList.size)
      val clientIndex = scala.util.Random.nextInt(clientsList.size)
      val transactionType = if (scala.util.Random.nextInt(2) == 1)  "ask" else "bid"
      dataList += Transaction(
        "EUR", //currenciesList(currencyIndex),
        currenciesList(counterCurrencyIndex),
        transactionType,
        clientsList(clientIndex)
      )
    }


    dataList.toDF
  }



}