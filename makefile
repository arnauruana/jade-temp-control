all: compile


compile: out
	javac -cp lib/jade.jar -d out/ -sourcepath src/ src/behaviour/*.java

gui:
	java -cp lib/jade.jar:out/ jade.Boot -gui -local-host 127.0.0.1 &

thermometer:
	java -cp lib/jade.jar:out/ jade.Boot -local-host 127.0.0.1 -container thermometer:behaviour.TickerBehaviourAgent\(\) &

thermostat:
	java -cp lib/jade.jar:out/ jade.Boot -local-host 127.0.0.1 -container thermostat:behaviour.CyclicBehaviourAgent\(\) &

run: thermostat thermometer


out:
	mkdir out

clean:
	rm -rf out
	rm -f *.txt


.PHONY: all compile gui kill clean run thermometer thermostat
