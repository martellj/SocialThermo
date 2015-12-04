package SocialThermo.config

import twitter4j.{StallWarning, StatusDeletionNotice, Status, StatusListener}

class TwitterConfig {
  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey("DqS0TCBB97asPQPhRUg4Ef1xU")
    .setOAuthConsumerSecret("5ZWTTOOBCbfYpkcpPLuthsQ9yDKI8o2n674jkc8u1VAzUzoEo4")
    .setOAuthAccessToken("4364963187-BI5G4egtHEDgUTHnFRwvVcR3Fwo6nS3BN1EpaGW")
    .setOAuthAccessTokenSecret("gon7zXb2fAn2iTz3lzdAcRXLZzeCuTLNZV7HE6iRUnySj")
    .build

  val userId:Long = BigInt("4364963187").toLong

}
