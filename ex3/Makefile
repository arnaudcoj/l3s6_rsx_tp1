JC = javac                 

all: Tchat.class

ReceiveUDP.class: ReceiveUDP.java
	$(JC) $^

SendUDP.class: SendUDP.java
	$(JC) $^

Tchat.class: Tchat.java SendUDP.class ReceiveUDP.class
	$(JC) Tchat.java

clean:
	rm -rf *.class *~
