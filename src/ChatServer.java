import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer extends linkedlist {
	//inheritance
    private int port = 8989;
    private Set<UserThread> userThreads = new HashSet<>();
 
    public void exec() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Chat Server is listening on port " + port);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
 
                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
 
            }
 
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
 
        ChatServer server = new ChatServer();
        server.exec();
    }
 
 
    void sendToAll(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    void addUser(String userName) {
        super.add(userName);
    }

    void removeUser(String userName, UserThread aUser) {
        boolean removed = super.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }
 
    String getUserNames() {
        return super.toString();
    }

    boolean hasUsers() {
        return !super.isEmpty();
    }
}