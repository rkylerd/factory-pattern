package spellcheck;

import java.io.IOException;

public class RealFactory implements IFactory {
    @Override
    public DocumentFetcher createFetcher() {
        return new MockFetcher();
    }

    @Override
    public WordExtractorInterface createExtractor() {
        return new MockWordExtractor();
    }

    @Override
    public DictionaryInterface createDictionary() {
        try {
            return new Dictionary();

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }
}
