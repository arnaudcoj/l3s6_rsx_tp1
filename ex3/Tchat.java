import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

public class Tchat {

    protected MulticastSocket socket;
    
    public Tchat() throws Exception{
	int port = 7654;
	InetAddress dst = InetAddress.getByName("224.0.0.1");

	socket = new MulticastSocket(port);
	socket.joinGroup(dst);
    }

    public void run() throws Exception {
	ReceiveUDP receive = new ReceiveUDP(this.socket);
	Thread trReceive = new Thread(receive);
	trSend.join();
	trReceive.run();
	trSend.run();//TODO gérer 2 threads
	this.socket.close();
    }

    public static void main (String[] args) throws Exception {
	Tchat tchat = new Tchat();
	tchat.run();
    }
	



/*
    public static void main (String[] args) throws Exception {

	DatagramPacket receivePacket; 
	DatagramPacket sendPacket;

	String receiveStr;
	InetAddress dst = InetAddress.getByName("224.0.0.1");
	int port = 7654;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
	String str;
	byte[] receiveArray;
	byte[] sendArray;

	while(true) {
	    receiveSocket = new MulticastSocket(port);
	    receivePacket = new DatagramPacket(new byte[512], 512);

	    receiveSocket.joinGroup(dst);
	    receiveSocket.receive(receivePacket);

	    System.out.println("paquet reçu de " + receivePacket.getAddress() + " port " + receivePacket.getPort() + " taille " + receivePacket.getLength());

	    receiveArray = receivePacket.getData();
	    receiveStr = new String(array);
	    System.out.println(receiveStr);

	    
	    
	    sendArray = args[0].getBytes();

	    sendPacket = new DatagramPacket(array, array.length, dst, port);
	    sendSocket.setTimeToLive(1);
	    sendSocket.send(sendPacket);
	    sendSocket.close(); 
    }*/
}
