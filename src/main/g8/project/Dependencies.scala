import sbt._

object Dependencies {

  private val AllTest = "test$if(it_test.truthy)$,it$endif$"

  private lazy val ScalaTestVersion = "3.0.5"
  private lazy val MockitoVersion = "2.23.4"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % ScalaTestVersion % AllTest
  lazy val mockito = "org.mockito" % "mockito-core" % MockitoVersion % AllTest
}
