package japiim.dicionario;



        import android.content.Context;
        import android.content.Intent;

public class GetEntriesTableValues {
    private long entryBundleId;
    private long entryId;
    private String entryRef;

    public GetEntriesTableValues(long entryBundleId, String entryRef, long entryId) {
        this.entryBundleId = entryBundleId;
        this.entryId = entryId;
        this.entryRef = entryRef;

    }


    public long getEntryBundleId() {
        return entryBundleId;
    }

    public long getEntryId() {
        return entryId;
    }


    public String getEntryRef() {
        return entryRef;
    }
}
