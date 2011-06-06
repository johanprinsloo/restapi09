package org.webtest09

import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._

import org.clapper.avsl.Logger

import collection.immutable.Map

class OptimizerPlan extends Plan {
  val logger = Logger(classOf[OptimizerPlan])
  @volatile private var store = Map.empty[String, Array[Byte]]
  def intent = {
    case req @ Path(Seg("optimizer" :: id :: Nil)) => req match {
      case GET(_) =>
        logger.info("optimizer GET"+req)
        store.get(id).map(ResponseBytes).getOrElse {
          NotFound ~> ResponseString("No record: " + id)
        }
      case PUT(_) =>
        logger.info("optimizer PUT"+req)
        store = store + (id -> Body.bytes(req))
        Created ~> ResponseString("Created record: " + id)
      case _ =>
        logger.info("optimizer unknown method"+req)
        MethodNotAllowed ~> ResponseString("Must be GET or PUT")
    }
  }
}
