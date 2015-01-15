import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

public class ReceiveUDP {

    public static void main (String[] args) throws Exception {
	MulticastSocket socket = new MulticastSocket(7654);
	socket.joinGroup(InetAddress.getByName("224.0.0.1"));
	DatagramPacket packet = new DatagramPacket(new byte[512], 512);
	socket.receive(packet);
	System.out.println("paquet reçu de " + packet.getAddress() + " port " + packet.getPort() + " taille " + packet.getLength());
	byte array[] = packet.getData();
	String str = new String(array);
	System.out.println(str);
	/*	for(int i = 0; i < packet.getLength(); i++)
		System.out.println("array["+i+"] = "+array[i]);*/
	socket.close();
    }
}
