#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;

bool cmp (string s1,string s2){
	return s1+s2>s2+s1;}
int main(){
	int n;
	cin >> n;
	vector<string> str;
	for(int i = 0;i<n;i++){
	string temp;
	cin >> temp;
	str.push_back(temp);
	}
	sort(str.begin(),str.end(),cmp);
	for(int i = 0; i < str.size(); i++)
		cout << str[i];
	for(auto i = str.begin(); i != str.end(); i++)
		cout << (*i);
	for(auto & i : str)
		cout << i;

	return 0;
}

 
