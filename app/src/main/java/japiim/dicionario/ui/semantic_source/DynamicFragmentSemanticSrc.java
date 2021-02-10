package japiim.dicionario.ui.semantic_source;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import japiim.dicionario.DatabaseEntriesSdsAdapter;
import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseEntriesVernacularSdsAdapter;
import japiim.dicionario.DatabaseSourceLettersAdapter;
import japiim.dicionario.GetEntriesSdsTableValues;
import japiim.dicionario.GetEntriesVernacularSdsTableValues;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesSdsScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterSenseBundlesScrollDisplaySl;
import japiim.dicionario.ui.alphabetic_source.EntriesSourceAdapter;
import japiim.dicionario.ui.alphabetic_source.LettersSourceAdapter;


public class DynamicFragmentSemanticSrc extends Fragment {
    private RecyclerView rv;
    RecyclerView rvEntriesScrollDisplaySl;

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterEntriesSdsScrollDisplaySl recyclerViewAdapterEntriesSdsScrollDisplaySl;

    DatabaseEntriesSdsAdapter databaseEntriesSdsAdapter;

    List<GetEntriesSdsTableValues> entriesSdsList = new ArrayList<>();

//    TabLayout tabLayout;

    EntriesSemanticSourceAdapter entriesSemanticSourceAdapter;
    SemanticSourceAdapter semanticSourceAdapter;

    DatabaseEntriesVernacularSdsAdapter databaseEntriesVernacularSdsAdapter;
    RecyclerView rvEntriesDisplaySl;
    List<GetEntriesVernacularSdsTableValues> entriesVernacularList = new ArrayList<>();


    public static DynamicFragmentSemanticSrc newInstance() {
        return new DynamicFragmentSemanticSrc();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamic_fragment_layout, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        databaseEntriesSdsAdapter = new DatabaseEntriesSdsAdapter(getContext(), 0, "");
        entriesSdsList = databaseEntriesSdsAdapter.getSdsToSearchDisplay();

        initViews(view);
        return view;
    }

    private void initViews(View view) {
        try {
            TextView textView = view.findViewById(R.id.commonTextView);
            int posi = getArguments().getInt("position");
            GetEntriesSdsTableValues getEntriesSdsTableValues = entriesSdsList.get(posi);

            long sdId = getEntriesSdsTableValues.getSdId();

            databaseEntriesVernacularSdsAdapter = new DatabaseEntriesVernacularSdsAdapter(getContext(), 0, 0, 0);
//
            entriesVernacularList = databaseEntriesVernacularSdsAdapter.getVernacularsToSearchDisplayBySdId(sdId);


            entriesSemanticSourceAdapter = new EntriesSemanticSourceAdapter(getContext(), entriesSdsList, entriesVernacularList, rvEntriesDisplaySl);
            recyclerViewAdapterEntriesSdsScrollDisplaySl = new RecyclerViewAdapterEntriesSdsScrollDisplaySl(getActivity(), entriesVernacularList, rv);

//        vpEntries.setAdapter(entriesSourceAdapter);
            rv.setAdapter(recyclerViewAdapterEntriesSdsScrollDisplaySl);

        }catch (Exception e){}

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
