package DataStructures.BST;

//import java.util.*;

public class BST
{
    class Node
    {
        int key;
        Node left,right;
        Node(int data)
        {
            key=data;
            left=null;
            right=null;
        }
    }
    public Node root;
    public BST()
    {
        root=null;
    }
    public Node insert_node(Node n,int key)
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
    
    public void inorderTraversal(Node n)
    {
        if(n==null)
        {
            return;
        }
        else
        {
            inorderTraversal(n.left);
            System.out.print(n.key+" ");
            inorderTraversal(n.right);
        }
    }
    
    public int search_node(Node n,int key)
    {
        if(n==null)
        {
            return 0;
        }
        if(n.key==key)
        {
            return 1;
        }
        if(n.key>key)
        {
            return search_node(n.left,key);
        }
        return search_node(n.right,key);
    }
    public int getMin(Node n)
    {
        if(n.left==null)
        {
            return n.key;
        }
        else
        {
            return getMin(n.left);
        }
    }
    public Node delete_node(Node n,int key)
    {
        if(n==null)
        {
            return n;
        }
        if(n.key>key)
        {
            n.left=delete_node(n.left,key);
        }
        else if(n.key<key)
        {
            n.right=delete_node(n.right,key);
        }
        else 
        {
            if(n.right==null)
            {
                return n.left;
            }
            if(n.left==null)
            {
                return n.right;
            }
            else
            {
                n.key=getMin(n.right);
                n.right=delete_node(n.right,n.key);
                return n;
            }
            
        }
        return n;
    }
    public void insert(int key)
    {
        root=insert_node(root,key);
    }
    public void inorder()
    {
        inorderTraversal(root);
    }
    public int search(int key)
    {
        return search_node(root,key);
    }
    public void delete(int key)
    {
        root=delete_node(root,key);
    }
    /*public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of BST");
        int n=sc.nextInt();
        BST tree=new BST();
        for(int i=0;i<n;i++)
        {
            tree.insert(sc.nextInt());
        }
        System.out.println("Inorder BST traversal");
        tree.inorder();
        System.out.println("\nEnter key to be searched");
        int find=sc.nextInt();
        if(tree.search(find)==1)
        {
            System.out.println(find+" found.");
        }
        else
        {
            System.out.println(find+" not found.");
        }
        System.out.println("Enter key to be deleted");
        int del=sc.nextInt();
        tree.delete(del);
        System.out.println("After deletion of "+del);
        tree.inorder();
        sc.close();
    }*/
}