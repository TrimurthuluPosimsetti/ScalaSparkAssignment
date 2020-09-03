import java.io.File


import scala.collection.mutable

class StoringFileInHashMap(dir: String){

  def getListOfFiles():mutable.Map[String, Long]= {

    val d = new File(dir)
    var states = scala.collection.mutable.Map[String, Long]()
    if (d.exists && d.isDirectory) {

      for (x <- d.listFiles()) {
        states += (x.getName -> x.lastModified())
      }
      return states
    }
    return states
  }

}

object StoreFileInHashMapObject extends App{

  val obj=new StoringFileInHashMap("/home/trimurthulu/Downloads/")

  val hashmap=obj.getListOfFiles()

  println(hashmap)

}

