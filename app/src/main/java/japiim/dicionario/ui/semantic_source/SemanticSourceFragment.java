package japiim.dicionario.ui.semantic_source;

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

import japiim.dicionario.DatabaseEntriesSdsAdapter;
import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseEntriesVernacularSdsAdapter;
import japiim.dicionario.DatabaseSourceLettersAdapter;
import japiim.dicionario.GetEntriesSdsTableValues;
import japiim.dicionario.GetEntriesVernacularSdsTableValues;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.ui.alphabetic_source.DynamicFragmentAlphabeticSrcAdapter;
import japiim.dicionario.ui.alphabetic_source.EntriesSourceAdapter;
import japiim.dicionario.ui.alphabetic_source.LettersSourceAdapter;
import japiim.dicionario.ui.alphabetic_target.DynamicFragmentAlphabetitargetAdapter;

public class SemanticSourceFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout mTabLayout;

    DatabaseEntriesSdsAdapter databaseEntriesSdsAdapter;

    List<GetEntriesSdsTableValues> entriesSdsList = new ArrayList<>();

//    TabLayout tabLayout;

    EntriesSemanticSourceAdapter entriesSemanticSourceAdapter;
    SemanticSourceAdapter semanticSourceAdapter;

    DatabaseEntriesVernacularSdsAdapter databaseEntriesVernacularSdsAdapter;
    RecyclerView rvEntriesDisplaySl;
    List<GetEntriesVernacularSdsTableValues> entriesVernacularList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_dynamic, container, false);
        //vpEntries = root.findViewById(R.id.vp_entries);


//        tabLayout = root.findViewById(R.id.tabLayout);


        databaseEntriesSdsAdapter = new DatabaseEntriesSdsAdapter(getContext(), 0, "");
        entriesSdsList = databaseEntriesSdsAdapter.getSdsToSearchDisplay();



//        vpEntries = root.findViewById(R.id.vp_entries_sds);


        for (int i=0; i<entriesSdsList.size(); i++)
        {
            GetEntriesSdsTableValues getEntriesSdsTableValues = entriesSdsList.get(i);

            long sdId = getEntriesSdsTableValues.getSdId();

            databaseEntriesVernacularSdsAdapter = new DatabaseEntriesVernacularSdsAdapter(getContext(), 0, 0, 0);
//
            entriesVernacularList = databaseEntriesVernacularSdsAdapter.getVernacularsToSearchDisplayBySdId(sdId);




            entriesSemanticSourceAdapter = new EntriesSemanticSourceAdapter(getContext(), entriesSdsList, entriesVernacularList, rvEntriesDisplaySl);



        }

//        vpEntries.setAdapter(entriesSemanticSourceAdapter);



        //Initialize letter adapter
        semanticSourceAdapter = new SemanticSourceAdapter(entriesSdsList);

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
        for (int i=0; i<entriesSdsList.size(); i++)
        {
            GetEntriesSdsTableValues getEntriesSdsTableValues = entriesSdsList.get(i);


            String sdName = getEntriesSdsTableValues.getSdName();


//        for (int i = 0; i < 10; i++) {

            mTabLayout.addTab(mTabLayout.newTab().setText(sdName));
//            mTabLayout.addTab(mTabLayout.newTab().setText("Category: " + i));
        }
        DynamicFragmentSemanticSrcAdapter mDynamicFragmentAdapter = new DynamicFragmentSemanticSrcAdapter(getFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(mDynamicFragmentAdapter);
        viewPager.setCurrentItem(0);
    }

}