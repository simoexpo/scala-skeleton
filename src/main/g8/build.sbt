import Dependencies._
$if(benchmark.truthy)$
import Configurations._
$endif$

lazy val compileSettings = Seq(
  Compile / compile := (Compile / compile)
    .dependsOn(
      Compile / scalafmtSbt,
      Compile / scalafmtAll
    )
    .value,
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "utf8",
    "-Xlint:missing-interpolator",
    "-Xlint:private-shadow",
    "-Xlint:type-parameter-shadow",
    "-Ywarn-dead-code",
    "-Ywarn-unused"
  ),
  scalacOptions -= "-Xfatal-warnings",
  scalaVersion := Versions.Scala
)

lazy val dependenciesSettings = Seq(
  libraryDependencies ++= prodDeps ++ testDeps
)

lazy val testSettings = Seq(
  Test / logBuffered := false,
  Test / parallelExecution := false
)

lazy val $name;format="camel"$ = (project in file("."))
  .settings(
    name := "$name$",
    organization := "$organization$"
  )
  .settings(compileSettings: _*)
  .settings(dependenciesSettings: _*)
  .settings(testSettings: _*)
  $if(it_test.truthy)$
  .configs(IntegrationTest)
  .settings(Defaults.itSettings)
  $endif$
  $if(benchmark.truthy)$
  .configs(Benchmark)
  .settings(benchmarkSettings)
  $endif$

$if(benchmark.truthy)$
addCommandAlias("bench", ";bench:run")
$endif$
