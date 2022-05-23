#include<iostream>
using namespace std;
int main() {
	int N, M;
	cin >> N >> M;
	int a[100];
	int sum = 0;
	int max = 0;
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}
	for (int i = 0; i < N; i++) {
		sum = 0;
		//cin >> a[i];
		sum += a[i];
		for (int j = i + 1; j < N; j++) {
			sum = a[i];
			sum += a[j];
			for (int k = j + 1; k < N; k++) {
				sum = a[i] + a[j];
				if (sum + a[k] <= M) {
					sum += a[k];
					if (max <= sum) {
						max = sum;
					}
				}
			}
		}
		
	}

	cout << max;
	return 0;
}