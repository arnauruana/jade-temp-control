#!/bin/sh

all: compile


compile: out
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/Behaviours/*.java
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/AIAExamples/communication/*.java
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/Protocols/*.java

gui:
	java -cp lib/jade.jar:out/ jade.Boot -gui -local-host 127.0.0.1 &
	ps -o pid,comm | grep java | tr -d [:alpha:],[:space:] > .proc.tmp

hello-world:
	java -cp lib/jade.jar:out/ jade.Boot -local-host 127.0.0.1 -container HelloTio:Behaviours.HelloWorldAgent\("Que","pasa","tio"\) -local-host 127.0.0.1


out:
	mkdir out

kill: .proc.tmp
	./.kill.sh
	rm -f .proc.tmp

clean:
	rm -rf out
	rm -r *.txt

.PHONY: all compile gui hello-world kill clean
