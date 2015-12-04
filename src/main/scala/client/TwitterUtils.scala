package SocialThermo.client

/**
 * Created by john on 12/3/15.
 */
object TwitterUtils {
  val commandPattern = """#setThermoTo(\d+)""".r
  def parseCommand(status:String): Option[Int] = {
    commandPattern.findFirstMatchIn(status).map {
      m => m.group(1).toInt
    }
  }
}
