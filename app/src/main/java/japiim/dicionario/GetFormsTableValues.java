package japiim.dicionario;



        import android.content.Context;
        import android.content.Intent;

public class GetFormsTableValues {
    private long formBundleId;
    private long formId;
    private String entryRef;
    private String vernacular;

    public GetFormsTableValues(long formBundleId, String entryRef, long formId, String vernacular) {
        this.formBundleId = formBundleId;
        this.formId = formId;
        this.entryRef = entryRef;
        this.vernacular = vernacular;

    }


    public long getFormBundleId() {
        return formBundleId;
    }

    public long getFormId() {
        return formId;
    }


    public String getEntryRef() {
        return entryRef;
    }

    public String getVernacular() {
        return vernacular;
    }

}
