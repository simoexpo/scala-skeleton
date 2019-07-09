import sbt._
import sbt.Keys.{baseDirectory, fork, parallelExecution, resourceDirectory, scalaSource}
import sbt.librarymanagement.Configuration
import scala.sys.process._

object Configurations {

  val Benchmark = config("Benchmark", "bench") extend Runtime

  lazy val benchmarkSettings =
    inConfig(Benchmark)(Defaults.configSettings) ++
      Seq(
        fork in Benchmark := false,
        parallelExecution in Benchmark := false,
        scalaSource in Benchmark := baseDirectory.value / "src/benchmark/scala",
        resourceDirectory in Benchmark := baseDirectory.value / "src/benchmark/resources",
      )

}
