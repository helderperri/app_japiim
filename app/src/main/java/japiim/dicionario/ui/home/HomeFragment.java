package japiim.dicionario.ui.home;

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
import androidx.viewpager2.widget.ViewPager2;

import japiim.dicionario.DatabaseEntriesVernacularAdapter;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.R;

public class HomeFragment extends Fragment {

    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    GetEntriesVernacularTableValues entriesVernacularList;
    private HomeViewModel homeViewModel;
    ViewPager2 vpVertical, vpHorizontal, vpEntries;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        vpEntries = root.findViewById(R.id.vp_entries);


        //databaseEntriesVernacularAdapter = new DatabaseEntriesVernacularAdapter(getContext(), 0, 0, 0);
        //entriesVernacularList = (GetEntriesVernacularTableValues) databaseEntriesVernacularAdapter.getVernacularsToSearchDisplay();




        return root;
    }
}