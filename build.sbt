name := "Gemini Geom"

lazy val root = project.in(file(".")).
  aggregate(geminiGeomJS, geminiGeomJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val geminiGeom = crossProject.in(file(".")).
  settings(
    name := "geminiGeom",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.6",

    libraryDependencies ++= Seq(
      "org.scalaz"   %%% "scalaz-core"   % "7.2.1",
      "org.scalaz"   %%% "scalaz-effect" % "7.2.1"
    ),
    compileOrder := CompileOrder.JavaThenScala
  ).
  jvmSettings(
    // Add JVM-specific settings here
    libraryDependencies ++= Seq(
      "org.scala-js" %% "scalajs-stubs" % "0.6.6" % "provided"
    )//,
    //unmanagedJars in Compile := (baseDirectory.value / "lib" ** "*.jar").classpath
  ).
  jsSettings(
    // Add JS-specific settings here
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0"
    ),

    jsDependencies ++= Seq(
      "org.webjars" % "paperjs" % "0.9.22" / "paper-core.js"
    )
    //unmanagedJars in Compile := (baseDirectory.value / "lib" ** "*.jar").classpath
  )

lazy val geminiGeomJVM = geminiGeom.jvm
lazy val geminiGeomJS  = geminiGeom.js

