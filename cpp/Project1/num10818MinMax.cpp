#include<iostream>
using namespace std;
int main() {
	int N;
	int max = -1000000;
	int min = 1000000;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		if (a > max) {
			max = a;
		}
		if (a < min) {
			min = a;
		}
	}
	cout << min <<" "<< max;
	return 0;
}