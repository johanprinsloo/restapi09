organization := "com.example"

name := "restapi09"

version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "0.5.3",
  "net.databinder" %% "unfiltered-jetty" % "0.5.3",
  "net.databinder" %% "unfiltered-json" % "0.5.3",
  "org.clapper" %% "avsl" % "0.3.6",
  "net.databinder" %% "unfiltered-spec" % "0.5.3" % "test"
)

resolvers ++= Seq(
  "java m2" at "http://download.java.net/maven/2"
)


mainClass := Some("com.example.RestApp")
