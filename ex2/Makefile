JC = javac                 

all: ReceiveUDP.class SendUDP.class

ReceiveUDP.class: ReceiveUDP.java
	$(JC) $^

SendUDP.class: SendUDP.java
	$(JC) $^

test: ReceiveUDP.class SendUDP.class
	java ReceiveUDP &
	java SendUDP "test réussi"

clean:
	rm -rf *.class *~
