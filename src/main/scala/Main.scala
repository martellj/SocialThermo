package SocialThermo

import SocialThermo.config.TwitterConfig
import SocialThermo.client.{TwitterClient, TwitterStatusListener}
import SocialThermo.nest.NestManager

object Main {
  def main(args:Array[String]):Unit = {
    val twitterClient = new TwitterClient

    twitterClient.execute(
                    options  = new TwitterConfig,
                    listener = new TwitterStatusListener(new NestManager)
                  )
  }
}
