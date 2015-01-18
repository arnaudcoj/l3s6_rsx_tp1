import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SendUDP implements Runnable {
    
    protected BufferedReader in;
    protected MulticastSocket socket;
    protected InetAddress dst;
    protected int port;
    protected String nickname;

    public SendUDP(MulticastSocket socket, String nickname) throws Exception {
	this.nickname = nickname;
	this.in = new BufferedReader(new InputStreamReader(System.in)); 
	this.socket = socket;
	this.port = 7654;
	this.dst = InetAddress.getByName("224.0.0.1");
    }

    public String scanf() throws IOException {
	return in.readLine();
    }

    public void run () {
	DatagramPacket packet;
	String str = null;
	try {
	    while(!(str = this.scanf()).equals("/part")) {
		byte[] msg = (this.nickname + " > " + str).getBytes();
		packet = new DatagramPacket(msg, msg.length, dst, port);
		socket.setTimeToLive(1);
		socket.send(packet);
	    }	
	} catch (IOException e) {
	    System.out.println("Tchat (SendUDP): Problème rencontré à l'envoi d'un message");
	}
	System.out.println("tchao");
    }
    
}
