package japiim.dicionario.ui.alphabetic_target;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import japiim.dicionario.DatabaseEntriesGlossesAdapter;
import japiim.dicionario.DatabaseTargetLettersAdapter;
import japiim.dicionario.GetEntriesGlossesTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.ui.alphabetic_source.DynamicFragmentAlphabeticSrcAdapter;

public class AlphabeticTargetFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout mTabLayout;


    EntriesTargetAdapter entriesTargetAdapter;
    LettersTargetAdapter lettersAdapter;
    DatabaseTargetLettersAdapter databaseTargetLettersAdapter;
    List<GetTargetLettersTableValues> targetLettersList = new ArrayList<>();


     DatabaseEntriesGlossesAdapter databaseEntriesGlossesAdapter;

    RecyclerView rvEntriesDisplaySl;
    List<GetEntriesGlossesTableValues> entriesGlossesList = new ArrayList<>();
    private ArrayList<Fragment> arrayList = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.activity_dynamic, container, false);

        databaseTargetLettersAdapter = new DatabaseTargetLettersAdapter(getContext(), 0);
       targetLettersList = databaseTargetLettersAdapter.getTargetLetters();



//        vpEntries = root.findViewById(R.id.vp_entries_target_alpha_letters);


        for (int i=0; i<targetLettersList.size(); i++)
        {
            GetTargetLettersTableValues getTargetLettersTableValues = targetLettersList.get(i);

            String glyph = getTargetLettersTableValues.getGlyph().toLowerCase();

            long glyphId = getTargetLettersTableValues.getGlyphId();

            databaseEntriesGlossesAdapter = new DatabaseEntriesGlossesAdapter(getContext(), 0, 0, 0);
            //entriesGlossesList = databaseEntriesGlossesAdapter.getGlossessToSearchDisplayByGlyph(glyph);
            entriesGlossesList = databaseEntriesGlossesAdapter.getGlossessToSearchDisplayByGlyphId(glyphId);

            entriesTargetAdapter = new EntriesTargetAdapter(getContext(), targetLettersList, entriesGlossesList, rvEntriesDisplaySl);


        }

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
        for (int i=0; i<targetLettersList.size(); i++)
        {
            GetTargetLettersTableValues getTargetLettersTableValues = targetLettersList.get(i);
            String glyph = getTargetLettersTableValues.getGlyph();

//        for (int i = 0; i < 10; i++) {

            mTabLayout.addTab(mTabLayout.newTab().setText(glyph));
//            mTabLayout.addTab(mTabLayout.newTab().setText("Category: " + i));
        }
        DynamicFragmentAlphabetitargetAdapter mDynamicFragmentAdapter = new DynamicFragmentAlphabetitargetAdapter(getFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(mDynamicFragmentAdapter);
        viewPager.setCurrentItem(0);
    }


}