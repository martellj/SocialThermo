package SocialThermo.actors

import SocialThermo.nest.SetTempCommand
import akka.actor.Actor
import config.NestConfig
import play.api.libs.ws._
import play.api.libs.ws.ning.NingWSClient
import scala.concurrent.Future

class NestActor extends Actor {

  def receive = {
    case cmd:SetTempCommand =>
      println("Command received: Set Temp to %s.".format(cmd.temp.toString))
      putTemperature(cmd.temp, new NestConfig)
  }

  private def putTemperature(temp:Int, options:NestConfig):Future[WSResponse] = {
      val payload = s"""{"target_temperature_f" : %s}""".format(temp)
      println(payload)
      val endpoint = "%s/devices/thermostats/%s?auth=%s" .format(options.nestApiUrl, options.thermostatId, options.nestToken)

      val wsClient = NingWSClient()
      wsClient
        .url(endpoint)
        .withHeaders(("Content-Type","application/json"))
        .put(payload)
  }
}
