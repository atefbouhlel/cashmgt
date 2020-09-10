# Cash Management
In this project, we will simulate a cash flow in a bank and implements applications that will manage this cash flow.

## Random Data Generators
To simulate the cash flow, fake data (transactions, rate currency, clients ids, ..) will be generated randomly.
##### TransactionsGeneratorLauncher
This is the first simulator that generates fake transactions in batch mode.  

##### StreamingTransactionsGeneratorLauncher
This job will take the transactions generated randomly via Kafka.
So Kafka will the streaming source.  

## Usage
The first step is to compile and generate the jars.
```
cd cashmgt
mvn clean install
```
Second step is to copy the jars on the cluster.  
In this project, we are the bigdata-cluster created by Docker. So we need to copy the jars on the mspark-master container as below:
```
docker cp target/data-generators-1.0-SNAPSHOT.jar spark-master:/root/
docker cp ../common/target/common-1.0-SNAPSHOT.jar spark-master:/root/ 
```
Final step is to submit the jar with spark-submit as below:
```
/spark/bin/spark-submit --packages com.datastax.spark:spark-cassandra-connector_2.11:2.5.1 --jars /root/common-1.0-SNAPSHOT.jar --class TransactionsGeneratorLauncher /root/data-generators-1.0-SNAPSHOT.jar
```