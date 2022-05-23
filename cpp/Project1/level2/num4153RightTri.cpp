#include<iostream>
#include<cmath>
using namespace std;
int main() {
	int a=1, b=1, c=1;
	while (1) {
		cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0) {
			break;
		}
		if (c == sqrt(pow(a, 2) + pow(b, 2))) {
			cout << "right" << "\n";
		}
		else if (a == sqrt(pow(b, 2) + pow(c, 2))) {
			cout << "right" << "\n";
		}
		else if (b == sqrt(pow(a, 2) + pow(c, 2))) {
			cout << "right" << "\n";
		}
		else {
			cout << "wrong" << "\n";
		}
	}
	return 0;
}