package kakaoBlind2023;

import java.util.Stack;

public class P2_택배배달과수거하기 {
	public static void main(String[] args) {
		int cap = 4;
		int n = 5;
		int[] deliveries = { 1, 0, 3, 1, 2 };
		int[] pickups = { 0, 3, 0, 4, 0 };
		System.out.println(solution(cap, n, deliveries, pickups));

	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		Stack<int[]> deliveryPoint = new Stack<>();
		Stack<int[]> pickupPoint = new Stack<>();
		long answer = 0;

		for (int i = 1; i <= n; i++) {
			if (deliveries[i - 1] > 0)
				deliveryPoint.push(new int[] { i, deliveries[i - 1] });
			if (pickups[i - 1] > 0)
				pickupPoint.push(new int[] { i, pickups[i - 1] });
		}

		int distance = 0;
		int currentCap = 0;
		while (!deliveryPoint.isEmpty() || !pickupPoint.isEmpty()) {
			currentCap = 0;
			distance = 0;
			while (!deliveryPoint.isEmpty() && currentCap < cap) {
				int[] now = deliveryPoint.pop();
				distance = Math.max(distance, now[0]);

				if (now[1] + currentCap <= cap) {
					currentCap += now[1];
				} else {
					now[1] -= cap - currentCap;
					deliveryPoint.push(now);
					break;
				}
			}
			currentCap = 0;
			while (!pickupPoint.isEmpty() && currentCap < cap) {
				int[] now = pickupPoint.pop();
				distance = Math.max(distance, now[0]);

				if (now[1] + currentCap <= cap) {
					currentCap += now[1];
				} else {
					now[1] -= (cap - currentCap);
					pickupPoint.push(now);
					break;
				}
			}
			answer += (2 * distance);
		}
		return answer;
	}

}
