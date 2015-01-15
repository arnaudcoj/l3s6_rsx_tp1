import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

public class SendUDP {
    
    public static void main (String[] args) throws Exception {
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress dst = InetAddress.getByName("224.0.0.1");
	int port = 7654;
	byte[] array = args[0].getBytes();
	packet = new DatagramPacket(array, array.length, dst, port);
	socket = new DatagramSocket();
	socket.setTimeToLive(1);
	socket.send(packet);
	socket.close(); 
    }
}
