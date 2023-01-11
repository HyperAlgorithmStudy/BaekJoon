package tree;

import java.util.Scanner;

public class P14425_stringTrie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		tNode root = new tNode();
		while (N > 0) { // trie data structure
			String text = sc.next();
			tNode now = root; //현재 노드를 루트 노드로 설정 

			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (now.next[c - 'a'] == null) {  // 26개의 알파벳 위치를 배열 index로 나타내기 위해 -'a'수행
					now.next[c - 'a'] = new tNode();
				}
				now = now.next[c - 'a']; // 현재 노드를 c변수 노드로 변경하기 (문자열 끝나는 것 체크하기 위해) 
				if (i == text.length() - 1) // i가 문자열의 마지막이면 isEnd 변수를 true로 설정 
					now.isEnd = true;
			}
			N--;
		}
		int cnt = 0;
		while (M > 0) {
			String text = sc.next();
			tNode now = root;

			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (now.next[c - 'a'] == null) { //찾는 문자열은 없음으로 브레이크 
					break;
				}
				now = now.next[c - 'a'];
				if (i == text.length() - 1 && now.isEnd)
					cnt++;
			}
			M--;
		}
		System.out.println(cnt);
	}

}

class tNode {
	tNode[] next = new tNode[26];
	boolean isEnd; // 문자열의 마지막 유무 표현하기
}
