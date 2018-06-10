import java.io.*;
import java.net.*;
public class Reading extends Thread {
	//inheritance
	 private BufferedReader reader;
	    private Socket socket;
	    private ChatClient client;
	 
	    public Reading(Socket socket, ChatClient client) {
	        this.socket = socket;
	        this.client = client;
	 
	        try {
	            InputStream input = socket.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(input));
	        } catch (IOException ex) {
	            System.out.println("Error getting input stream: " + ex.getMessage());
	            ex.printStackTrace();
	        }
	    }
	 //overriding
	    public void run() {
	        while (true) {
	            try {
	                String response = reader.readLine();
	                System.out.println("\n" + response);
	                // prints the username after displaying the server's message
	                if (client.getUserName() != null) {
	                    System.out.print("[" + client.getUserName() + "]: ");
	                }
	            } catch (IOException ex) {
	                System.out.println("Error reading from server: " + ex.getMessage());
	                ex.printStackTrace();
	                break;
	            }
	        }
	    }
}