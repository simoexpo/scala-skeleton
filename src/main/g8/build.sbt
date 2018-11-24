import Dependencies._
$if(benchmark.truthy)$
import Configurations._
$endif$

organization := "$organization$"

name := "$name$"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(scalaTest, mockito)

scalacOptions in Compile := Seq("-deprecation")

lazy val $name;format="camel"$ = (project in file("."))
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
