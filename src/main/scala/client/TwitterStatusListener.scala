package SocialThermo.client

import SocialThermo.nest.NestManager
import twitter4j._

class TwitterStatusListener(nestManager: NestManager) {
  val listener:StatusListener = new StatusListener() {
    def onStatus(status: Status) {

      val statusText = status.getText
      val screenName = status.getUser.getScreenName

      println("Tweet found!")
      println("Screen Name: " + screenName)
      println("Status: " + statusText)

      val extractedTemp = TwitterUtils.parseCommand(statusText)

      extractedTemp match {
        case Some(temp) =>
          println("Tweet contained command! Setting temp to %s degrees F.".format(temp.toString))
          nestManager.setTemp(temp)
          println("Command sent!")
        case None =>
          println("Command not found in current tweet.")
      }
    }
    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
    def onException(ex: Exception) { ex.printStackTrace }
    def onScrubGeo(arg0: Long, arg1: Long) {}
    def onStallWarning(warning: StallWarning) {}
  }
}
