package japiim.dicionario;


import android.content.Context;
import android.content.Intent;

public class GetExampleBundlesTableValues {
    private long senseBundleId;
    private long exampleBundleId;
    private String entryRef;

    public GetExampleBundlesTableValues(long senseBundleId, String entryRef, long exampleBundleId) {
        this.senseBundleId = senseBundleId;
        this.exampleBundleId = exampleBundleId;
        this.entryRef = entryRef;

    }


    public long getSenseBundleId() {
        return senseBundleId;
    }

    public long getExampleBundleId() {
        return exampleBundleId;
    }


    public String getEntryRef() {
        return entryRef;
    }
}
