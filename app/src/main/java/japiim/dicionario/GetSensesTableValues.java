package japiim.dicionario;



        import android.content.Context;
        import android.content.Intent;

public class GetSensesTableValues {
    private long senseBundleId;
    private long senseId;
    private String entryRef;
    private String def;

    public GetSensesTableValues(long senseBundleId, String entryRef, long senseId, String def) {
        this.senseBundleId = senseBundleId;
        this.senseId = senseId;
        this.entryRef = entryRef;
        this.def = def;

    }


    public long getSenseBundleId() {
        return senseBundleId;
    }

    public long getSenseId() {
        return senseId;
    }


    public String getEntryRef() {
        return entryRef;
    }

    public String getDef() {
        return def;
    }

}
