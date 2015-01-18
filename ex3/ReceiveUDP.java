import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;
import java.lang.Runnable;
import java.io.IOException;

public class ReceiveUDP implements Runnable{

    protected MulticastSocket socket;
    protected int port;
    protected InetAddress dst;
    
    public ReceiveUDP(MulticastSocket socket) throws Exception {
	this.port = 7654;
	this.dst = InetAddress.getByName("224.0.0.1");
	this.socket = socket;
    }

    public void run () {
	DatagramPacket packet; 
	byte[] msg;
	String str;
	while(!this.socket.isClosed()) {
	    packet = new DatagramPacket(new byte[512], 512);

	    try {
		this.socket.receive(packet);

		if(!packet.getAddress().equals(this.dst)) {
		    System.out.println("paquet reçu de " + packet.getAddress() + " port " + packet.getPort() + " taille " + packet.getLength());
		
		    msg = packet.getData();
		    str = new String(msg);
		    System.out.println(str);
		    System.out.print("> ");
		}
	    } catch(IOException e) {
		if(!this.socket.isClosed()) {
		   System.out.println("Tchat (ReceiveUDP): Problème rencontré à la réception d'un message");
		}
	    }
	}
    }

}
