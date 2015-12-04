package SocialThermo.client

import SocialThermo.config.TwitterConfig
import twitter4j._

class TwitterClient {
  def execute(options: TwitterConfig, listener:TwitterStatusListener):Unit = {
    val twitterStream = new TwitterStreamFactory(options.config).getInstance
    twitterStream.addListener(listener.listener)
    twitterStream.filter(new FilterQuery().follow(options.userId))
    println("Reading Tweets...")
  }
}




