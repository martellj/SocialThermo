# SocialThermo

This is a POC for a way to update a Nest thermostat by tweeting to it.

#Setup

1.  Clone the repo

2.  Navigate to directory `SocialThermo/src/main/scala/config`

3.  Open `TwitterConfig.scala` and insert credentials for your Twitter API developer account
```
  val config = new ConfigurationBuilder()
      .setOAuthConsumerKey("")
      .setOAuthConsumerSecret("")
      .setOAuthAccessToken("")
      .setOAuthAccessTokenSecret("")
      .build
```

4. Add the userId for the Twitter acount to look for commands
```
  val userId:Long = BigInt("").toLong
```

5.  Open `NestConfig.scala`, replace `nestToken` with a valid auth token and thermostatId with a valid ID.

```
  val nestApiUrl = "https://developer-api.nest.com"
  val nestToken = ""
  val thermostatId = ""
```

6.  Run `sbt run` to run the application

7.  From the Twitter acount referenced above, tweet something with the hash tag `#setTempTo{X}` i.e. `#setTempTo78`

8.  Verify the thermostat (or more likely virtual device) is updated with temp specified (Fahrenheight)
  
