#include<iostream>
#include<iomanip>
using namespace std;

#define SIZE 10

int main()
{
	int i=0;
	int a[SIZE];
	for(i=0;i<SIZE;i++)
	cin>>a[i];
	for(int m=0;m<SIZE-1;m++)
	{
		for(int n=0;n<SIZE-1-m;n++)
		{
			int temp;
			if(a[n]>a[1+n])
			{
				temp=a[n+1];
				a[n+1]=a[n];
				a[n]=temp;
			}
		}
	}
	for(i=0;i<SIZE;i++)
	cout<<std::left<<setw(3)<<a[i]; 
 } 
