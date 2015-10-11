package example.consumer

object ConsumerStreamExample {
  def consume(): Unit = {
    val topicName = "mali"

    val consumer = SingleTopicConsumer(topicName)

    consumer.read().foreach(println)
  }
}
