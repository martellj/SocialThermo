package SocialThermo.config

import twitter4j.conf.ConfigurationBuilder

class TwitterConfig {
  val config = new ConfigurationBuilder()
    .setOAuthConsumerKey("")
    .setOAuthConsumerSecret("")
    .setOAuthAccessToken("")
    .setOAuthAccessTokenSecret("")
    .build

  val userId:Long = BigInt("").toLong

}
