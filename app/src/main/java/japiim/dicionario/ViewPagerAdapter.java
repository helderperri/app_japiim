package japiim.dicionario;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    int numOfTabs;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {

        super(fm, behavior);
        numOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 0;
    }
    public void  addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
}
