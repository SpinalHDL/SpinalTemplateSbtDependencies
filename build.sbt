val spinalVersion = "dev"
val spinalHdlPath = sys.env("SPINALHDL_PATH")

lazy val root = (project in file(".")).settings(
  inThisBuild(List(
    organization := "com.github.spinalhdl",
    scalaVersion := "2.12.18",
    version := "2.0.0"
  )),
  scalacOptions += s"-Xplugin:${new File(s"$spinalHdlPath/idslplugin/target/scala-2.12/spinalhdl-idsl-plugin_2.12-$spinalVersion.jar")}",
  scalacOptions += s"-Xplugin-require:idsl-plugin",
  scalacOptions += "-language:reflectiveCalls",
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.17"
  ),
  name := "template"
).dependsOn(
  spinalHdlIdslPlugin, spinalHdlSim, spinalHdlCore, spinalHdlLib,
  vexiiRiscv,
  libA
)

lazy val spinalHdlIdslPlugin = ProjectRef(file(spinalHdlPath), "idslplugin")
lazy val spinalHdlSim = ProjectRef(file(spinalHdlPath), "sim")
lazy val spinalHdlCore = ProjectRef(file(spinalHdlPath), "core")
lazy val spinalHdlLib = ProjectRef(file(spinalHdlPath), "lib")
lazy val vexiiRiscv = RootProject(file("./ext/VexiiRiscv"))
lazy val libA = RootProject(file("./ext/libA"))

fork := true
