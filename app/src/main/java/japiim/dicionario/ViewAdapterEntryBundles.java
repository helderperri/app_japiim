
package japiim.dicionario;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapterEntryBundles extends AppCompatActivity {
    long formBundleIid;

    long entryBundleId;

    RecyclerView.LayoutManager layoutManager;


    List<GetEntriesTableValues> entriesList = new ArrayList<>();

    DatabaseFormBundlesAdapter databaseFormBundlesAdapter;

    DatabaseEntriesAdapter databaseEntriesAdapter;

    RecyclerView rvEntries;
    RecyclerViewAdapterEntries recyclerViewAdapterEntries;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item_entry_bundle);
        formBundleIid = getIntent().getExtras().getLong("form_bundle_id");
        //String vernacular = getIntent().getExtras().getString("vernacular");
        //String entry_ref = getIntent().getExtras().getString("entry_ref");



        /*
        These two TextViews tvGlossRef and tvEntryRefRef were put here just for reference!!!.
        The data that they hold is incomplete. There may be sibling data associated with them.
        The data in tvGlossRef should be retrieved through entry_bundle > entry > sense_bundle > glosses
        The data in tvEntryRefRef should be retrieved through entry_bundle > entry > form_bundle > forms

         */
        //tvGlossRef = findViewById(R.id.tvGlossRef);
        //tvEntryRefRef = findViewById(R.id.tvEntryRefRef);
        //tvGlossRef.setText(gloss);
        //vEntryRefRef.setText(entry_ref);




        /*
        use the senseBundleIid variable to get the entryBundleId variable, which is the primary id of the table "entry_bundles"
        on the top of the database hierarchy.

         */
        //databaseFormBundlesAdapter = new DatabaseFormBundlesAdapter(this, 0, formBundleIid);
        entryBundleId = getIntent().getExtras().getLong("entry_bundle_id");;

        //tvEntryBundleId = findViewById(R.id.tvEntryBundleId);

        //tvEntryBundleId.setText("entry bundle id: " + entryBundleId);




        /*

        Use the variable entryBundleId to retrieve the all entries in the "entries" table.
        Get each entryId.

        In the current database, there is only one entry in each entry_bundle (1-to-1 relation).
        Other databases however have more than one entry in each entry_bundle, that's
        why we must keep "entries" in a RecycleView.

         */


        databaseEntriesAdapter = new DatabaseEntriesAdapter(this, 0, entryBundleId);

        entriesList = databaseEntriesAdapter.getAllEntries(entryBundleId);

        rvEntries = findViewById(R.id.rvEntries);
        rvEntries.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvEntries.setLayoutManager(layoutManager);
        recyclerViewAdapterEntries = new RecyclerViewAdapterEntries(this, entriesList, rvEntries);
        rvEntries.setAdapter(recyclerViewAdapterEntries);




        /*
        senseBundlesList = databaseSenseBundlesAdapter.getSenseBundles();
        rvSenseBundles = findViewById(R.id.rvSenseBundles);
        rvSenseBundles.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvSenseBundles.setLayoutManager(layoutManager);
        recyclerViewAdapterSenseBundles = new RecyclerViewAdapterSenseBundles(this, senseBundlesList, rvSenseBundles);
        rvSenseBundles.setAdapter(recyclerViewAdapterSenseBundles);
        */





        /*
        databaseExampleBundlesAdapter = new DatabaseExampleBundlesAdapter(this, senseBundleIid);
        exampleBundlesList = databaseExampleBundlesAdapter.getExampleBundles();
        rvExampleBundles = findViewById(R.id.rvExampleBundles);
        rvExampleBundles.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvExampleBundles.setLayoutManager(layoutManager);
        recyclerViewAdapterExampleBundles = new RecyclerViewAdapterExampleBundles(this, exampleBundlesList, rvExampleBundles);
        rvExampleBundles.setAdapter(recyclerViewAdapterExampleBundles);
        */

/*
        for(int i=0; i<exampleBundlesList.size(); i++) {
            GetExampleBundlesTableValues getExampleBundlesTableValues = exampleBundlesList.get(i);
            // Do something with the value
            long example_bundle_id = getExampleBundlesTableValues.getExampleBundleId();
            //long example_bundle_id = exampleBundlesList.get(2).getExampleBundleId();
            int elementId = getResources().getIdentifier("tvExampleBundleId"+i+"", "id", getPackageName());
            tvExampleBundleId = findViewById(elementId);
            tvExampleBundleId.setText(""+example_bundle_id);


        }

*/
    }

    public void backToEntryList (View view){

        finish();

    }
}
