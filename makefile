#!/bin/sh

all: compile

compile: out
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/Behaviours/*.java
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/AIAExamples/communication/*.java
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/Protocols/*.java

run:
	java -cp lib/jade.jar:out/ jade.Boot -gui -local-host 127.0.0.1 &
	ps -o pid,comm | grep java | tr -d [:alpha:],[:space:] > .proc.tmp

out:
	mkdir out

kill: .proc.tmp
	./.kill.sh
	rm -f .proc.tmp

clean:
	rm -rf out
	rm -f *.txt

.PHONY: all compile gui kill clean
