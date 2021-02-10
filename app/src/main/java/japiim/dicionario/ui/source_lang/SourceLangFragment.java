package japiim.dicionario.ui.source_lang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.reddit.indicatorfastscroll.FastScrollItemIndicator;
import com.reddit.indicatorfastscroll.FastScrollerThumbView;
import com.reddit.indicatorfastscroll.FastScrollerView;

import java.util.ArrayList;
import java.util.List;

import japiim.dicionario.DatabaseEntriesGlossesAdapter;
import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseFormsAdapter;
import japiim.dicionario.DatabaseGlossesAdapter;
import japiim.dicionario.DatabaseSourceLettersAdapter;
import japiim.dicionario.GetEntriesGlossesTableValues;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetFormsTableValues;
import japiim.dicionario.GetGlossesTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterAlphaButtonsScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplayTl;

public class SourceLangFragment extends Fragment {

    private SourceLangViewModel sourcelangViewModel;

    DatabaseGlossesAdapter databaseGlossesAdapter;
    DatabaseFormsAdapter databaseFormsAdapter;
    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    DatabaseEntriesGlossesAdapter databaseEntriesGlossesAdapter;
    RecyclerView rvEntriesDisplayTl;
    RecyclerView rvEntriesDisplaySl;
    FastScrollerView fastScrollerView;
    FastScrollerThumbView fastScrollerThumbView;
    RecyclerViewAdapterEntriesScrollDisplayTl recyclerViewAdapterEntriesScrollDisplayTl;
    RecyclerViewAdapterEntriesScrollDisplaySl recyclerViewAdapterEntriesScrollDisplaySl;
    RecyclerView.LayoutManager layoutManager;
    List<GetGlossesTableValues> glossesList = new ArrayList<>();
    List<GetFormsTableValues> formsList = new ArrayList<>();
    List<GetEntriesGlossesTableValues> entriesGlossesList = new ArrayList<>();
    List<GetEntriesVernacularTableValues> entriesVernacularList = new ArrayList<>();

    TabLayout tabLayout;


    DatabaseSourceLettersAdapter databaseSourceLettersAdapter;
    RecyclerView rvSourceLettersDisplaySl;
    RecyclerViewAdapterAlphaButtonsScrollDisplaySl recyclerViewAdapterAlphaButtonsScrollDisplaySl;
    List<GetSourceLettersTableValues> sourceLettersList = new ArrayList<>();
    long positionBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sourcelangViewModel =
                new ViewModelProvider(this).get(SourceLangViewModel.class);
        View root = inflater.inflate(R.layout.fragment_source_lang, container, false);


        //final RecyclerView rvEntriesDisplaySl = root.findViewById(R.id.rvEntriesScrollDisplaySl);

        //tabLayout = root.findViewById(R.id.tabLayout);


        databaseEntriesVernacularAdapter = new DatabaseEntriesVernacularAdapter(getContext(), 0, 0, 0);
        entriesVernacularList = databaseEntriesVernacularAdapter.getVernacularsToSearchDisplay();

        rvEntriesDisplaySl = root.findViewById(R.id.rvEntriesScrollDisplaySl);
        fastScrollerView = root.findViewById(R.id.sample_basic_fastscroller);
        fastScrollerThumbView = root.findViewById(R.id.sample_basic_fastscroller_thumb);


        rvEntriesDisplaySl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvEntriesDisplaySl.setLayoutManager(layoutManager);
        recyclerViewAdapterEntriesScrollDisplaySl = new RecyclerViewAdapterEntriesScrollDisplaySl(getContext(), entriesVernacularList, rvEntriesDisplaySl);
        rvEntriesDisplaySl.setAdapter(recyclerViewAdapterEntriesScrollDisplaySl);





        databaseSourceLettersAdapter = new DatabaseSourceLettersAdapter(getContext(), 0);
        sourceLettersList = databaseSourceLettersAdapter.getSourceLetters();

        rvSourceLettersDisplaySl = root.findViewById(R.id.rvAlphaButtonsScrollDisplaySl);
        rvSourceLettersDisplaySl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvSourceLettersDisplaySl.setLayoutManager(layoutManager);
        recyclerViewAdapterAlphaButtonsScrollDisplaySl = new RecyclerViewAdapterAlphaButtonsScrollDisplaySl(getContext(), sourceLettersList, rvSourceLettersDisplaySl, rvSourceLettersDisplaySl);
        rvSourceLettersDisplaySl.setAdapter(recyclerViewAdapterAlphaButtonsScrollDisplaySl);


        //final TextView textView = root.findViewById(R.id.text_source_lang);

        sourcelangViewModel.getText(R.string.title_source_lang).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }

            //public void onChanged(@Nullable String s) { textView.setText(s); }
        });

/*        fastScrollerView.setupWithRecyclerView(
                rvEntriesDisplaySl,
                (position) -> {
                    GetEntriesVernacularTableValues item = entriesVernacularList.get(position); // Get your model object
                    // or fetch the section at [position] from your database
                    return new FastScrollItemIndicator.Text(
                            item.getVernacular().substring(0, 1).toUpperCase() // Grab the first letter and capitalize it
                    ); // Return a text indicator
                }
        );*/


        fastScrollerView.setupWithRecyclerView(
                rvEntriesDisplaySl,
                (position) -> {
                    GetEntriesVernacularTableValues item = entriesVernacularList.get(position); // Get your model object
                    // or fetch the section at [position] from your database
                    return new FastScrollItemIndicator.Text(
                            item.getVernacular().substring(0, 1).toUpperCase() // Grab the first letter and capitalize it
                    ); // Return a text indicator
                }
        );

        fastScrollerThumbView.setupWithFastScroller(fastScrollerView);

        return root;
    }
}