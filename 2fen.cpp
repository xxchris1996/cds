#include<stdio.h>

int FindBySrch(int *ListData ,int ListLength,int KeyData) 
{
	int low =1;
	int high=ListLength;
	while(low<=high)
	{
		int mid=(low+high)/2;
		if(KeyData>ListData[mid-1])
		low=mid;
		else if(KeyData<ListData[mid-1])
		high=mid;
		else return mid;
	}
	return 0;
}

int main()
{
	int TestData[5]={34,35,56,89,96};
	int retData=FindBySrch(TestData,5,89);
	printf("retData:%d\n",retData);
	return 0;
}
