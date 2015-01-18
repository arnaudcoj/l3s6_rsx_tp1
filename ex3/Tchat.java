import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.lang.String;

public class Tchat {

    protected MulticastSocket socket;
    protected String nickname;
    
    public Tchat(String nickname) throws Exception{
	this.nickname = nickname;
	
	int port = 7654;
	InetAddress dst = InetAddress.getByName("224.0.0.1");

	socket = new MulticastSocket(port);
	socket.joinGroup(dst);
    }

    public void run() throws Exception {
	ReceiveUDP receive = new ReceiveUDP(this.socket);
	SendUDP send = new SendUDP(this.socket, this.nickname);
	Thread trReceive = new Thread(receive);
	Thread trSend = new Thread(send);

	
	trReceive.start();
	trSend.start();
	trSend.join();
	
	this.socket.close();
    }

    public static void main (String[] args) throws Exception {
	String nickname;
	
	System.out.println("Bienvenue dans ce Tchat !");
	System.out.print("> ");
	if(args.length >= 1 && !args[0].equals(""))
	    nickname = args[0];
	else
	    nickname = "Germaine";
	    Tchat tchat = new Tchat(nickname);
	tchat.run();
    }

}
