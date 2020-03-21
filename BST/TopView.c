#include<stdio.h>
#include<stdlib.h>
typedef struct Tree
{
  int data;
  struct Tree* left;
  struct Tree* right;
}Tree;

typedef  struct STree
{
  Tree* node;
  int dist;
}STree;

typedef struct Node
{
  STree* snode;
  struct Node* next;
}Node;

typedef struct Queue
{
  struct Node* front;
  struct Node* rear;
}Queue;

typedef struct Map
{
  int key;
  int value;
}Map;

typedef struct LL
{
  Map m;
  struct LL* next;
}LL;

void pushFront(LL** l, int data, int dist)
{
  LL* l1=(LL*)malloc(sizeof(int));
  l1->m.key=dist;
  l1->m.value=data;
  l1->next=*l;
  *l=l1;
}

void pushBack(LL** l, int data, int dist)
{
  LL* l1=(LL*)malloc(sizeof(int));
  l1->m.key=dist;
  l1->m.value=data;
  LL *curr=*l;
  if(curr==NULL)
  {
    l1->next=*l;
    *l=l1;
  }
  else
  {
    while(curr->next)
      curr=curr->next;
    curr->next=l1;
    l1->next=NULL;
  }
}

int find(LL *l, int dist)
{
  LL* curr=l;
  while(curr)
  {
    if(curr->m.key==dist)
      return 1;
    curr=curr->next;
  }
  return 0;
}

void pushQueue(Queue* q, STree* nn)
{
  Node* n=(Node*)malloc(sizeof(Node));
  n->snode=nn;
  n->next=NULL;
  if(q->rear==NULL)
  {
    q->front=n;
    q->rear=n;
  }
  else
  {
    q->rear->next=n;
    q->rear=n;
  }
}

void popQueue(Queue* q)
{
  if(q->rear==NULL)
    return;
  else
  {
    q->front=q->front->next;
    if(q->front == NULL)
      q->rear = NULL;
  }
}

int isEmpty(Queue* q)
{
  if(q->front==NULL)
    return 1;
  return 0;
}

Tree* insertTree(Tree* root, int d)
{
  if(root==NULL)
  {
    Tree* tn=(Tree*)malloc(sizeof(Tree));
    tn->data=d;
    tn->left=NULL;
    tn->right=NULL;
    return tn;
  }
  if(root->data==d){}
  else if(root->data>d)
  {
    root->left=insertTree(root->left, d);
  }
  else
  {
    root->right=insertTree(root->right, d);
  }
  return root;
}

int main()
{
  Tree* root=NULL;
  int num;
  while(1)
  {
    scanf("%d", &num);
    if(num==-1)
      break;
    root=insertTree(root, num);
  }
  Queue* q=(Queue*)malloc(sizeof(Queue));
  q->front=NULL;
  q->rear=NULL;
  STree * nn=(STree*)malloc(sizeof(STree));
  nn->node=root;
  nn->dist=0;
  pushQueue(q, nn);
  LL *l=NULL;
  while(!isEmpty(q))
  {
    int data = q->front->snode->node->data;
    int dist = q->front->snode->dist;
    if(!find(l,dist))
    {
      if(dist>=0)
      {
        pushBack(&l, data, dist);
      }
      if(dist<0)
      {
        pushFront(&l, data, dist);
      }
    }
    Node* temp=q->front;
    popQueue(q);
    if(temp->snode->node->left)
    {
      STree * st=(STree*)malloc(sizeof(STree));
      st->node=temp->snode->node->left;
      st->dist=temp->snode->dist-1;
      pushQueue(q, st);
    }
    if(temp->snode->node->right)
    {
      STree * st=(STree*)malloc(sizeof(STree));
      st->node=temp->snode->node->right;
      st->dist=temp->snode->dist+1;
      pushQueue(q, st);
    }
  }
  LL *itr = l;
  while(itr!= NULL)
  {
      printf("%d  ",itr->m.value);
      itr = itr->next;
  }
  return 0;
}