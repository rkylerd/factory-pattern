package spellcheck;

public interface IFactory {
    public DocumentFetcher createFetcher();
    public WordExtractorInterface createExtractor();
    public DictionaryInterface createDictionary();
}
