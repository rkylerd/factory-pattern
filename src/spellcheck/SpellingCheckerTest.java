package spellcheck;

import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellingCheckerTest {

    private SpellingChecker checker;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Factory.setInstance(new RealFactory());
        checker = new SpellingChecker();
    }

    @org.junit.jupiter.api.Test
    void checkURL() {

        try {

            checker.setFetcher(Factory.createFetcher());
            checker.setDictionary(Factory.createDictionary());
            checker.setExtractor(Factory.createExtractor());

            SortedMap<String, Integer> mistakes = checker.check(null);

            assertEquals(mistakes.toString(), "{funtion=1, tere=1, varable=1}");
            System.out.println(mistakes.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}