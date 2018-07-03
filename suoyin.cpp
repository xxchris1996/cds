#include<iostream>  
#include<stdlib.h> 
using namespace std;  
#include<time.h>  
  
#define n 18  
  
int main()  
{  
  time_t ts;  
  srand((unsigned int)time(&ts));                   //设置随机数种子  
  int a[n]={0};  
  for(int i=0;i<n;i++)  
  {//将数组分为3块，第一块存储的是22以内的数据，第二块存储的是23-48的数据，第三块存储的是49-86的数据  
   //如何让随机数据限定在一个范围内呢，可以利用除模加法的方式：例如：要让随机数在m<=r<=n,公式：rand()%(n-m+1)+m  
      if(i<6)  
      {  
          a[i]=rand()%23;   
          cout<<a[i]<<" ";  
      }  
      if(i>=6 && i<12)  
      {  
          a[i]=rand()%26+23;  
          cout<<a[i]<<" ";  
      }  
      if(i>=12 && i<18)  
      {  
          a[i]=rand()%39+48;  
          cout<<a[i]<<" ";  
      }  
  }  
  
  int m;  
  cout<<"\n请输入查找的数据\n";  
  cin>>m;  
  if(m<=22)  
  {  
    int i;  
    for(i=0;i<6;i++)  
    {  
      if(m==a[i])  
      {  
         cout<<"你要查找的数据:"<<i+1<<endl;  
         break;  
      }  
    }  
    if(i==6)  
    {  
      cout<<"error\n";  
    }  
  }  
  if(m>22 && m<=48)  
  {  
    int j;  
    for(j=6;j<12;j++)  
    {  
       if(a[j]==m)  
       {  
          cout<<"你要查找的数据:"<<j+1<<endl;  
          break;  
       }  
    }  
    if(j==12)  
    {  
      cout<<"error\n";  
    }  
  }  
  if(m>48 && m<=86)  
  {  
    int k;  
    for(k=12;k<18;k++)  
    {  
       if(a[k]==m)  
       {  
          cout<<"你要查找的数据:"<<k+1<<endl;  
          break;  
       }  
    }  
    if(k==18)  
    {  
      cout<<"error\n";  
    }  
  }  
  return 0;  
  
}  
