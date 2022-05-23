#include<iostream>
using namespace std;
int main() {
	int N;
	cin >> N;
	int cnt=0;
	if (N == 1) {
		cnt = 1;
		cout << cnt;
		return 0;
	}
	for (int sum = 2; sum <= N; cnt++) {
		sum += 6 * cnt;
	}
	
	cout << cnt;
	return 0;
}