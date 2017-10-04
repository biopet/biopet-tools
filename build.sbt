organization := "com.github.biopet"
name := "biopet-tools"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

lazy val biopetTools = (project in file("."))
  .aggregate(toolTemplate, fastqSplitter, squishbed)

lazy val squishbed = project in file("squishbed")
lazy val toolTemplate = project in file("tool-template")
lazy val fastqSplitter = project in file("fastq-splitter")
//lazy val biopetSummaryTool = project in file("biopet-summary-tool")
