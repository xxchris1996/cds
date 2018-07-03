#include<stdio.h>
#include<stdlib.h>

#define MAX_LENGTH 100
typedef int KeyType;
typedef struct SSTable
{
	KeyType *elem;
	int length;
 } SSTable;
 
 int Search_Seq(SSTable ST,KeyType key)
 {
 	int i;
 	for(i=1;i<ST.length&&ST.elem[i]!=key;i++);
 	if(key==ST.elem[i])
 	return i;
 	 return 0;
 }
 
 int main()
 { 
 	int i,key;
 	SSTable T;
 	T.elem=(KeyType*)malloc(sizeof(KeyType));
 	printf("How many entries do you want to input\n");
 	scanf("%d",&T.length);
 	for(i=1;i<=
	 T.length;i++)
 	{
	 printf("Please input the %dth entries \n",i);
	 scanf("%d",&T.elem[i]);
	 }
	 for(i=1;i<=T.length;i++)
	 printf("%d ",T.elem[i]);
	 printf("Please input the data you want to search\n");
	 scanf("%d",&key);
	 i=Search_Seq(T,key);
	 printf("the search data is locate the %dth\n",i);
		
 }
