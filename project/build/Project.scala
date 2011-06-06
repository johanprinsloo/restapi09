import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val uf_version = "0.3.3"
  
  // unfiltered
  lazy val uff = "net.databinder" %% "unfiltered-filter" % uf_version
  lazy val ufj = "net.databinder" %% "unfiltered-jetty" % uf_version
  lazy val ufs = "net.databinder" %% "unfiltered-json" % uf_version
  lazy val uft = "net.databinder" %% "unfiltered-scalate" % uf_version

  // testing
  lazy val uf_spec = "net.databinder" %% "unfiltered-spec" % uf_version % "test"
  
  // logging
  val javaNetRepo = "Java.net Repository for Maven" at "http://download.java.net/maven/2"
  val newReleaseToolsRepository = ScalaToolsSnapshots
  val avsl = "org.clapper" %% "avsl" % "0.3.1"

  //runtime
  override def mainClass = Some("org.webtest09.RestApp")
}
