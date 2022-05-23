#include<iostream>
using namespace std;
int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int a;
		cin >> a;
		string b;
		cin >> b;
		for (int k = 0; k < b.length(); k++) {
			for (int j = 0; j < a; j++) {
				cout << b[k];
			}
		}
		cout << "\n";
	}
	return 0;
}