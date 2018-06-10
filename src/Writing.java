import java.io.*;
import java.net.*;
public class Writing extends Thread {
	//inheritance
	 private PrintWriter writer;
	    private Socket socket;
	    private ChatClient client;
	 
	    public Writing(Socket socket, ChatClient client) {
	        this.socket = socket;
	        this.client = client;
	 
	        try {
	            OutputStream output = socket.getOutputStream();
	            writer = new PrintWriter(output, true);
	        } catch (IOException ex) {
	            System.out.println("Error getting output stream: " + ex.getMessage());
	            ex.printStackTrace();
	        }
	    }
	 //method overriding
	    public void run() {
	 
	        Console console = System.console();
	 
	        String userName = console.readLine("\nEnter your name: ");
	        client.setUserName(userName);
	        writer.println(userName);
	 
	        String text;
	 
	        do {
	            text = console.readLine("[" + userName + "]: ");
	            writer.println(text);
	 
	        } while (!text.equals("bye"));
	        Runtime.getRuntime().exit(0);
	 
	        try {
	            socket.close();
	        } catch (IOException ex) {
	 
	            System.out.println("Error writing to server: " + ex.getMessage());
	        }
	    }}