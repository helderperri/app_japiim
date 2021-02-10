package japiim.dicionario;


import android.content.Context;
import android.content.Intent;

public class GetClassesTableValues {
    private long senseBundleId;
    private long classId;
    private long classTokenId;
    private String entryRef;

    public GetClassesTableValues(long senseBundleId, String entryRef, long classTokenId, long classId) {
        this.senseBundleId = senseBundleId;
        this.classId = classId;
        this.entryRef = entryRef;
        this.classTokenId = classTokenId;

    }


    public long getSenseBundleId() {
        return senseBundleId;
    }

    public long getClassId() {
        return classId;
    }


    public long getTokenClassId() {
        return classTokenId;
    }


    public String getEntryRef() {
        return entryRef;
    }
}
