organization := "com.github.biopet"
name := "biopet-tools"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

lazy val biopetTools = (project in file("."))
  .aggregate(toolTemplate, fastqSplitter, squishbed, refflatsstats, vcfStats)

lazy val vcfStats = project in file("vcfstats")
lazy val bamStats = project in file("bamstats")
lazy val refflatsstats = project in file("refflatsstats")
lazy val squishbed = project in file("squishbed")
lazy val toolTemplate = project in file("tool-template")
lazy val fastqSplitter = project in file("fastq-splitter")
//lazy val biopetSummaryTool = project in file("biopet-summary-tool")
