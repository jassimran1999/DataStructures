/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6]
*/
import java.util.*;

public class ProductArray
{
    static void product(int arr[])
    {
        int arr1[]=new int[arr.length];
        int arr2[]=new int[arr.length];
        int res[]=new int[arr.length];
        int i=0,j=arr.length-1,pro=1;
        arr1[i++]=1;
        arr2[j--]=1;
        while(i<arr.length)
        {
            pro*=arr[i-1];
            arr1[i]=pro;
            i++;
        }
        pro=1;
        while(j>=0)
        {
            pro*=arr[j+1];
            arr2[j]=pro;
            j--;
        }
        for(i=0;i<arr.length;i++)
        {
            res[i]=arr1[i]*arr2[i];
            System.out.println(res[i]);
        }
       // System.out.println(res);
       // return res;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size and array");
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        product(arr);
       // System.out.println(product(arr));
    }
}