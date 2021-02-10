package japiim.dicionario.ui.alphabetic_source;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseSourceLettersAdapter;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;

public class AlphabeticSourceFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout mTabLayout;

    DatabaseSourceLettersAdapter databaseSourceLettersAdapter;
    List<GetSourceLettersTableValues> sourceLettersList = new ArrayList<>();

    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    RecyclerView rvEntriesDisplaySl;
    List<GetEntriesVernacularTableValues> entriesVernacularList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.activity_dynamic, container, false);

        //Assign variable

        databaseSourceLettersAdapter = new DatabaseSourceLettersAdapter(getActivity(), 0);
        sourceLettersList = databaseSourceLettersAdapter.getSourceLetters();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         

        initViews(root);

        return root;
    }
    private void initViews(View v){

        viewPager = v.findViewById(R.id.viewpager);
        mTabLayout =  v.findViewById(R.id.tabs);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setDynamicFragmentToTabLayout();

    }

    private void setDynamicFragmentToTabLayout() {
        for (int i=0; i<sourceLettersList.size(); i++)
        {
            GetSourceLettersTableValues getSourceLettersTableValues = sourceLettersList.get(i);
            String glyph = getSourceLettersTableValues.getGlyph();

//        for (int i = 0; i < 10; i++) {

            mTabLayout.addTab(mTabLayout.newTab().setText(glyph));
//            mTabLayout.addTab(mTabLayout.newTab().setText("Category: " + i));
        }
        DynamicFragmentAlphabeticSrcAdapter mDynamicFragmentAdapter = new DynamicFragmentAlphabeticSrcAdapter(getFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(mDynamicFragmentAdapter);
        viewPager.setCurrentItem(0);
    }


}