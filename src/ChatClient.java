import java.net.*;
import java.io.*;
 
public class ChatClient {
	//class
    private String hostname;
    private int port;
    private String userName;
    //constructor overloading
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
 
    public void exec() {
        try {
            Socket socket = new Socket(hostname, port);
 
            System.out.println("Connected to the chat server");
 
            new Reading(socket, this).start();
            new Writing(socket, this).start();
 
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
        //String hostname = args[0];
        int port = 8989;
        ChatClient client;
        if (args.length == 0) {
        	 client = new ChatClient();
        }
        else if (args.length == 2) {
        	client = new ChatClient(args[0], Integer.valueOf(args[1]));
        }
        else if (isInteger(args[0])){
        	client = new ChatClient(Integer.valueOf(args[0]));
        }
        else {
        	client = new ChatClient(args[0]);
        }
        client.exec();
    }
    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}