class Node{
	public String data;
	public Node next;
	 public Node()
	    {
	        next = null;
	        data = "";
	    }    
	    public Node(String d)
	    {
	        data = d;
	    }
	    public void setLink(Node n)
	    {
	        next = n;
	    }    
	    public void setData(String d)
	    {
	        data = d;
	    }  
	    public Node getLink()
	    {
	        return next;
	    }   
	    public String getData()
	    {
	        return data;
	    }
}
public class linkedlist{
	private Node head;
	private Node end;
	private int size;
	public linkedlist() {
		head = null;
		end = null;
		size = 0;
	}
	public linkedlist(Node x) {
		head = x;
		end = null;
		size = 1;
	}
	public boolean isEmpty()
    {
        return head == null;
    }
	public int getSize()
    {
        return size;
    }
	public void add(String userName){
		Node n = new Node(userName);
		size++;
		n.next = head;
		head = n;
		
	}
	 public boolean remove(String key)
	    {
	        Node temp = head, prev = null;

	        if (temp != null && temp.data.compareTo(key) == 0)
	        {
	            head = temp.next;
	            return true;
	        }
	        while (temp != null && temp.data.compareTo(key) != 0)
	        {
	            prev = temp;
	            temp = temp.next;
	        }    
	        if (temp == null) return false;
	        
	        prev.next = temp.next;
	        if (temp != null) {return true;}
	        return false;
	    }
	 public boolean find(String userName) {
		 Node x = head; 
		 while (x != null) {
			 if (x.data.compareTo(userName) == 0) {
				 return true;
			 }
			 x=x.next;
		 }
		 return false;
	 }
	 public String toString() {
		 String list = "";
		 Node x = head;
		 while (x != null) {
			 list += x.data + ", ";
			 System.out.println(x.data);
			 x = x.next;
		 }
		 return list;
	 }
}