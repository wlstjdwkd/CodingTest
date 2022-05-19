#include<iostream>
#include<string>
using namespace std;

int mytoupper(int c)
{
	if ((c >= 'a') && (c <= 'z'))
	{
		c = c - 'a' + 'A';
	}
	return c;
}

int main() {
	/*int cnt = 0;
	int cnt2 = 0;
	string input;
	cin >> input;
	char b;*/
	

	/*for (int i = 0; i < a.length(); i++) {
		cnt2 = 0;
		if (a.length()==1) {
			b = a[i];
			break;
		}
		for (int j = i+1; j < a.length(); j++) {
			if (i == a.length() - 1) {
				break;
			}
			if (i == 0) {
				if (a[i] == a[j] || mytoupper(a[i]) == mytoupper(a[j])) {
					cnt++;
					b = a[i];
				}				
			}
			else if (a[i] == a[j] || mytoupper(a[i]) == mytoupper(a[j])) {
				cnt2++;
			}
			
		}
		if (cnt == cnt2) {
			b = '?';
		}
		else if (cnt < cnt2) {
			cnt = cnt2;
			b = a[i];
		}
	}

	b = mytoupper(b);
	cout << b;*/

	//아스키코드 : 대문자 65~90, 소문자 97~122, 알파벳은 26개
	int alpha[26] = { 0 };
	int cnt = 0;
	int max = 0;
	int max_idx = 0;
	string input;
	cin >> input;
	for (int i = 0; i < input.length(); i++) {
		if (input[i] < 97) {//대문자
			alpha[input[i] - 65]++;
		}
		else {//소문자
			alpha[input[i] - 97]++;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (max < alpha[i]) {
			max = alpha[i];
			max_idx = i;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (max == alpha[i]) {
			cnt++;
		}
	}

	if (cnt > 1) {
		cout << "?";
	}
	else {
		cout << (char)(max_idx + 65);
	}

	return 0;
}
