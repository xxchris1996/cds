#include "stdio.h"
#include "stdlib.h"
typedef  struct  node//����������洢�ṹ
{  int  data;/*������*/
   struct  node  *next;//ָ���򣬽���������Ԫ��֮�������
//��ϵ
}node;

void outlist(node *p)//��ʾ������
{while(p!=NULL)
 {printf("%d->",p->data);
  p=p->next;
}
 printf("null\n");
}




//����������
node *  CreatList( ) //����һϵ������,��0��־����,����Щ������Ϊdata����һ��������
{node  *head, *p, *s;
 int x,cycle=1; 
 head=(node *)malloc(sizeof(node)); 
 p=head;
 while(cycle)
 {scanf("%d",&x);
  if(x!=0)
  {s=(node *)malloc(sizeof(node));
   s->data=x;
   p->next=s;
   p=s;
  }
  else  cycle=0;
 }
p->next=NULL;/*������ѭ������ʱ��p->next=head��*/
printf("���������ã�");
outlist(head->next);
return  head;
} 

int  FindList(node * head, int x)// �ڵ������в���ֵΪx�Ľ��
{node *p;
 p=head->next;//����ͷ���
 while(p!=NULL&&p->data!=x) p=p->next;
 if(p!=NULL)
  { printf("����ҵ���!\n"); return 1;}
 else
 {printf("���δ�ҵ�!\n"); return 0;}
}

void InsertList(node * &head, int i, int x)// �ڵ������е�i�����֮�����ֵΪx�Ľ��
{node *s, *p;
 int j;
 s=(node * ) malloc(sizeof(node));/*������������*/
 s->data=x;
 p=head; j=0; 
  while(p!=NULL&&j<i)
  {j++;j<i;} /*p��j����ͬ��*/
  if(p!=NULL)
  {
	  s->next=p->next;  
	  p->next=s; 
  }
 else
 printf("����λ�ò���ȷ!\n");
 }

void DeleteList (node * &head, int x)//�ڵ�������ɾ��ֵΪx�Ľ��
{node *p, *q; /*ɾ������ʱ,����һ��ָ��qָ��ǰ����ǰ�����*/
 q=head;p=head->next; 
 while(p!=NULL && p->data!=x)
 {q=p;p=p->next;} /*qʼ����p��ǰ��*/
 if(p!=NULL) /*�ҵ����,����ɾ������*/
 {q->next=p->next;
   free(p);
 }
 else
 printf("�������޸ý��!\n");
}

int LengthList(node * head)//������ĳ���
{int n=0;
 node *p;
 p=head;
 while(p!=NULL)
 {p=p->next;
  n++;
 }
return n;
}

int main()
{node * list;int n,i,x,len;
 printf("1---������Ԫ�ؽ���������������0��ʾ����:\n");
 list=CreatList( );//����������
 printf("2---������Ҫ���ҵ�Ԫ�أ�");
 scanf("%d",&x);
 n=FindList(list, x);//����ֵΪx��Ԫ��
 printf("3---�ڵ������е�i�����֮�����ֵΪx�Ľ�㣬������i��x��ֵ��");
 scanf("%d,%d",&i,&x);
 InsertList(list, i, x);// �ڵ������е�i�����֮�����ֵΪx�Ľ��
 outlist(list->next );
 printf("4---ɾ����������ֵΪx�Ľ�㣬������x��ֵ��");
 scanf("%d",&x);
 DeleteList (list,x);//�ڵ�������ɾ��ֵΪx�Ľ��
 outlist(list->next );
 len=LengthList(list);//��������
 printf("5---������ĳ���Ϊ%d:",len);
 return 0;
}
