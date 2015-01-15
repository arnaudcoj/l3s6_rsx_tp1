import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;
import java.lang.Runnable;
import java.io.IOException;

public class ReceiveUDP implements Runnable{

    protected MulticastSocket socket;

    public ReceiveUDP(MulticastSocket socket) {
	this.socket = socket;
    }

    public void run () {
	DatagramPacket packet; 
	byte[] msg;
	String str;
	while(true) {
	    packet = new DatagramPacket(new byte[512], 512);

	    try {
		this.socket.receive(packet);
		
		System.out.println("paquet reçu de " + packet.getAddress() + " port " + packet.getPort() + " taille " + packet.getLength());
		
		msg = packet.getData();
		str = new String(msg);
		System.out.println(str);
	    } catch(IOException e) {
		System.out.println("Tchat (ReceiveUDP): Problème rencontré à la réception d'un message");
	    }
	}
    }
}
