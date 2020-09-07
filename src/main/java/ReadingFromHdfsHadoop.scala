
import org.apache.spark.sql.{DataFrame, SparkSession}


object ReadingFromHdfsHadoop extends App{

  val spark = SparkSession.builder()
    .appName("Reading hdfs file from hadoop")
    .config("spark.master", "local")
    .getOrCreate()

  val df= spark.read.text("hdfs://localhost:50070/fruits.txt")
  df.show()
}