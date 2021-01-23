package spellcheck;

import java.util.ArrayList;
import java.util.List;

public class MockWordExtractor implements WordExtractorInterface {

    public List<String> extract(String content) {

        List<String> words = new ArrayList<String>();

        words.add("funtion");
        words.add("tere");
        words.add("varable");
        words.add("going");

        return words;
    }
}
