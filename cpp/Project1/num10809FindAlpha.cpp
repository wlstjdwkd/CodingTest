//#include<iostream>
//using namespace std;
//int main() {
//	string s;
//	cin >> s;
//	int a[26];
//	for (int h = 0; h < 26; h++) {
//		a[h] = -1;
//	}
//	/*for (int i = 0; i < s.length(); i++) {
//		
//		for (int k = 0; k <= i+1; k++) {
//			if (a[(int)s[k] - 97] == i) {
//				a[(int)s[i] - 97] = k;
//				break;
//			}
//			else {
//				a[(int)s[i] - 97] = i;
//
//			}
//
//		}
//
//	}*/
//	for (int j = 0; j < 26; j++) {
//		cout << a[j] << " ";
//	}
//
//	return 0;
//}
#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    string alphabet = "abcdefghijklmnopqrstuvwxyz";
    cin >> s;
    for (int i = 0; i < alphabet.length(); i++)
        cout << (int)s.find(alphabet[i]) << " ";
    return 0;
}