#include "stdio.h"
#include "stdlib.h"
#define m0 100  //ָ��˳����е����ռ�
typedef struct queue  //˳����д洢�ṹ����
{char q[m0];
 int front,rear;
}queue;

queue *  Init_queue()  //��ʼ���ն���
{ queue  *sq;
  sq=(queue*)malloc(sizeof(queue));
  sq->front=0;  
  sq->rear =0;
  return sq;
}
int Empty_queue(queue *sq) //�пն���
{  if (sq->front==sq->rear)  return 1;
   else  return 0;
}
    
int  In_queue (queue *sq,  char x)  //�����
{if (sq->rear==m0) 
{printf("���������������!\n");
 return 0;   
}
  else 
{ sq->q[sq->rear++]=x;
   return 1;
}
}

int  Out_queue(queue *sq, char &x) //������
{  if (Empty_queue (sq))
  { printf("���пղ��ܳ����У�\n");
    return 0; 
}
   else  
   { x=sq->q[sq->front++]; 
   return 1; 
}       
}

char  Front_queue(queue *sq) //ȡ����ͷԪ��
{  if ( Empty_queue ( sq ) ) return 0;  /*���п�*/
   else return (sq->q[sq->front++] )
	  ;
}
void main() //������������˳����еĻ�������
{queue *sq; char x;
 sq= Init_queue();//��ʼ���ն���
 In_queue (sq,  'a');//a��b��c����Ԫ����������
 In_queue (sq,  'b');
 In_queue (sq,  'c');
 x=Front_queue(sq);//ȡ����ͷԪ�أ������
 printf("��ǰ���ж�Ԫ���ǣ�%c\n",x);
 sq->front--;
 printf("���������У�"); //������Ԫ�����γ�����
 Out_queue(sq, x);
 printf("%c",x);
 Out_queue(sq, x);
 printf("%c",x);
 Out_queue(sq, x);
 printf("%c",x);
}
