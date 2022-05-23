#include<iostream>
using namespace std;
int main() {
	int T;
	cin >> T;
	int max_score=0;
	int max_idx;
	int a[1000] = { 0, };
	int sum = 0;
	double result = 0;
	for (int i = 0; i < T; i++) {
		cin >> a[i];
		if (max_score < a[i]) {
			max_score = a[i];
		}
		result += a[i];
	}

	result = result / max_score * 100/T;

	cout << result;
	return 0;
}