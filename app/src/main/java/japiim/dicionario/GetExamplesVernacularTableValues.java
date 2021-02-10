package japiim.dicionario;

public class GetExamplesVernacularTableValues {
    private long exampleBundleId;
    private long exampleId;
    private String exampleVernacular;
    private String entryRef;



    public GetExamplesVernacularTableValues(long exampleBundleId, String entryRef, long exampleId, String exampleVernacular) {
        this.exampleId = exampleId;
        this.exampleBundleId = exampleBundleId;
        this.exampleVernacular = exampleVernacular;
        this.entryRef = entryRef;

    }


    public long getExampleId() {
        return exampleId;
    }

    public long getExampleBundleId() {
        return exampleBundleId;
    }


    public String getExampleVernacular() {
        return exampleVernacular;
    }

    public String getEntryRef() {
        return entryRef;
    }
}
