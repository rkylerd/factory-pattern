
package spellcheck;

import java.util.*;
import java.net.*;
import java.io.*;

public class SpellingChecker implements SpellChecker {

	private DocumentFetcher fetcher;
	private WordExtractorInterface extractor;
	private DictionaryInterface dictionary;

	public void setFetcher(DocumentFetcher fetcher) {
		this.fetcher = fetcher;
	}

	public void setExtractor(WordExtractorInterface extractor) {
		this.extractor = extractor;
	}

	public void setDictionary(DictionaryInterface dictionary) {
		this.dictionary = dictionary;
	}

	public SortedMap<String, Integer> check(Object o) throws IOException {
		URL url = (URL) o;
		// download the document content
		//

		String content = fetcher.fetch(url);

		// extract words from the content
		//

		List<String> words = extractor.extract(content);

		// find spelling mistakes
		//

		SortedMap<String, Integer> mistakes = new TreeMap<String, Integer>();
		
		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			String word = it.next();
			if (!dictionary.isValidWord(word)) {
				if (mistakes.containsKey(word)) {
					int oldCount = mistakes.get(word);
					mistakes.put(word, (Integer)(oldCount + 1));
				}
				else {
					mistakes.put(word, (Integer)1);
				}
			}
		}

		return mistakes;
	}

}

