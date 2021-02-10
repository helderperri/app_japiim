package japiim.dicionario.ui.target_lang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reddit.indicatorfastscroll.FastScrollItemIndicator;
import com.reddit.indicatorfastscroll.FastScrollerThumbView;
import com.reddit.indicatorfastscroll.FastScrollerView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import japiim.dicionario.DatabaseEntriesGlossesAdapter;
import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.DatabaseFormsAdapter;
import japiim.dicionario.DatabaseGlossesAdapter;
import japiim.dicionario.DatabaseTargetLettersAdapter;
import japiim.dicionario.GetEntriesGlossesTableValues;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetFormsTableValues;
import japiim.dicionario.GetGlossesTableValues;
import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterAlphaButtonsScrollDisplayTl;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplayTl;

public class TargetLangFragment extends Fragment {

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


    DatabaseTargetLettersAdapter databaseTargetLettersAdapter;
    RecyclerView rvTargetLettersDisplayTl;
    RecyclerViewAdapterAlphaButtonsScrollDisplayTl recyclerViewAdapterAlphaButtonsScrollDisplayTl;
    List<GetTargetLettersTableValues> TargetLetterTlist = new ArrayList<>();
    long positionBtn;


    private TargetLangViewModel targetlangViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        targetlangViewModel =
                new ViewModelProvider(this).get(TargetLangViewModel.class);

        View root = inflater.inflate(R.layout.fragment_target_lang, container, false);

        //final TextView textView = root.findViewById(R.id.text_target_lang);

        databaseEntriesGlossesAdapter = new DatabaseEntriesGlossesAdapter(getContext(), 0, 0, 0);
        entriesGlossesList = databaseEntriesGlossesAdapter.getGlossessToSearchDisplay();



        rvEntriesDisplayTl = root.findViewById(R.id.rvEntriesScrollDisplayTl);
        fastScrollerView = root.findViewById(R.id.sample_basic_fastscroller);
        fastScrollerThumbView = root.findViewById(R.id.sample_basic_fastscroller_thumb);

        rvEntriesDisplayTl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvEntriesDisplayTl.setLayoutManager(layoutManager);
        recyclerViewAdapterEntriesScrollDisplayTl = new RecyclerViewAdapterEntriesScrollDisplayTl(getContext(), entriesGlossesList, rvEntriesDisplayTl);
        rvEntriesDisplayTl.setAdapter(recyclerViewAdapterEntriesScrollDisplayTl);




        databaseTargetLettersAdapter = new DatabaseTargetLettersAdapter(getContext(), 0);
        TargetLetterTlist = databaseTargetLettersAdapter.getTargetLetters();

        rvTargetLettersDisplayTl = root.findViewById(R.id.rvAlphaButtonsScrollDisplayTl);
        rvTargetLettersDisplayTl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvTargetLettersDisplayTl.setLayoutManager(layoutManager);
        recyclerViewAdapterAlphaButtonsScrollDisplayTl = new RecyclerViewAdapterAlphaButtonsScrollDisplayTl(getContext(), TargetLetterTlist, rvTargetLettersDisplayTl, rvTargetLettersDisplayTl);
        rvTargetLettersDisplayTl.setAdapter(recyclerViewAdapterAlphaButtonsScrollDisplayTl);



        targetlangViewModel.getText(R.string.title_target_lang).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
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
                rvEntriesDisplayTl,
                (position) -> {
                    GetEntriesGlossesTableValues item = entriesGlossesList.get(position); // Get your model object
                    // or fetch the section at [position] from your database
                    return new FastScrollItemIndicator.Text(
                            item.getGloss().substring(0, 1).toUpperCase() // Grab the first letter and capitalize it
                    ); // Return a text indicator
                }
        );

        fastScrollerThumbView.setupWithFastScroller(fastScrollerView);

        return root;
    }
}