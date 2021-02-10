package japiim.dicionario.ui.source_lang;

import android.content.res.Resources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import japiim.dicionario.R;

public class SourceLangViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public SourceLangViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Guató fragment");
    }

    public LiveData<String> getText(int title_source_lang) {
        return mText;
    }
}