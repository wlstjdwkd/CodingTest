#include<iostream>
using namespace std;
int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int cnt = 0;
		int score = 0;
		string a;
		cin >> a;
		for (int j = 0; j < a.length(); j++) {
			
			if (a[j] == 'O') {
				if (j != 0 && a[j - 1] == 'O') {
					cnt++;
				}
				score++;
			}
			
			else if(a[j]=='X') {
				for (int k = 1; k <= cnt; k++) {
					score = score + k;
				}
				cnt = 0;
			}
			
			if (j == a.length() - 1) {
				for (int k = 1; k <= cnt; k++) {
					score = score + k;
				}
			}
			/*if (j == a.length() - 1) {
				for (int k = 1; k <= cnt2; k++) {
					score = score + k;
				}
			}*/
		}
		cout << score << "\n";
	}
	return 0;
}