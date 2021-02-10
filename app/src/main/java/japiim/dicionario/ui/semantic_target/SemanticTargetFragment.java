package japiim.dicionario.ui.semantic_target;

import android.os.Bundle;
import android.util.Log;
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

import japiim.dicionario.DatabaseEntriesGlossesSdsAdapter;
import japiim.dicionario.DatabaseEntriesSdsAdapter;
import japiim.dicionario.DatabaseEntriesVernacularSdsAdapter;
import japiim.dicionario.GetEntriesGlossesSdsTableValues;
import japiim.dicionario.GetEntriesSdsTableValues;
import japiim.dicionario.GetEntriesVernacularSdsTableValues;
import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.ui.alphabetic_target.DynamicFragmentAlphabetitargetAdapter;

public class SemanticTargetFragment extends Fragment {
    DatabaseEntriesSdsAdapter databaseEntriesSdsAdapter;

    List<GetEntriesSdsTableValues> entriesSdsList = new ArrayList<>();

    TabLayout tabLayout;

    EntriesSemanticTargetAdapter entriesSemanticTargetAdapter;
    SemanticTargetAdapter semanticTargetAdapter;

    DatabaseEntriesGlossesSdsAdapter databaseEntriesGlossesSdsAdapter;
    RecyclerView rvEntriesDisplayTl;
    List<GetEntriesGlossesSdsTableValues> entriesGlossesList = new ArrayList<>();


    ViewPager2 vpVertical, vpHorizontal, vpEntries;


    private ViewPager viewPager;
    private TabLayout mTabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_dynamic, container, false);
        //vpEntries = root.findViewById(R.id.vp_entries);
//        View root = inflater.inflate(R.layout.fragment_semantic_target, container, false);



//        tabLayout = root.findViewById(R.id.tabLayout);


        databaseEntriesSdsAdapter = new DatabaseEntriesSdsAdapter(getContext(), 0, "");
        entriesSdsList = databaseEntriesSdsAdapter.getSdsToSearchDisplay();

//        vpEntries = root.findViewById(R.id.vp_entries_sds);



        for (int i=0; i<entriesSdsList.size(); i++)
        {
            Log.e("semantarget", entriesSdsList.size()+" "+i+" w "+entriesSdsList.get(i).getSdId());
            GetEntriesSdsTableValues getEntriesSdsTableValues = entriesSdsList.get(i);

            long sdId = getEntriesSdsTableValues.getSdId();

            databaseEntriesGlossesSdsAdapter = new DatabaseEntriesGlossesSdsAdapter(getContext(), 0, 0, sdId);

            entriesGlossesList = databaseEntriesGlossesSdsAdapter.getGlossessToSearchDisplayBySdId(sdId);
//            entriesGlossesList = databaseEntriesGlossesSdsAdapter.getGlossessToSearchDisplayBySdId(5);




            entriesSemanticTargetAdapter = new EntriesSemanticTargetAdapter(getContext(), entriesSdsList, entriesGlossesList, rvEntriesDisplayTl);



        }

//        vpEntries.setAdapter(entriesSemanticTargetAdapter);



        //Initialize letter adapter
        semanticTargetAdapter = new SemanticTargetAdapter(entriesSdsList);



        initViews(root);
        /*TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, vpEntries, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                GetEntriesSdsTableValues getEntriesSdsTableValues = entriesSdsList.get(position);


                String sdName = getEntriesSdsTableValues.getSdName();
                switch (position){

                    default:
                        tab.setText(""+sdName);

                }
            }
        }
        );
        tabLayoutMediator.attach();
*/
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
        DynamicFragmentSemantictargetAdapter mDynamicFragmentAdapter = new DynamicFragmentSemantictargetAdapter(getFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(mDynamicFragmentAdapter);
        viewPager.setCurrentItem(0);
    }

}