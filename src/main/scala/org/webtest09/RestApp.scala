package org.webtest09

import org.clapper.avsl.Logger
import unfiltered.jetty.Server

object RestApp {

  val logger = Logger(RestApp getClass)

  val plans = Seq(new RootPlan,
                  new OptimizerPlan)

  def applyPlans = plans.foldLeft(_: Server)(_ filter _)

  def main(args: Array[String]) {
    logger.info("starting unfiltered web service at localhost on port %s" format 8080)
    applyPlans(unfiltered.jetty.Http(8080)).run()
  }

}