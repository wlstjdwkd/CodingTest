#include<iostream>
using namespace std;
int main() {
	int a[10] = { 0 };
	int cnt = 1;

	for (int i = 0; i < 10; i++) {
		int b;
		cin >> b;
		int cnt2 = 0;
		a[i] = b % 42;
		
		for (int j = 0; j < i; j++) {
			if (a[j] != b % 42) {
				cnt2++;
			}

			if (cnt2 == i) {
				cnt++;
			}
			
		}

	}
	cout << cnt;
	return 0;
}