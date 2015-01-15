JC = javac                           
EXEC = ReceiveUDP SendUDP

all: $(EXEC)

%: %.java
	$(JC) $^

test: ReceiveUDP SendUDP
	java ReceiveUDP 1500 &
	java SendUDP localhost 1500 "test réussi"

clean:
	rm -rf *.class *~
