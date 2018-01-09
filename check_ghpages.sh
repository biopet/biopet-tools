#!/bin/bash

for I in `echo */build.sbt | sed "s/\/build.sbt//g"`
do 
	echo "$I "`curl -I https://biopet.github.io/$I/develop/index.html | grep HTTP`
done


