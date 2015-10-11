package example.producer


import example.producer.Producer
import example.utils.TwitterClient
import twitter4j.Status
import twitter4j.json.DataObjectFactory
import play.api.libs.json.Json
import example.utils.TwitterClient

object TwitterProducer {
  def produce(): Unit = {
    val topicName = "mali"

    val strProducer = Producer[String](topicName)
    val twitterClient = new TwitterClient


    def handler(status: Status) = {
      val data = DataObjectFactory.getRawJSON(status)
      val tweet = Json.parse(data) \ "text"
      strProducer.send(tweet.toString)
    }

    twitterClient.addListener(handler)
    twitterClient.run
  }
}
