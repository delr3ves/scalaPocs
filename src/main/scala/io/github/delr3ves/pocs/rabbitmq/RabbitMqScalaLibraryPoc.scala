package io.github.delr3ves.pocs.rabbitmq

import scala.concurrent.duration.DurationInt

import io.relayr.amqp._

/**
  * Created by serch on 28/6/16.
  */
object RabbitMqScalaLibraryPoc extends App {

  val queueConnectionUrl = "amqps://localhost"
  val connection = connect

  val channel = enqueue("anyQueue", "any message")

  dequeue("anyMessage")

  closeConnection(connection)

  def connect() = {
    ConnectionHolder.builder(queueConnectionUrl)
      .eventHooks(EventHooks())
      .reconnectionStrategy(ReconnectionStrategy.JavaClientFixedReconnectDelay(1 second))
      .build()
  }

  def enqueue(queueName: String, msg: String): ChannelOwner = {
    val channel = connection.newChannel
    channel.send(Exchange.Default.route(queueName), Message.String(msg))
    channel
  }

  def dequeue(queueName: String) = {
    def consumer(request: Message): Unit = request match {
      case Message.String(string) => println(string)
    }
    val queue = QueueDeclare(Some(queueName))
    channel.addConsumer(queue, consumer)
  }

  def closeChannel(channel: ChannelOwner) = channel.close

  def closeConnection(connection: ConnectionHolder) = connection.close

}
