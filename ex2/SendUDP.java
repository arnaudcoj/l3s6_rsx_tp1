/**
 *  TP1 Réseaux - UDP et Multicast
 *  Exercice 2
 *  Matthieu Caron
 *  Arnaud Cojez
 */

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

/**
 * Class used to send a message
 */
public class SendUDP {
    
    public static void main (String[] args) throws Exception {
	DatagramPacket packet;
	InetAddress dst = InetAddress.getByName("224.0.0.1");
	int port = 7654;
	byte[] array = args[0].getBytes();
	packet = new DatagramPacket(array, array.length, dst, port);
	MulticastSocket socket = new MulticastSocket();
	socket.setTimeToLive(1);
	socket.send(packet);
	socket.close(); 
    }
}
