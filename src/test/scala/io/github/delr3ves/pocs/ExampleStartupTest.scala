package io.github.delr3ves.pocs

import com.google.inject.Stage
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.Test
import io.github.delr3ves.pocs.finatra.ExampleServer

class ExampleStartupTest extends Test {

  val server = new EmbeddedHttpServer(
    stage = Stage.PRODUCTION,
    twitterServer = new ExampleServer)

  "server" in {
    server.assertHealthy()
  }
}
