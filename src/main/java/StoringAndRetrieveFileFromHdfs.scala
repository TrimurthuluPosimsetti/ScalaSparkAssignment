import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object StoringAndRetrieveFileFromHdfs extends App{

  val spark = SparkSession.builder()
    .appName("StoringAndRetrieveFileFromHdfs")
    .config("spark.master", "local")
    .getOrCreate()


  //localhost:50070
  val file:DataFrame = spark.read.text("hdfs://localhost:9000/folder/fruits.txt")
  file.show()

  file.write
    .format("csv")
    .option("header","true")
    .mode(SaveMode.Overwrite)
    .save("file:///C:/Users/Home/trimurthulu/Desktop/NewFolder/fruits.csv")

}