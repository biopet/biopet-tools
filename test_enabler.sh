#!/usr/bin/env bash
set -eu -o pipefail

tool_name=$(basename $PWD)

# Biopet-summary-tool-does not work with this script
if [[ ! $tool_name == *"-"* ]]; then
# RefflatsStats has a classfile called RefflatStats.scala
if [[ ! $tool_name == *"refflatsstats"* ]]; then
# SamplesTsvToConfig.scala is contained in a folder called sampletsvtoconfig
if [[ ! $tool_name == *"samplestsvtoconfig"* ]]; then


tool_dir=src/main/scala/nl/biopet/tools/$tool_name
test_dir=src/test/scala/nl/biopet/tools/$tool_name
class_file=$tool_dir/$(ls -1R $tool_dir | grep -Ei $tool_name.*.scala)
test_file=$test_dir/$(ls -1R $test_dir | grep -Ei $tool_name.*.scala)

class_file_base=$(basename $class_file)
test_file_base=$(basename $test_file)
class_name="${class_file_base%.*}"
test_name="${test_file_base%.*}"

class_line_number=$(( $(sed -n "/$class_name/=" $class_file | head -n 1) + 1 ))
test_line_number=$(( $(sed -n "/$test_name/=" $test_file | head -n 1) + 1 ))


class_string=$'\  def emptyArgs: Args = Args()\
  def argsParser = new ArgsParser(toolName)'
test_string=$"\  def toolCommand: $class_name.type = $class_name"
main_string=$"\    val cmdArgs = cmdArrayToArgs(args)"

class_string_present=$(sed -n "/def emptyArgs/=" $class_file)
if [ ! -n "$class_string_present" ]
then
sed -i "${class_line_number}i${class_string}" $class_file
fi

test_string_present=$(sed -n "/def toolCommand/=" $test_file)
if [ ! -n "$test_string_present" ]
then
sed -i "${test_line_number}i${test_string}" $test_file
fi

main_string_present=$(sed -n "/val cmdArgs = cmdArrayToArgs(args)/=" $test_file)
if [ ! -n "$main_string_present" ]
then
sed -i "/val parser = new ArgsParser(toolName)/d" $class_file
sed -i "/val cmdArgs =/d" $class_file
sed -i "/parser.parse(args, Args()).getOrElse(throw new IllegalArgumentException)/d" $class_file
main_function_number=$(( $(sed -n "/def main/=" $class_file | head -n 1) + 1 ))
sed -i "${main_function_number}i${main_string}" $class_file
fi

fi
fi
fi