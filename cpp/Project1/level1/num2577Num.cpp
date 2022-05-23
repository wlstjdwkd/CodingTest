#include<iostream>
using namespace std;
int main() {
	int A, B, C;
	int a[10] = { 0 };
	int b;
	cin >> A >> B >> C;
	int sum = A * B * C;
	while (sum > 0) {
		b = sum % 10;
		a[b]++;
		sum /= 10;
	}

	for (int i = 0; i < 10; i++) {
		cout << a[i] << "\n";
	}
	return 0;
}