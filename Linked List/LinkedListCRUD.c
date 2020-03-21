#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int data;
    struct node* next;
}node;
void insert(node** h,int d)                 //insert element at the end of linked list
{
    node* newNode=(node*)malloc(sizeof(node));
    newNode->data=d;
    newNode->next=NULL;
    if(*h==NULL)
    {
        *h=newNode;
    }
    else
    {
        node* curr=*h;
        while(curr->next!=NULL)
        {
            curr=curr->next;
        }
        curr->next=newNode;
    }
    
}
void delete(node** head,int del)
{
    node* curr=*head;
    if(*head==NULL)
    {
        return;
    }
    if(curr->data==del)
    {
        node* temp=*head;
        *head=(*head)->next;
        free(temp);
    }
    else
    {
        while(curr->next)
        {
            if(curr->next->data==del)
            {
                node* temp=curr->next;
                curr->next=curr->next->next;
                free(temp);
            }
            else
            {
                curr=curr->next;
            }
            
        }
    }
    
}
void print(node* head)
{
    node* curr=head;
    while(curr)
    {
        printf("%d ",curr->data);
        curr=curr->next;
    }
}
int main()
{
    node* head=NULL;
    printf("Number of elements in list?\n");
    int n;
    scanf("%d",&n);
    printf("Enter Linked List elements\n");
    for(int i=0;i<n;i++)
    {
        int num;
        scanf("%d",&num);
        insert(&head,num);
    }
    printf("The linked list is\n");
    print(head);
    printf("\nEnter node to delete\n");
    int del;
    scanf("%d",&del);
    delete(&head,del);
    print(head);
}