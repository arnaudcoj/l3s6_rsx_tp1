import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SendUDP {
    
    protected BufferedReader in;
    protected MulticastSocket socket;

    public SendUDP(MulticastSocket socket) {
	this.in = new BufferedReader(new InputStreamReader(System.in)); 
	this.socket = socket;
    }

    public String scanf() throws IOException {
	return in.readLine();
    }

    public void run () {
	DatagramPacket packet;
	try {
	    String str = this.scanf();
	    if(str.equals("/part")) {
		//onkite
		System.out.println("tchao");
	    }
	    else { //provisoire
		byte[] msg = str.getBytes();
		packet = new DatagramPacket(msg, msg.length, this.socket.getInetAddress(), this.socket.getPort());
		socket.setTimeToLive(1);
		socket.send(packet);
	    }
	} catch (IOException e) {
	    System.out.println("Tchat (SendUDP): Problème rencontré à l'envoi d'un message");
	}
    }
}
