package japiim.dicionario;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterEntriesScrollDisplaySl extends RecyclerView.Adapter<RecyclerViewAdapterEntriesScrollDisplaySl.ViewHolder> {

    Context context;
    List<GetFormsTableValues> formsList;
    RecyclerView rvEntriesScrollDisplaySl;

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterSenseBundlesScrollDisplaySl recyclerViewAdapterSenseBundlesScrollDisplaySl;
    DatabaseSenseBundlesAdapter databaseSenseBundlesAdapter;
    //RecyclerView rvGlosses;
    List<GetSenseBundlesTableValues> senseBundlesList = new ArrayList<>();
    long senseBundleId;
    long formBundleId;
    long entryBundleId;
    long entryId;
    RecyclerView rvSenseBundlesScrollDisplaySl;

    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    List<GetEntriesVernacularTableValues> entriesVernacularList;


    RecyclerView rvFormBundlesScrollDisplayTl;


    String vernacular;
    String def;
    String partOfSpeech;


    DatabaseSensesAdapter databaseSensesAdapter;
    List<GetSensesTableValues> sensesList;


    DatabaseEntriesDefsAdapter databaseEntriesDefsAdapter;
    List<GetEntriesDefsTableValues> entriesDefsList;

    DatabaseClassesAdapter databaseClassesAdapter;
    List<GetClassesTableValues> classesList;

    final public View.OnClickListener onClickListener = new MyOnClickListner();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //TextView rowSenseBundleId;
        //TextView rowFormId;
        //ImageView rowImage;

        TextView rowVernacular;
        //TextView rowClass;
        //TextView rowDef;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //rowSenseBundleId = itemView.findViewById(R.id.sense_bundle_id);
            //rowFormId = itemView.findViewById(R.id.gloss_id);
            rowVernacular = itemView.findViewById(R.id.tvVernacularScrollDisplaySl);
            //rowImage = itemView.findViewById(R.id.item_image);
            //rowDef = itemView.findViewById(R.id.tvDefScrollDisplay);
            //rowClass = itemView.findViewById(R.id.tvClassScrollDisplay);

        }
    }

    public RecyclerViewAdapterEntriesScrollDisplaySl(Context context, List<GetEntriesVernacularTableValues> entriesVernacularList, RecyclerView rvEntriesScrollDisplaySl){
        this.context = context;
        this.entriesVernacularList = entriesVernacularList;
        this.rvEntriesScrollDisplaySl = rvEntriesScrollDisplaySl;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterEntriesScrollDisplaySl.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_entries_scroll_display_sl, viewGroup, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterEntriesScrollDisplaySl.ViewHolder viewHolder, int i) {
        GetEntriesVernacularTableValues entryVernacular = entriesVernacularList.get(i);
  
        viewHolder.rowVernacular.setText(""+entryVernacular.getVernacular());
   
        entryBundleId = entryVernacular.getEntryBundleId();

        databaseEntriesDefsAdapter = new DatabaseEntriesDefsAdapter(context, entryBundleId,0, 0);
        entriesDefsList = databaseEntriesDefsAdapter.getEntriesDefs();
        rvSenseBundlesScrollDisplaySl = viewHolder.itemView.findViewById(R.id.rvSenseBundlesScrollDisplaySl);
        rvSenseBundlesScrollDisplaySl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvSenseBundlesScrollDisplaySl.setLayoutManager(layoutManager);
        recyclerViewAdapterSenseBundlesScrollDisplaySl = new RecyclerViewAdapterSenseBundlesScrollDisplaySl(context, entriesDefsList, rvSenseBundlesScrollDisplaySl);
        rvSenseBundlesScrollDisplaySl.setAdapter(recyclerViewAdapterSenseBundlesScrollDisplaySl);



    }

    @Override
    public int getItemCount() {
        return entriesVernacularList.size();
    }

    private class MyOnClickListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvEntriesScrollDisplaySl.getChildLayoutPosition(v);
            String vernacular = entriesVernacularList.get(itemPosition).getVernacular();
            //String entryRef = formsList.get(itemPosition).getEntryRef();
            long formBundleId = entriesVernacularList.get(itemPosition).getFormBundleId();
            long entryBundleId = entriesVernacularList.get(itemPosition).getEntryBundleId();
            //long formId = formsList.get(itemPosition).getFormId();

            Toast.makeText(context, vernacular, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, ViewAdapterEntryBundles.class);
            intent.putExtra("form_bundle_id", formBundleId);
            intent.putExtra("entry_bundle_id", entryBundleId);
            //intent.putExtra("form_id", formId);
            //intent.putExtra("vernacular", vernacular);
            //intent.putExtra("entry_ref", entryRef);
            context.startActivity(intent);


        }
    }
}
