package batch.Entity

/**
  * The Transaction Entity/Model.
  * @param currency
  * @param counterCurrency
  * @param transactionType
  * @param clientId
  */
case class Transaction (currency : String, counterCurrency : String, transactionType: String, clientId: String){
}
