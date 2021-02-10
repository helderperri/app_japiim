package japiim.dicionario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterEntries extends RecyclerView.Adapter<RecyclerViewAdapterEntries.ViewHolder> {

    Context context;
    List<GetEntriesTableValues> entriesList;
    RecyclerView rvEntries;


    RecyclerView.LayoutManager layoutManager;

    DatabaseFormBundlesAdapter databaseFormBundlesAdapter;
    RecyclerView rvFormBundles;
    RecyclerViewAdapterFormBundles recyclerViewAdapterFormBundles;
    List<GetFormBundlesTableValues> formBundlesList = new ArrayList<>();


    DatabaseSenseBundlesAdapter databaseSenseBundlesAdapter;
    RecyclerView rvSenseBundles;
    RecyclerViewAdapterSenseBundles recyclerViewAdapterSenseBundles;
    List<GetSenseBundlesTableValues> senseBundlesList = new ArrayList<>();


    long entryId;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowEntryId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //rowSenseBundleId = itemView.findViewById(R.id.sense_bundle_id);
            //rowGlossId = itemView.findViewById(R.id.gloss_id);
            //rowEntryId = itemView.findViewById(R.id.tvEntryId);
            //rowEntryId = itemView.findViewById(R.id.tvEntryId);
            //rowImage = itemView.findViewById(R.id.item_image);
        }
    }

    public RecyclerViewAdapterEntries(Context context, List<GetEntriesTableValues> entriesList, RecyclerView rvEntries){
        this.context = context;
        this.entriesList = entriesList;
        this.rvEntries = rvEntries;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterEntries.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_entry, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterEntries.ViewHolder viewHolder, int i) {
        GetEntriesTableValues getEntriesTableValues = entriesList.get(i);
        //viewHolder.rowEntryId.setText("entry id: "+getEntriesTableValues.getEntryId());

        entryId = getEntriesTableValues.getEntryId();

        /*
        now I am trying to get the data from the tables "form_bundles" and "sense_bundles" and
        populate it on the Recycle Views "rvFormBundles" and "rvSenseBundles".
        Both "form_bundles" and "sense_bundles" tables are child of "entries" table.

        */
        databaseFormBundlesAdapter = new DatabaseFormBundlesAdapter(context, entryId, 0);
        formBundlesList = databaseFormBundlesAdapter.getFormBundles();
        rvFormBundles = viewHolder.itemView.findViewById(R.id.rvFormBundles);
        rvFormBundles.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvFormBundles.setLayoutManager(layoutManager);
        recyclerViewAdapterFormBundles = new RecyclerViewAdapterFormBundles(context, formBundlesList, rvFormBundles);
        rvFormBundles.setAdapter(recyclerViewAdapterFormBundles);



        databaseSenseBundlesAdapter = new DatabaseSenseBundlesAdapter(context, entryId, 0);
        senseBundlesList = databaseSenseBundlesAdapter.getSenseBundles();
        rvSenseBundles = viewHolder.itemView.findViewById(R.id.rvSenseBundles);
        rvSenseBundles.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvSenseBundles.setLayoutManager(layoutManager);
        recyclerViewAdapterSenseBundles = new RecyclerViewAdapterSenseBundles(context, senseBundlesList, rvSenseBundles);
        rvSenseBundles.setAdapter(recyclerViewAdapterSenseBundles);




    }

    @Override
    public int getItemCount() {
        return entriesList.size();
    }

}
