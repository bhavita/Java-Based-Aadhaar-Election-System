import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.net.*;



public class ElectionClient implements Runnable		{
    private Scanner commandScanner;
    private PrintWriter responseWriter;
    public ElectionClient(InputStream in, OutputStream out) {
        this.commandScanner = new Scanner(in);
        this.responseWriter = new PrintWriter(out, true);
    }
    public ElectionClient() {
        this(System.in, System.out);
    }

	public void run()
	{
	
	new MainWindow();
	
	}

	public static void main(String args[])
		{
		ElectionClient ec=new ElectionClient();
		
		}







}