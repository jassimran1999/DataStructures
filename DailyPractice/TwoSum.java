/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
*/
//approach1: sort and use 2 pointers
//approach2: using hashmap
import java.util.*;
public class TwoSum
{
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
        System.out.println("Enter target");
        int target=sc.nextInt();
        ArrayList<Integer>list=new ArrayList<>();
        int flag=0;
        for(int i=0;i<size;i++)
        {
            if(list.contains(arr[i]))
            {
                flag=1;
                break;
            }
            else
            {
                list.add(target-arr[i]);
            }
        }
        if(flag==1)
            System.out.println("Contains");
        else
            System.out.println("Does not contain");
    }
}
