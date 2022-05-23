#include <iostream>
#include<string>
using namespace std;
int main() {
	int T;
	cin >> T;
	string a;
	int sum=0;
	cin >> a;
	int cnt = a.length();
	while (cnt > 0) {
		sum += (a[a.length()-1])-'0';
		a = a.substr(0,a.length()-1);
		cnt--;
	}
	cout << sum;
	return 0;
}