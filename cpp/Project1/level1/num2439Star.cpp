#include<iostream>
using namespace std;
int main() {
	int a;
	cin >> a;
	for (int i = a-1; i >=0; i--) {
		for (int j = 0; i > j; j++) {
			cout << " ";
		}
		for (int k = a-1; k >= i; k--) {
			cout << "*";
		}
		cout << endl;
	}
	return 0;
}