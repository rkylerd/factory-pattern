
package spellcheck;

import java.io.*;
import java.util.*;


public class Dictionary implements DictionaryInterface {

	private Set<String> words;

	public Dictionary() throws IOException {

		Scanner scanner = new Scanner(new File("dict.txt"));

		try {
			words = new TreeSet<String>();
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				words.add(word);
			}
		}
		finally {
			scanner.close();
		}
	}

	public boolean isValidWord(String word) {
		return words.contains(word);
	}

}

