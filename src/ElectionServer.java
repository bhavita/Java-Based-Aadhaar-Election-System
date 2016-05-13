import java.io.*;
import java.net.*;

public class ElectionServer {
    private ServerSocket board;
    private MainWindow mw;

    public ElectionServer(int port) throws IOException {
        this.board = new ServerSocket(port);
        //this.mw = mainw;
    }
    public void run() throws IOException {
        while (true) {
            Socket s = this.board.accept();
            System.out.println("Got connected from :"+s.getInetAddress()+":"+s.getPort());
           // Runnable r = new ElectionServer(s.getInputStream(), s.getOutputStream(),mw);
		   Runnable r = new MainWindow();
            Thread th = new Thread(r);
            th.start();
        }
    }
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(args[0]);
		//MainWindow mw=new MainWindow();
        ElectionServer server = new ElectionServer(port);
        server.run();
    }
	
}
