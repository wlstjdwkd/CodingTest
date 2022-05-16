#include<iostream>
#include<cmath>
using namespace std;
int main() {
	int a, b, c, d, e, f;
	cin >> a >> b >> c >> d >> e;
	int sum=0;
	sum = (int)pow(a, 2) + (int)pow(b, 2) + (int)pow(c, 2) + (int)pow(d, 2) + (int)pow(e, 2);
	f = sum % 10;
	cout << f;
}