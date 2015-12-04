package SocialThermo.nest

import SocialThermo.actors.NestActor
import akka.actor.{Props, ActorSystem}


class NestManager {
  val system = ActorSystem("social-thermo")
  val actor = system.actorOf(Props[NestActor])

  def setTemp(temp:Int):Unit = {
    val command = SetTempCommand(temp)
    tellActor(command)
  }

  def tellActor(command:NestCommand): Unit = {
    actor ! command
  }
}

trait NestCommand

case class SetTempCommand(temp:Int) extends NestCommand

