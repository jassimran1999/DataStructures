//Top view of a tree
import java.util.*;

class TopView extends BST
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of BST");
        int n=sc.nextInt();
        BST tree=new BST();
        for(int i=0;i<n;i++)
        {
            tree.insert(sc.nextInt());
        }
        tree.topView();
    }
}

class BST
{
    class Node
    {
        int key;
        int hd;
        Node left,right;
    
        Node(int key)
        {
            this.key=key;
        }
        Node(int key,int hd)
        {
            this.key=key;
            this.hd=hd;
        }
    }
    Node root;
    BST()
    {
        root=null;
    }

    Node insert_node(Node n,int key)
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

    Node insert_node(Node n,int key,int hd)
    {
        if(n==null)
        {
            return new Node(key,hd);
        }
        if(n.key==key)
        {
            return n;
        }
        if(n.key>key)
        {
            n.left=insert_node(n.left, key,hd);
        }
        else if(n.key<key)
        {
            n.right=insert_node(n.right, key,hd);
        }
        return n;
    }
    void inorderTraversal(Node n)
    {
        if(n==null)
        {
            return;
        }
        else
        {
            inorderTraversal(n.left);
            System.out.print(n.hd+" ");
            inorderTraversal(n.right);
        }
    }
    void insert(int key)
    {
        root=insert_node(root, key);
    }
    void insert(int key,int hd)
    {
        root=insert_node(root,key,hd);
    }
    void inorder()
    {
        inorderTraversal(root);
    }
    void horizontalDistance(Node n,int hd,BST top)
    {
        if(n==null)
        {
            return;
        }
        top.insert(hd,n.key);       //inserting hd as key of node
        horizontalDistance(n.left,hd-1,top);
        horizontalDistance(n.right, hd+1, top);
    }
    void topView()
    {
        BST top=new BST();
        horizontalDistance(root,0,top);
        top.inorder();
    }
}

