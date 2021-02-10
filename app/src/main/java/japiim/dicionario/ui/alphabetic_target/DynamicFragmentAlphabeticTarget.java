package japiim.dicionario.ui.alphabetic_target;

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
import japiim.dicionario.DatabaseEntriesGlossesAdapter;
import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseSourceLettersAdapter;
import japiim.dicionario.DatabaseTargetLettersAdapter;
import japiim.dicionario.GetEntriesGlossesTableValues;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplayTl;
import japiim.dicionario.ui.alphabetic_source.EntriesSourceAdapter;
import japiim.dicionario.ui.alphabetic_source.LettersSourceAdapter;


public class DynamicFragmentAlphabeticTarget extends Fragment {
    private RecyclerView rv;
    int posi = 0;
    RecyclerView rvEntriesScrollDisplayTl;

    RecyclerViewAdapterEntriesScrollDisplayTl recyclerViewAdapterEntriesScrollDisplayTl;

    EntriesTargetAdapter entriesTargetAdapter;
    LettersTargetAdapter lettersAdapter;
    DatabaseTargetLettersAdapter databaseTargetLettersAdapter;
    List<GetTargetLettersTableValues> targetLettersList = new ArrayList<>();


    DatabaseEntriesGlossesAdapter databaseEntriesGlossesAdapter;

    RecyclerView rvEntriesDisplaySl;
    List<GetEntriesGlossesTableValues> entriesGlossesList = new ArrayList<>();
    private ArrayList<Fragment> arrayList = new ArrayList<>();


    public static DynamicFragmentAlphabeticTarget newInstance() {
        return new DynamicFragmentAlphabeticTarget();
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
        databaseTargetLettersAdapter = new DatabaseTargetLettersAdapter(getContext(), 0);
        targetLettersList = databaseTargetLettersAdapter.getTargetLetters();

        initViews(view);
        return view;
    }

    private void initViews(View view) {
        try {
            TextView textView = view.findViewById(R.id.commonTextView);
            int posi = getArguments().getInt("position");
            GetTargetLettersTableValues getTargetLettersTableValues = targetLettersList.get(posi);

            String glyph = getTargetLettersTableValues.getGlyph().toLowerCase();

            long glyphId = getTargetLettersTableValues.getGlyphId();

            databaseEntriesGlossesAdapter = new DatabaseEntriesGlossesAdapter(getContext(), 0, 0, 0);
            //entriesGlossesList = databaseEntriesGlossesAdapter.getGlossessToSearchDisplayByGlyph(glyph);
            entriesGlossesList = databaseEntriesGlossesAdapter.getGlossessToSearchDisplayByGlyphId(glyphId);

//        entriesTargetAdapter = new EntriesTargetAdapter(getContext(), targetLettersList, entriesGlossesList, rvEntriesDisplaySl);


            recyclerViewAdapterEntriesScrollDisplayTl = new RecyclerViewAdapterEntriesScrollDisplayTl(getActivity(), entriesGlossesList, rv);

//        vpEntries.setAdapter(entriesSourceAdapter);
            rv.setAdapter(recyclerViewAdapterEntriesScrollDisplayTl);
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
