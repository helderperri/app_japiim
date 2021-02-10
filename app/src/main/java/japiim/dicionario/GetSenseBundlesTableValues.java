package japiim.dicionario;


import android.content.Context;
import android.content.Intent;

public class GetSenseBundlesTableValues {
    private long senseBundleId;
    private long entryId;
    private String entryRef;

    public GetSenseBundlesTableValues(long entryId, String entryRef, long senseBundleId) {
        this.senseBundleId = senseBundleId;
        this.entryId = entryId;
        this.entryRef = entryRef;

    }


    public long getSenseBundleId() {
        return senseBundleId;
    }

    public long getEntryId() {
        return entryId;
    }


    public String getEntryRef() {
        return entryRef;
    }
}
