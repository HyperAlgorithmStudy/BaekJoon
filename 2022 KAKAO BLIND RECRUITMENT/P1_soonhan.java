package kakaoBlind2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P1_신고결과받기 {
	static ArrayList<String>[] A;

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		A = new ArrayList[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			A[i] = new ArrayList<>();
		}

		// 중복 제거
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(report));
		String[] resultReport = hashSet.toArray(new String[0]);
    
		HashMap<String, Integer> idIndex = new HashMap<>();
		HashMap<String, Integer> reportSum = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			idIndex.put(id_list[i], i);
			reportSum.put(id_list[i], 0);
		}

		for (int i = 0; i < resultReport.length; i++) {
			String x = resultReport[i].split(" ")[0];
			String key = resultReport[i].split(" ")[1];
			reportSum.put(key, reportSum.getOrDefault(key, 0) + 1);
			int index = idIndex.get(x);
			A[index].add(key);
		}
		// reportSum의 value가 k이상인 아이디를 inIndex에서 찾아서 리턴
		int[] answer = new int[id_list.length];

		for (int i = 0; i < A.length; i++) {
			for (String j : A[i]) {
				if (reportSum.get(j) >= k) {
					answer[i]++;
				}
			}
		}
		return answer;
	}

}
