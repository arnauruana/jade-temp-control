# JadeApplication

## IntelliJ

1. Open folder in IntelliJ (do not use Import).
2. Configurations are available at the dropdown on the top right part of the IDE.

## NetBeans 8

To compile, just open the project (do not use Import) from the IDE.
Classes are compiled automatically once the files are saved.

To compile from command line:

```bash
$ ant jar
```

To run the GUI, from the configuration in NetBeans or from command-line:

(From Linux)
```bash
$ java -cp lib/jade.jar:dist/JadeApplication.jar jade.Boot -gui
-local-host 127.0.0.1
```

(From Windows)
```bash
\> java -cp lib\jade.jar;dist\JadeApplication.jar jade.Boot -gui
```

To run the HelloWorldAgent, from the configuration in NetBeans (be
careful! You can only run one configuration at a time unlike in
IntelliJ) or from command-line:

(From Linux)
```bash
$ java -cp lib/jade.jar:dist/JadeApplication.jar jade.Boot -local-host 127.0.0.1 -container HelloTio:org.upc.edu.Behaviours.HelloWorldAgent\("Que","pasa","tio"\)
```

(From Windows)
```bash
\> java -cp lib\jade.jar;dist\JadeApplication.jar jade.Boot -container HelloTio:org.upc.edu.Behaviours.HelloWorldAgent("Que","pasa","tio")
```

## Linux shell

To compile:

```bash
$ make
```

To run the platform and GUI:

```bash
$ make gui
```

To run the HelloWorldAgent:

```bash
$ make hello-world
```

## Windows shell

To compile:

```bash
\> make.bat
```

To run the platform and GUI:

```bash
\> runGui.bat
```

To run the HelloWorldAgent:

```bash
\> runHelloWorld.bat
```

