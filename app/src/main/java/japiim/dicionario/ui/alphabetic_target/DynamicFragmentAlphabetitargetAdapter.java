package japiim.dicionario.ui.alphabetic_target;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import japiim.dicionario.ui.alphabetic_source.DynamicFragmentAlphabeticSrc;


public class DynamicFragmentAlphabetitargetAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public DynamicFragmentAlphabetitargetAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putInt("position", position);
        Fragment frag = DynamicFragmentAlphabeticTarget.newInstance();
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
