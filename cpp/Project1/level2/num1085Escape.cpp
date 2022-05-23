#include<iostream>
#include<stdlib.h>
using namespace std;
int main() {
	int x, y, w, h;
	cin >> x >> y >> w >> h;
	int a;
	int b;
	a=min(x,y);
	b = min(abs(x - w), abs(y - h));
	cout << min(a, b);
	return 0;
}