package japiim.dicionario.ui.target_lang;

import android.content.res.Resources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import japiim.dicionario.R;

public class TargetLangViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String target_lang;

    public TargetLangViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("This is Português fragment");
    }

    public LiveData<String> getText(int title_target_lang) {
        return mText;
    }
}