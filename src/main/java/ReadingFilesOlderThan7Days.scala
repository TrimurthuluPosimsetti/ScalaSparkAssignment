import java.io.File

object ReadingFilesOlderThan7Days extends App{

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    val sevendays = System.currentTimeMillis - (7 * 24 * 60 * 60 * 1000)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.getName.endsWith(".txt")).filter(_.lastModified()<sevendays).toList
    } else {
      List[File]()
    }
  }

  val files = getListOfFiles("/home/trimurthulu/Downloads/")
  println(files)
}
