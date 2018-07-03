#include "stdio.h"
#include "stdlib.h"
#define m0 100  //指定顺序队列的最大空间
typedef struct queue  //顺序队列存储结构定义
{char q[m0];
 int front,rear;
}queue;

queue *  Init_queue()  //初始化空队列
{ queue  *sq;
  sq=(queue*)malloc(sizeof(queue));
  sq->front=0;  
  sq->rear =0;
  return sq;
}
int Empty_queue(queue *sq) //判空队列
{  if (sq->front==sq->rear)  return 1;
   else  return 0;
}
    
int  In_queue (queue *sq,  char x)  //入队列
{if (sq->rear==m0) 
{printf("队列满不能入队列!\n");
 return 0;   
}
  else 
{ sq->q[sq->rear++]=x;
   return 1;
}
}

int  Out_queue(queue *sq, char &x) //出队列
{  if (Empty_queue (sq))
  { printf("队列空不能出队列！\n");
    return 0; 
}
   else  
   { x=sq->q[sq->front++]; 
   return 1; 
}       
}

char  Front_queue(queue *sq) //取队列头元素
{  if ( Empty_queue ( sq ) ) return 0;  /*队列空*/
   else return (sq->q[sq->front++] )
	  ;
}
void main() //主函数，测试顺序队列的基本操作
{queue *sq; char x;
 sq= Init_queue();//初始化空队列
 In_queue (sq,  'a');//a、b、c三个元素相继入队列
 In_queue (sq,  'b');
 In_queue (sq,  'c');
 x=Front_queue(sq);//取队列头元素，并输出
 printf("当前队列顶元素是：%c\n",x);
 sq->front--;
 printf("出队列序列："); //队列中元素依次出队列
 Out_queue(sq, x);
 printf("%c",x);
 Out_queue(sq, x);
 printf("%c",x);
 Out_queue(sq, x);
 printf("%c",x);
}
