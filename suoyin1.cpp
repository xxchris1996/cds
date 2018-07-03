#include<iostream>
#include<iomanip>
using namespace std;
 const int a[18]={22,12,13,8,9,20,33,42,44,38,24,48,60,58,74,49,86,53};
  typedef struct IndexItem
 {
 	int maxkey;
 	int low;
 	int high;
 };
 typedef struct IndexItem t[3];
 
 int main()
 {
 	for(int i=0;i<18;i++)
	 cout<<setw(5)<<a[i];
	 for(int i=0;i<3;i++)
	 {
	 	cin>>t[i].maxkey>>t[i].low>>t[i].high;
	 }
	 
 	return 0;
 } 


