import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Comparator<String> lengthComparator = (word1, word2) -> {
			int lengthCompare = Integer.compare(word1.length(), word2.length());
			if (lengthCompare == 0) {
				return word1.compareTo(word2);
			}
			return lengthCompare;
		};

		int n = in.nextInt();
		Set<String> words = new TreeSet<>(lengthComparator);

		for (int i = 0; i < n; i++) {
			words.add(in.next());
		}

		for (String word : words) {
			System.out.println(word);
		}
	}
}