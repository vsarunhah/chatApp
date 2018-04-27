import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class QNode
{
    String key;
    QNode next;
     
    // constructor to create a new linked list node
    public QNode(String key) {
        this.key = key;
        this.next = null;
    }
}
public class DataQueue {
	QNode front, rear;
	linkedlist ll = new linkedlist();
	File input =  new File("messages.txt");
	//BufferedReader reader;
	//BufferedWriter writer;
	PrintWriter out;
	BufferedReader br;
	
	public DataQueue() throws IOException {
	if (!input.isFile()) {
        try {
			input.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }
	try {
		//reader = new BufferedReader(new FileReader(input));
		//writer = new BufferedWriter(new FileWriter(input));
		out = new PrintWriter(new FileWriter(input, true));
		br = new BufferedReader(new FileReader(input));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.front=this.rear=null;
	enqueueall();
	}
	
	public DataQueue(File x) throws IOException {
		if (!x.isFile()) {
		       try {
				x.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }
		try {
			//reader = new BufferedReader(new FileReader(x));
			//writer = new BufferedWriter(new FileWriter(x));
			out = new PrintWriter(new FileWriter(x, true));
			br = new BufferedReader(new FileReader(x));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.front=this.rear=null;
		enqueueall();
	}
	
	 
	      
	    // Method to add an key to the queue.  
	    void enqueue(String key)
	    {
	         
	        // Create a new LL node
	        QNode temp = new QNode(key);
	        
	        // If queue is empty, then new node is front and rear both
	        if (this.rear == null)
	        {
	           this.front = this.rear = temp;
	           return;
	        }
	      
	        // Add the new node at the end of queue and change rear
	        this.rear.next = temp;
	        this.rear = temp;
	        out.append("\n" + temp.key);
	        out.close();
	    }
	      
	    // Method to remove an key from queue.  
	    QNode dequeue()
	    {
	        // If queue is empty, return NULL.
	        if (this.front == null)
	           return null;
	      
	        // Store previous front and move front one node ahead
	        QNode temp = this.front;
	        this.front = this.front.next;
	      
	        // If front becomes NULL, then change rear also as NULL
	        if (this.front == null)
	           this.rear = null;
	        
	        return temp;
	    }
	    void enqueueall() throws IOException {
	    	String st;
			  while ((st = br.readLine()) != null) {
				  enqueue(st);
			  }
	    }
}
