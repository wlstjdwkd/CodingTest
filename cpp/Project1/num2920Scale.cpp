#include<iostream>
using namespace std;
int main() {
	int a[8];
	char b;
	int asC = 0;
	int desC = 0;
	for (int i = 0; i < 8; i++) {
		cin >> a[i];
		if (a[i] == i + 1) {
			asC++;
		}
		else if (a[i] == 8 - i) {
			desC++;
		}
		
	}
	if (asC==8) {
		cout << "ascending";
	}
	else if (desC==8) {
		cout << "descending";
	}
	else {
		cout << "mixed";
	}
	return 0;
}