import java.util.*;
//Kth smallest element in a BST in O(1) space
//Sum of elements smaller than or equal to kth smallest element
public class KthSmallest
{
    static class Node
    {
        int key;
        Node left,right;
        Node()
        {

        }
        Node(int data)
        {
            key=data;
            left=null;
            right=null;
        }
    }
    
    public static Node insert_node(Node n,int key)
    {
        if(n==null)
        {
            n=new Node(key);
           
            return n;
        }
        if(n.key==key)
        {
            System.out.println("Key already exists in the BST");
            return n;
        }
        if(n.key>key)
        {
            n.left=insert_node(n.left,key);
        }
        else
        {
            n.right=insert_node(n.right,key);
        }
        return n;
    }
    static int count=0;
    static int sum=0;
    static void kth(Node n,int k)
    {
        
        if(n==null)
        {
            return;
        }

        kth(n.left,k);
        count++;
        if(count<=k)
        {
            sum+=n.key;
        }
        if(count==k)
        {
            System.out.println("Required element is "+n.key);
            return;
        }
        
        
        kth(n.right,k);
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of BST");
        int n=sc.nextInt();
        Node root=null;
        for(int i=0;i<n;i++)
        {
            root=insert_node(root,sc.nextInt());
            //System.out.println(root.key);
        }
        System.out.println("Enter K");
        int k=sc.nextInt();
        //System.out.println(root.key);
       // final int count=1;
        kth(root,k);
        System.out.println("Sum is "+sum);
    }
}