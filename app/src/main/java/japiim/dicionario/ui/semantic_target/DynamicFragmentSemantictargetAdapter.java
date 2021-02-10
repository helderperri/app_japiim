package japiim.dicionario.ui.semantic_target;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import japiim.dicionario.ui.alphabetic_target.DynamicFragmentAlphabeticTarget;


public class DynamicFragmentSemantictargetAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public DynamicFragmentSemantictargetAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putInt("position", position);
        Fragment frag = DynamicFragmentSemanticTarget.newInstance();
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
