import java.util.*;
import java.lang.*;
import java.io.*;

public class DynamicList()
{
	int id;
	float val;
	String name;
	String data;
	
	private class Node{
	int nodenum;
	String nodeid;
	String rid;
	String cr_id;
	String gr_id;
	Date timestamp;
	String data;
	ArrayList<Node> children;
	public Node(int id, float val, String name,String data)
	{
		this.id=id;
		this.val=val;
		this.name=name;
		this.data=data;
		nodeid=null;
		rid=null;
		cr_id=null;
		gr_id=null;
		timestamp=null;
		this.children=new ArrayList<>();
	}
}
	private Node root;
	private int size;
	public DynamicList()
	{
		Scanner sc=new Scanner(System.in);
		this.root=this.takeinput(sc,null,0);
	}
	
	//Creating Genesis Node - Point number 1
	public Node takeinput(Scanner sc, Node parent,int ithchild)
	{
		if(parent==null)
		{
			System.out.println("Enter data for root node");
		}
		else{
			System.out.println("Enter data for"+ithchild+" of parent: "+parent.data);
		}
		System.out.println("Enter record - Owner ID");
		int id=sc.nextInt();
		System.out.println("Enter record - Value");
		float val=sc.nextFloat();
		System.out.println("Enter record - Owner Name");
		String str=sc.next();
		System.out.println("Enter record - Node Data");
		String data=sc.next();
		Node n = new Node(id,val,str,data);
		this.size++;
	    
	    //Creating Set of Child Nodes - Point Number 2
	    System.out.println("Enter number of children");
	    int nc=sc.nextInt();
	    for(int i=0;i<nc;i++)
	    {
	    	//Creating particular Child Node - Point Number 3
	    	Node child=takeinput(scn,n,i);
	    	float g = computechildsum(parent);
	    	if(g<parent.val)
	    	{
	    		n.children.add(child);
	    	}
	    	else{
	    		continue;
	    	}
	    }
	    return n;
	}
	
	//Verifying that no new node has value greater than that of child
	public float computechildsum(Node node){
		return this.computechildsum(this.node);
	}
	
	private float computechildsum(Node node){
		float sum=0.0f;
		for(int i=0;i<node.children.size();i++)
		{
			sum=sum+node.children.get(i).value;
		}
		return sum;
	}
	
	public void display(){
		this.display(this.root);
	}
	
	private void display(Node node)
	{
		System.out.print(node.id + " " + node.val + " "+ node.name+" "+node.data);
		System.out.println();
		for(int i=0;i<node.children.size();i++)
		{
			System.out.print(node.children.get(i).id+" "+node.children.get(i).val+" "+node.children.get(i).name+" "+node.children.get(i).data+" ");
		}   System.out.println();
	
		System.out.println("END");
		
		for(int i=0;i<node.children.size();i++)
		{
			display(node.children.get(i));
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public int size2(){
		return this.size2(this.root);
	}
	
	private int size2(Node node)
	{
		int size=0;
		for(int i=0;i<node.children.size();i++)
		{
			size+=size2(node.children.get(i));
		}
		
		//for myself
		
		size+=1;
		return size;
	}
	
	/*public int max(){
		return this.max(this.root);
	}
	
	private int max(Node node)
	{
		return 0;
	}
	*/
	//Finding longest chain of any node - Point number 9
	//Also works for root
	//Finding longest chain of root node - Point number 8
	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node)
	{
		int height=-1;
		for(int i=0;i<node.children.size();i++)
		{
			int childheight=height(node.children.get(i));
			if(childheight>height)
			{
				height=childheight;
			}
		}
		
		return height+1;
	}
	/*
	public boolean find(int data)
	{
		return find(this.root,data);
	}
	
	private boolean find(Node node, int data){
		return false;
	}
	*/
		public String encrypt(Node node){
		return this.encrypt(this.node);
	}
  //Encrypt and Decrypt Data inside the node - Point number 4
  //I am uploading the un-encrypted values in hashmap corresponding to generated keys
	private String encrypt(Node node)
	{
		HashMap<Integer,String> map = new HashMap<>();
		int o = node.id;
		String n = node.name;
		int x = (int)n.charAt(0);
		key=o+x;
		String d1 = node.data;
		int y = Integer.parseInt(d1);
		int key2=key+y;
		String finalstr=Integer.toString(key2);
	    map.put(key,d1);
	    
	    return finalstr;
	}
	
		public String decrypt(Node node){
		return this.decrypt(this.node);
	}
  //Encrypt and Decrypt Data inside the node - Point number 4
	private String decrypt(Node node)
	{
		String d1 = node.data;
		int y = Integer.parseInt(d1);
		int o = node.id;
		String n = node.name;
		int x = (int)n.charAt(0);
		key=o+x;
		int new1=y-key;
		String str = map.get(key);
		//Verifying the owner of the node by decryption and computing hash - Point number 5
	    if(str.equals(new1))
	    {
	    	System.out.println("Successful Decryption!");
	    }
	    else{
	    	System.out.println("You are not authorized to decrypt this data");
	    }
	    return str;
	}
	
	//Function to edit values in a node - Point number 6
	public void edit(Node node, int newval){
	    this.edit(this.node,this.newval);
	}
	
	private void edit(Node node, int newval){
		int x = node.val;
		x-=x;
		x=newval;
		node.val=x;
	}
}
	