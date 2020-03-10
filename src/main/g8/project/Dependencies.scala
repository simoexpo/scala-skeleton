import sbt._

object Dependencies {

  $if(benchmark.truthy) $
  private val AllTest = "test$if(it_test.truthy)$,it$endif$"
  $endif$

  object Versions {
    lazy val Scala            = "$scala_version$"
    lazy val ScalaTestVersion = "3.1.1"
  }

  lazy val prodDeps: Seq[ModuleID] = Seq(

  )

  lazy val testDeps: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % Versions.ScalaTestVersion
  ).map(_ % $if(benchmark.truthy) $AllTest$else$Test$endif$)
}
