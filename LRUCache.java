import java.util.Map;
import java.util.HashMap;

/**
 *  LRUCache class
 */

class LRUCache
{
	private Node start;
	private Node end;
	private Map<String,Node> LRUData;
	private int size;
    
	/**
	 * Initialize size and map
	 */
	public LRUCache(int size)
	{
		this.LRUData=new HashMap();
		this.size=size;
	}
    
	/**
	 * Save key and value onto Cache
	 */
	public boolean set(String key,String value)
	{
		if(LRUData.containsKey(key))
		{
			Node n=LRUData.get(key);
			n.data=value;
			moveToFirst(n);
			return true;
		}
		if(LRUData.size()>=size)
		{
			LRUData.remove(end.key);
			deleteEndNode();
		}
		Node n=addNode(key,value);
		LRUData.put(key,n);
		return true;
	}
 
	/**
	 * Read value back from cache might throw IllegalArgumentException
	 */
	public String get(String key)
	{
		if(LRUData.containsKey(key))
		{
			moveToFirst(LRUData.get(key));
			return LRUData.get(key).data;
		}
		else
			throw new IllegalArgumentException("NOTFOUND");
    }

	/**
	 * add Node to double linked list
	 */
	private Node addNode(String key,String data)
	{
	 	Node n=new Node(key,data);
		if(start==null)
		{
			start=n;
			end=n;
		}
		else
		{
			start.prev=n;
			n.next=start;
			start=n;
		}
		return n;
	}

	/**
	 * Delete End node from double linked list
	 */
	private void deleteEndNode()
	{
		end=end.prev;
		end.next=null;
	}
    
	/**
	 * Move node to begining of double linked list
	 */
	private void moveToFirst(Node n)
	{
		//Delete the node 	
		if(n.prev!=null)
			n.prev.next=n.next;
		else
			start=n.next;

		if(n.next!=null)
			n.next.prev=n.prev;
		else
			end=n.prev;
		
		//Move to start
		addNode(n.key,n.data);		
	}

}
/**
 * Node class for double linked list 
 */
class Node
{
	String key;
	String data;
	Node next;
	Node prev;

	public Node(String key,String data)
	{
		this.key=key;
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}

