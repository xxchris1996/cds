#include<iostream>  
#include<stdlib.h> 
using namespace std;  
#include<time.h>  
  
#define n 18  
  
int main()  
{  
  time_t ts;  
  srand((unsigned int)time(&ts));                   //�������������  
  int a[n]={0};  
  for(int i=0;i<n;i++)  
  {//�������Ϊ3�飬��һ��洢����22���ڵ����ݣ��ڶ���洢����23-48�����ݣ�������洢����49-86������  
   //�������������޶���һ����Χ���أ��������ó�ģ�ӷ��ķ�ʽ�����磺Ҫ���������m<=r<=n,��ʽ��rand()%(n-m+1)+m  
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
  cout<<"\n��������ҵ�����\n";  
  cin>>m;  
  if(m<=22)  
  {  
    int i;  
    for(i=0;i<6;i++)  
    {  
      if(m==a[i])  
      {  
         cout<<"��Ҫ���ҵ�����:"<<i+1<<endl;  
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
          cout<<"��Ҫ���ҵ�����:"<<j+1<<endl;  
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
          cout<<"��Ҫ���ҵ�����:"<<k+1<<endl;  
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
