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
    int key = a[first];/*���ֱ�ĵ�һ����¼��Ϊ����*/
 
    while(first < last)
    {
        while(first < last && a[last] >= key)
        {
            --last;
        }
 
        a[first] = a[last];/*���ȵ�һ��С���Ƶ��Ͷ�*/
 
        while(first < last && a[first] <= key)
        {
            ++first;
        }
         
        a[last] = a[first];    
/*���ȵ�һ������Ƶ��߶�*/
    }
    a[first] = key;/*�����¼��λ*/
    Qsort(a, low, first-1);
    Qsort(a, first+1, high);
}
int main()
{
	int n;
	cout<<"���������ݳ��ȣ�";
	cin>>n;
   	int *a=new int[n];
   	cout<<"������һ�����ݣ�";
    for(int i=0;i<n;i++)
    cin>>a[i];
    Qsort(a, 0, n);/*����ԭ�ĵ���������Ҫ��1�����ڴ�Խ��*/
 	cout<<"�����"; 
    for(int i = 1; i<=n; i++)
    {
        cout <<std::left<<setw(3)<<a[i] << "";
    }
     
    return 0;
}/*�ο����ݽṹp274(�廪��ѧ�����磬��ε��)*/
