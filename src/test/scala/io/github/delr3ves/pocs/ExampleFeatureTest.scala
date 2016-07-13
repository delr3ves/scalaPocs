package io.github.delr3ves.pocs

import com.twitter.finagle.http.Status.Ok
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import io.github.delr3ves.pocs.finatra.ExampleServer

class ExampleFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new ExampleServer)

  "Server" should {
    "ping" in {
      server.httpGet(
        path = "/ping",
        andExpect = Ok,
        withBody = "pong")
    }
  }
}
