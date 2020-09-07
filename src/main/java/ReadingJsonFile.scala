import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object ReadingJsonFile extends App{

  val spark = SparkSession.builder()
    .appName("Reading Json")
    .config("spark.master", "local")
    .getOrCreate()

  val personsSchema = StructType(Array(
    StructField("eventName",StringType),
    StructField("processName",StringType),
    StructField("hostName",StringType),
    StructField("filePath",StringType),
    StructField("dataFileName",StringType)
  ))

  val df = spark.read.format("json")
    .schema(personsSchema)
    .load("src/main/resources/data/eventdetails.json")

  df.show()

}