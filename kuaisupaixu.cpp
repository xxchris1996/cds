#include <iostream>
#include<iomanip>
 
using namespace std;
 
void Qsort(int a[], int low, int high)
{
    if(low >= high)
    {
        return;
    }
    int first = low;
    int last = high;
    int key = a[first];/*用字表的第一个记录作为枢轴*/
 
    while(first < last)
    {
        while(first < last && a[last] >= key)
        {
            --last;
        }
 
        a[first] = a[last];/*将比第一个小的移到低端*/
 
        while(first < last && a[first] <= key)
        {
            ++first;
        }
         
        a[last] = a[first];    
/*将比第一个大的移到高端*/
    }
    a[first] = key;/*枢轴记录到位*/
    Qsort(a, low, first-1);
    Qsort(a, first+1, high);
}
int main()
{
	int n;
	cout<<"请输入数据长度：";
	cin>>n;
   	int *a=new int[n];
   	cout<<"请输入一组数据：";
    for(int i=0;i<n;i++)
    cin>>a[i];
    Qsort(a, 0, n);/*这里原文第三个参数要减1否则内存越界*/
 	cout<<"排序后："; 
    for(int i = 1; i<=n; i++)
    {
        cout <<std::left<<setw(3)<<a[i] << "";
    }
     
    return 0;
}/*参考数据结构p274(清华大学出版社，严蔚敏)*/
