import java.util.Properties

import org.apache.spark.sql.SparkSession

object StoreToMysql extends App{
  var spark=SparkSession.builder().config("spark.master", "local")
    .getOrCreate()

  val readingcsv=spark.read.format("csv").option("header","true").option("inferSchema","true").load("src/main/resources/data/information.csv")

  readingcsv.show()

  val url=s"jdbc:mysql://localhost:3306/SparkDataBase?autoReconnect=true&useSSL=false"

  val prop=new Properties()
  prop.put("user","root")
  prop.put("password","password")
  Class.forName("com.mysql.jdbc.Driver")

  val table="userDetails"

  readingcsv.write.mode("overwrite").jdbc(url,table,prop)

}
