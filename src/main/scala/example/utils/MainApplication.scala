package example.utils

import example.consumer.ConsumerStreamExample
import example.producer.{TwitterProducer, Producer}
import play.api.libs.json.Json
import twitter4j.Status
import twitter4j.json.DataObjectFactory

/**
 * Created by seongl on 10/10/15.
 */
object MainApplication {
  def main(args: Array[String]): Unit = {
    val producerThread = new Thread {
      override def run {
        // run producer code
        TwitterProducer.produce()
      }
    }

    val consumerThread = new Thread {
      override def run {
        // run producer code
        ConsumerStreamExample.consume()
      }
    }

    producerThread.start()
    consumerThread.start()
  }
}
