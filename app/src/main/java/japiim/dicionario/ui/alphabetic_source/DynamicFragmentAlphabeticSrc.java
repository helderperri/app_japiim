package japiim.dicionario.ui.alphabetic_source;

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
import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseSourceLettersAdapter;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;


public class DynamicFragmentAlphabeticSrc extends Fragment {
    RecyclerView rvEntriesScrollDisplaySl;
    RecyclerViewAdapterEntriesScrollDisplaySl recyclerViewAdapterEntriesScrollDisplaySl;
    private RecyclerView rv;
    int posi = 0;
    ViewPager2 vpEntries;

    EntriesSourceAdapter entriesSourceAdapter;
    LettersSourceAdapter lettersAdapter;

    TabLayout tabLayout;

    DatabaseSourceLettersAdapter databaseSourceLettersAdapter;
    List<GetSourceLettersTableValues> sourceLettersList = new ArrayList<>();

    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    RecyclerView rvEntriesDisplaySl;
    List<GetEntriesVernacularTableValues> entriesVernacularList = new ArrayList<>();

    public static DynamicFragmentAlphabeticSrc newInstance() {
        return new DynamicFragmentAlphabeticSrc();
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

        databaseSourceLettersAdapter = new DatabaseSourceLettersAdapter(getActivity(), 0);
        sourceLettersList = databaseSourceLettersAdapter.getSourceLetters();

        initViews(view);
        return view;
    }

    private void initViews(View view) {
        try {
            TextView textView = view.findViewById(R.id.commonTextView);
            int posi = getArguments().getInt("position");
            GetSourceLettersTableValues getSourceLettersTableValues;
            getSourceLettersTableValues = sourceLettersList.get(posi);
            textView.setText(String.valueOf(getSourceLettersTableValues + "Category :  " + getArguments().getInt("position")));

            //String glyph = getSourceLettersTableValues.getGlyph().toLowerCase();
            long glyphId = getSourceLettersTableValues.getGlyphId();


            databaseEntriesVernacularAdapter = new DatabaseEntriesVernacularAdapter(getContext(), 0, 0, 0);
//            entriesVernacularList = databaseEntriesVernacularAdapter.getVernacularsToSearchDisplayByGlyph(glyph);
            entriesVernacularList = databaseEntriesVernacularAdapter.getVernacularsToSearchDisplayByGlyphId(glyphId);
            Log.e("Alphhaview", posi + " e " + " k " + sourceLettersList.get(posi).getGlyph() + " w " + entriesVernacularList.size());
//        Log.e("Alphhaview",posi+" e "+" k "+sourceLettersList.get(posi).getGlyph()+" w "+entriesVernacularList.get(posi).getVernacular() );
//        entriesSourceAdapter = new EntriesSourceAdapter(getContext(), sourceLettersList, entriesVernacularList, rvEntriesDisplaySl);
            recyclerViewAdapterEntriesScrollDisplaySl = new RecyclerViewAdapterEntriesScrollDisplaySl(getActivity(), entriesVernacularList, rv);

//        vpEntries.setAdapter(entriesSourceAdapter);
            rv.setAdapter(recyclerViewAdapterEntriesScrollDisplaySl);
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
