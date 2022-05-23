#include<iostream>
using namespace std;
int main() {
	int A, B;
	cin >> A >> B;
	int a[3];
	int b[3];
	for (int i = 0; i < 3; i++) {
		a[i] = A % 10;
		b[i] = B % 10;
		A /= 10;
		B /= 10;
	}
	A = a[0] * 100 + a[1] * 10 + a[2];
	B = b[0] * 100 + b[1] * 10 + b[2];
	cout << max(A, B);
	return 0;
}