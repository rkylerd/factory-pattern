package spellcheck;

import java.io.IOException;

public class Factory {

    private static IFactory instance;

    public static void setInstance(IFactory f) {
        instance = f;
    }

    public static DocumentFetcher createFetcher() {
        return instance.createFetcher();
    }

    public static WordExtractorInterface createExtractor() {
        return instance.createExtractor();
    }

    public static DictionaryInterface createDictionary() {
            return instance.createDictionary();
    }
}
