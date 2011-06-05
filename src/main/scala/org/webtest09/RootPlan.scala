package org.webtest09

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._

import org.clapper.avsl.Logger

import collection.immutable.Map

class RootPlan extends Plan {
  val logger = Logger(classOf[RootPlan])
  @volatile private var store = Map.empty[String, Array[Byte]]
  def intent = {
    case req @ Path(Seg("root" :: id :: Nil)) => req match {
      case GET(_) =>
        logger.info("root GET"+req)
        store.get(id).map(ResponseBytes).getOrElse {
          NotFound ~> ResponseString("No record: " + id)
        }
      case PUT(_) =>
        logger.info("root PUT"+req)
        store = store + (id -> Body.bytes(req))
        Created ~> ResponseString("Created record: " + id)
      case _ =>
        logger.info("root unknown method "+req)
        MethodNotAllowed ~> ResponseString("Must be GET or PUT")
    }
  }
}
