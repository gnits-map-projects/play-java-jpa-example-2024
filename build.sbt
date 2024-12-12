lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayPekkoHttpServer) // uncomment to use the Netty backend
  .settings(
    name := """play-java-jpa-example""",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.14", "3.3.3"),
    scalaVersion := crossScalaVersions.value.head,
    fork := true,
    libraryDependencies ++= Seq(
      guice,
      javaJpa,
      javaJdbc,
      "com.h2database" % "h2" % "2.3.232",
      "org.hibernate" % "hibernate-core" % "6.6.0.Final",
      "com.mysql" % "mysql-connector-j" % "9.1.0",
      javaWs % "test",
      "org.awaitility" % "awaitility" % "4.2.2" % "test",
      "org.assertj" % "assertj-core" % "3.26.3" % "test",
      "org.mockito" % "mockito-core" % "5.13.0" % "test",
    ),
    Test / testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-v"),
    scalacOptions ++= List("-feature", "-Werror"),
    javacOptions ++= List("-Xlint:unchecked", "-Xlint:deprecation", "-Werror"),
    PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"
  )