organization := "nl.biopet"
name := "biopet-tools"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

lazy val biopetTools = (project in file("."))
  .aggregate(toolTemplate)

lazy val toolTemplate = project in file("tool-template")
