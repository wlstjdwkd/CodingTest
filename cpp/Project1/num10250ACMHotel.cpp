#include<iostream>
using namespace std;
int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int a, b, c, d, e;
		cin >> a >> b >> c;
		if (c % a == 0) {
			d = a;
			e = c / a;
		}
		else {
			d = c % a;
			e = c / a + 1;
		}
		cout <<  d * 100+e << "\n";
	}
	return 0;
}