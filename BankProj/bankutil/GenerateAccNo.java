package bankutil;

import java.util.Random;

public class GenerateAccNo {

	private static int generateRandomIntIntRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String savingsAcc(String city) {
		String temp = city.substring(0,3);		
		int acn = generateRandomIntIntRange(1,100000);
		String r = Integer.toString(acn);
		String finalacc = temp.toUpperCase() + "101" + r;
		return finalacc;
	}

	public static String currentAcc(String city) {
		String temp = city.substring(0,3);		
		int acn = generateRandomIntIntRange(1,100000);
		String r = Integer.toString(acn);
		String finalacc = temp.toUpperCase() + "201" + r;
		return finalacc;
	}

	public static String fdAcc(String city) {
		String temp = city.substring(0,3);		
		int acn = generateRandomIntIntRange(1,100000);
		String r = Integer.toString(acn);
		String finalacc = temp.toUpperCase() + "301" + r;
		return finalacc;
	}
}
