#!/usr/bin/env bash

set -ebu

TEMPLATE_DIR=`dirname $0`/tool-template

NAME=$1
PACKAGE=`echo "$NAME" | awk '{print tolower($0)}'`
OUTPUT_DIR=$TEMPLATE_DIR/../$PACKAGE

echo Output to: $OUTPUT_DIR

mkdir -p $OUTPUT_DIR/project $OUTPUT_DIR/src
mkdir -p $OUTPUT_DIR/src/main/scala/nl/biopet/tools/$PACKAGE $OUTPUT_DIR/src/test/scala/nl/biopet/tools/$PACKAGE
mkdir -p $OUTPUT_DIR/src/test/resources

cp $TEMPLATE_DIR/project/build.properties $TEMPLATE_DIR/project/plugins.sbt $OUTPUT_DIR/project/
cp $TEMPLATE_DIR/src/test/resources/* $OUTPUT_DIR/src/test/resources/
cp $TEMPLATE_DIR/.gitignore $OUTPUT_DIR/
cp $TEMPLATE_DIR/.travis.yml $OUTPUT_DIR/
cp $TEMPLATE_DIR/Jenkinsfile $OUTPUT_DIR/
cp $TEMPLATE_DIR/README.md $OUTPUT_DIR/
cp $TEMPLATE_DIR/LICENSE $OUTPUT_DIR/
cp $TEMPLATE_DIR/version.sbt $OUTPUT_DIR/

sed "s/package nl.biopet.tools.template/package nl.biopet.tools.$PACKAGE/" $TEMPLATE_DIR/src/main/scala/nl/biopet/tools/template/Args.scala > $OUTPUT_DIR/src/main/scala/nl/biopet/tools/$PACKAGE/Args.scala
sed "s/package nl.biopet.tools.template/package nl.biopet.tools.$PACKAGE/" $TEMPLATE_DIR/src/main/scala/nl/biopet/tools/template/ArgsParser.scala > $OUTPUT_DIR/src/main/scala/nl/biopet/tools/$PACKAGE/ArgsParser.scala

sed "s/package nl.biopet.tools.template/package nl.biopet.tools.$PACKAGE/" $TEMPLATE_DIR/src/main/scala/nl/biopet/tools/template/ToolTemplate.scala | \
sed "s/object ToolTemplate/object $NAME/" \
 > $OUTPUT_DIR/src/main/scala/nl/biopet/tools/$PACKAGE/$NAME.scala

sed "s/package nl.biopet.tools.template/package nl.biopet.tools.$PACKAGE/" $TEMPLATE_DIR/src/test/scala/nl/biopet/tools/template/ToolTemplateTest.scala | \
sed "s/class ToolTemplateTest/object ${NAME}Test/" \
 > $OUTPUT_DIR/src/test/scala/nl/biopet/tools/$PACKAGE/${NAME}Test.scala

cat $TEMPLATE_DIR/build.sbt | grep -ve "^//TODO" | \
sed "s/name := \"tool-template\"/name := \"$PACKAGE\"/"  | \
sed "s/mainClass in assembly := Some(\"nl.biopet.tools.template.ToolTemplate\")/mainClass in assembly := Some(\"nl.biopet.tools.$PACKAGE.$NAME\")/" \
 > $OUTPUT_DIR/build.sbt

echo "lazy val $NAME = project in file(\"$PACKAGE\")" >> $TEMPLATE_DIR/../build.sbt
