package kakaoBlind2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P1_개인정보수집유효기간 {

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = { "A 6", "B 12", "C 3" };
		String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
		System.out.println(Arrays.toString(solution(today, terms, privacies)));
	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
    // 약관의 유효기간(월 -> 일)자료
		HashMap<String, Integer> daysOfTerms = new HashMap<>();
		for (int i = 0; i < terms.length; i++) {
			daysOfTerms.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]) * 28);
		}
    // today 누적 날짜 합 (년 + 월 + 일)
		int todayCumulativeDate = calculateDays(today);
    // 파기할 자료 리스트
		ArrayList<Integer> destructionList = new ArrayList<>();
    // privacies의 가입날짜의 누적 날짜 합과 today 누적 날짜 합의 차이를 계산하여 약관의 유효기간 자료와 비교해준다.
    // 비교해서 남은 날이 유효기간 이상이면 파기리스트에 넣어준다.
		for (int i = 0; i < privacies.length; i++) {
			int remainDays = todayCumulativeDate - calculateDays(privacies[i].split(" ")[0]);
			if (remainDays >= daysOfTerms.get(privacies[i].split(" ")[1]))
				destructionList.add(i + 1);
		}

		int[] answer = destructionList.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}
  
  // 날짜 계산 함수
	private static int calculateDays(String days) {
		String[] yearMonthDay = days.split("\\.");
		int totalDays = 0;
		return totalDays += (Integer.parseInt(yearMonthDay[0]) * 336) + (Integer.parseInt(yearMonthDay[1]) * 28)
				+ (Integer.parseInt(yearMonthDay[2]));
	}
}
