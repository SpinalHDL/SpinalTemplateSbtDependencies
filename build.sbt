
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.spinalhdl",
      scalaVersion := "2.11.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "superproject"
  ).dependsOn(vexRiscv)
lazy val vexRiscv = RootProject(uri("git://github.com/SpinalHDL/VexRiscv.git"))

//If you want a specific git commit : 
//lazy val vexRiscv = RootProject(uri("git://github.com/SpinalHDL/VexRiscv.git#commitHash"))

//If the dependancy is localy on your computer : 
//lazy val vexRiscv = RootProject(file("local/path/to/the/VexRiscv/sbt/project/VexRiscv"))


addCompilerPlugin("org.scala-lang.plugins" % "scala-continuations-plugin_2.11.6" % "1.0.2")
scalacOptions += "-P:continuations:enable"
fork := true
