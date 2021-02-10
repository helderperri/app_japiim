package japiim.dicionario;



        import android.content.Context;
        import android.content.Intent;

public class GetPhonemicsTableValues {
    private long phonemicId;
    private long formId;
    private String entryRef;
    private String phonemic;

    public GetPhonemicsTableValues(long formId, String entryRef, long phonemicId, String phonemic) {
        this.phonemicId = phonemicId;
        this.formId = formId;
        this.entryRef = entryRef;
        this.phonemic = phonemic;

    }


    public long getPhonemicId() {
        return phonemicId;
    }

    public long getFormId() {
        return formId;
    }


    public String getEntryRef() {
        return entryRef;
    }

    public String getPhonemic() {
        return phonemic;
    }

}
