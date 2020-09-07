import java.util.Properties

import org.apache.spark.sql.{SaveMode, SparkSession}

object PerformingInnerJoin extends App{
  var spark=SparkSession.builder().master("local").getOrCreate()

  var df=spark.read.format("Json").option("inferSchema","true").load("src/main/resources/data/details.json")
  var df2=spark.read.format("Json").option("inferSchema","true").load("src/main/resources/data/Cities.json")

  df.show()
  df2.show()


  val output=df.join(df2,df.col("city")===df2.col("city"),"inner")

  output.show()


}


