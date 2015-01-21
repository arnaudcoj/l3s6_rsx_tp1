/**
 *  TP1 Réseaux - UDP et Multicast
 *  Exercice 1
 *  Matthieu Caron
 *  Arnaud Cojez
 */

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

/**
 * Class used to send a message
 */
public class SendUDP {
    
    public static void main (String[] args) throws Exception {
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress dst = InetAddress.getByName(args[0]);
	int port = Integer.parseInt(args[1]);
	byte[] array = args[2].getBytes();

	packet = new DatagramPacket(array, array.length, dst, port);
	socket = new DatagramSocket();

	socket.send(packet);

	socket.close(); 
    }
}
