package my.diplom.dev.service.helper;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> generateCombinations(@NonNull int from, @NonNull int to, @NonNull int amount) {
		if(to < from) {
			throw new IllegalArgumentException("from could be not less then to");
		}
		if(to - from + 1 < amount) {
			throw new IllegalArgumentException();
		}

		List<List<Integer>> set = new ArrayList<>();
		Integer[] arr = new Integer[amount];

		for(int i = 0; i < amount; i++) {
			arr[i] = i + from;
		}
		set.add(new ArrayList<>(Arrays.asList(arr)));
		while(arr[0] < to - amount + 1) {
			for(int i = amount - 1; i >= 0; i--) {
				if(arr[i] < to - amount + i + 1) {
					arr[i]++;
					for(int j = i; j < amount - 1; j++) {
						arr[j + 1] = arr[j] + 1;
					}
					set.add(new ArrayList<>(Arrays.asList(arr)));
					break;
				}
			}
		}
		return set;
	}

	public static int factorial(int number) {
		for(int n = number - 1; n > 0; n--) {
			number*=n;
		}
		return number;
	}

	public static int C(int n, int k) {
		return factorial(n)/(factorial(n-k)*factorial(k));
	}
}
