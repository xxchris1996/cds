#include "stdio.h"
#include "stdlib.h"
#define m0 100  //指定顺序栈的最大空间
typedef struct SeqStack  //顺序栈存储结构定义
{char data[m0];
 int top;
}SeqStack;
SeqStack *  Init_SeqStack()  //初始化空栈
{ SeqStack  *s;
  s=(SeqStack*)malloc(sizeof(SeqStack));
  s->top=0;  
  return s;
}
int Empty_SeqStack(SeqStack *s) //判空栈
{  if (s->top==0)  return 1;
   else  return 0;
}
    
int  Push_SeqStack (SeqStack *s,  char x)  //入栈
{if (s->top==m0) 
{printf("栈满不能入栈!\n");
 return 0;   
}
  else 
{ s->data[s->top++]=x;
   return 1;
}
}

int  Pop_SeqStack(SeqStack *s, char &x) //出栈
{  if (Empty_SeqStack (s ))
  { printf("栈空不能出栈！\n");
    return 0; 
}
   else  
   { x=s->data[--s->top]; 
   return 1; 
}       
}

char  Top_SeqStack(SeqStack *s) //取栈顶元素
{  if ( Empty_SeqStack ( s ) ) return 0;  /*栈空*/
   else return (s->data[--s->top] );
}
void main() //主函数，测试顺序栈的基本操作
{SeqStack *stack; char x;
 stack= Init_SeqStack();//初始化空栈
 Push_SeqStack (stack,  'a');//a、b、c三个元素相继入栈
 Push_SeqStack (stack,  'b');
 Push_SeqStack (stack,  'c');
 x=Top_SeqStack(stack);//取栈顶元素，并输出
 printf("当前栈顶元素是：%c\n",x);
 stack->top++;
 printf("出栈序列："); //栈中元素依次出栈
 Pop_SeqStack(stack, x);
 printf("%c",x);
 Pop_SeqStack(stack, x);
 printf("%c",x);
 Pop_SeqStack(stack, x);
 printf("%c",x);
}
