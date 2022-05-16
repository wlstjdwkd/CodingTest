#include<iostream>
using namespace std;
int main() {
	int max = 0;
	int max_idx;
	int a[9];
	for (int i = 0; i < 9; i++) {
		cin >> a[i];
		if (a[i] > max) {
			max = a[i];
			max_idx = i + 1;
		}
	}
	cout << max << "\n";
	cout << max_idx;
	return 0;
}