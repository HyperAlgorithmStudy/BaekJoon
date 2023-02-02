package kakaoBlind2022;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class P3_주차요금계산 {

	public static void main(String[] args) throws ParseException {
		int[] fees = { 180, 5000, 10, 600 };
//		int[] fees_3 = { 1, 461, 1, 10 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
//		String[] records_2 = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
//		String[] records_3 = { "00:00 1234 IN" };

		System.out.println(Arrays.toString(solution(fees, records)));
	}

	public static int[] solution(int[] fees, String[] records) throws ParseException {
		HashMap<String, String> map = new HashMap<>();
		Map<String, Integer> time_map = new TreeMap<>();
		Map<String, String> checkOut = new TreeMap<>();

		// 주차 시간 누적
		for (int i = 0; i < records.length; i++) {
			String[] record = records[i].split(" ");
			if (record[2].equals("IN")) {
				map.put(record[1], record[0]);
				checkOut.put(record[1], "IN");
			} else {
				String key = record[1];
				String in = map.get(key);
				String out = record[0];
				int timeSum = calculateTime(in, out);
				time_map.put(key, time_map.getOrDefault(key, 0) + timeSum);
				checkOut.put(key, "OUT");
			}
		}
		// 주차정산
		Iterator<String> keys = checkOut.keySet().iterator();
		ArrayList<Integer> totalFeeList = new ArrayList<>();

		for (int i = 0; i < map.size(); i++) {
			String key_1 = keys.next();
			if (checkOut.get(key_1).equals("IN")) {
				String out = "23:59";
				String in = map.get(key_1);
				int timeSum = calculateTime(in, out);
				time_map.put(key_1, time_map.getOrDefault(key_1, 0) + timeSum);
				checkOut.put(key_1, "OUT");
				int time = time_map.get(key_1);
				int fee = calculateFees(fees, time);
				totalFeeList.add(fee);
			} else {
				int time = time_map.get(key_1);
				int fee = calculateFees(fees, time);
				totalFeeList.add(fee);
			}
		}
		int[] answer = new int[totalFeeList.size()];
		int index = 0;
		for (int i : totalFeeList) {
			answer[index++] = i;
		}
		return answer;
	}

	private static int calculateFees(int[] fees, int time) {
		int total = 0;
		if (time <= fees[0]) {
			total = fees[1];
		} else {
			int additionalMin = time - fees[0];
			int additionalFees = (int) Math.ceil((double) additionalMin / fees[2]);
			total = fees[1] + (additionalFees * fees[3]);
		}
		return total;
	}

	private static int calculateTime(String in, String out) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		Date x = f.parse(in);
		Date y = f.parse(out);
		long diff = y.getTime() - x.getTime();
		long min = Math.abs(diff / 60000);
		return (int) min;
	}
}
