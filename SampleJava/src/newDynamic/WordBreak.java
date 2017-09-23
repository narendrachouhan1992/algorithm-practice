package newDynamic;

public class WordBreak {
	static boolean isWord(String word) {
		String[] words = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like",
				"ice", "cream" };
		if (word == null || word.length() == 0) {
			return false;
		}
		for (String wd : words) {
			if (wd.equals(word)) {
				return true;
			}
		}
		return false;
	}

	static boolean canBeDevided(String santence) {
		int size = santence.length();
		for (int i = 0; i < size; i++) {
			if (isWord(santence.substring(0, i)) && canBeDevided(santence.substring(i, size))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		if (canBeDevided("ilikesamsung")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("iiiiiiii")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("ilikelikeimangoiii")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("samsungandmango")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("samsungandmangok")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
	}
}
