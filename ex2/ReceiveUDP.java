import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

public class ReceiveUDP {

    public static void main (String[] args) throws Exception {
	DatagramPacket packet; 
	MulticastSocket socket;
	String str;
	while(true) {
	    socket = new MulticastSocket(7654);
	    packet = new DatagramPacket(new byte[512], 512);

	    socket.joinGroup(InetAddress.getByName("224.0.0.1"));
	    socket.receive(packet);

	    System.out.println("paquet reçu de " + packet.getAddress() + " port " + packet.getPort() + " taille " + packet.getLength());

	    byte array[] = packet.getData();
	    str = new String(array);
	    System.out.println(str);

	socket.close();
	}

    }
}
