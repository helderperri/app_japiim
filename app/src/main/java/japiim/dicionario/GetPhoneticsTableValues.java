package japiim.dicionario;



        import android.content.Context;
        import android.content.Intent;

public class GetPhoneticsTableValues {
    private long phonemicId;
    private long phoneticId;
    private String entryRef;
    private String phonetic;

    public GetPhoneticsTableValues(long phonemicId, String entryRef, long phoneticId, String phonetic) {
        this.phonemicId = phonemicId;
        this.phoneticId = phoneticId;
        this.entryRef = entryRef;
        this.phonetic = phonetic;

    }


    public long getPhoneticId() {
        return phoneticId;
    }

    public long getPhonemicId() {
        return phonemicId;
    }


    public String getEntryRef() {
        return entryRef;
    }

    public String getPhonetic() {
        return phonetic;
    }

}
