import java.net.*;
import java.io.*;
 
public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
 
    public ChatClient(String hostname) {
        this.hostname = hostname;
        this.port = 8989;
    }
    
    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
    
    public ChatClient(int port) {
    	this.hostname = "localhost";
    	this.port = port;
    }
    public ChatClient() {
    	this.hostname = "localhost";
    	this.port = 8989;
    }
 
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
 
            System.out.println("Connected to the chat server");
 
            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();
 
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
 
    }
 
    void setUserName(String userName) {
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
 
 
    public static void main(String[] args) {
        //if (args.length < 1) return;
        String hostname = args[0];
        int port = 8989;
 
        ChatClient client = new ChatClient(hostname);
        client.execute();
    }
}