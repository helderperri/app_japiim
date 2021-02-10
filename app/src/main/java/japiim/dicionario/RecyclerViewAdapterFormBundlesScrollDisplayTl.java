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

public class RecyclerViewAdapterFormBundlesScrollDisplayTl extends RecyclerView.Adapter<RecyclerViewAdapterFormBundlesScrollDisplayTl.ViewHolder> {

    Context context;
    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    List<GetEntriesVernacularTableValues> getEntriesVernacular;
    List<GetEntriesVernacularTableValues> entriesVernacularList;


    RecyclerView rvFormBundlesScrollDisplayTl;

    RecyclerView rvFormBundles;
    RecyclerView rvGlossesScrollDisplayTl;
    RecyclerView.LayoutManager layoutManager;
    DatabaseGlossesAdapter databaseGlossesAdapter;
    long formBundleId;
    long entryBundleId;
    String vernacular;
    String partOfSpeech;

    DatabaseFormsAdapter databaseFormsAdapter;
    List<GetFormsTableValues> formsList;

    DatabaseClassesAdapter databaseClassesAdapter;
    List<GetClassesTableValues> classesList;



    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowVernacular;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowVernacular = itemView.findViewById(R.id.tvVernacularScrollDisplayTl);
        }
    }

    public RecyclerViewAdapterFormBundlesScrollDisplayTl(Context context, List<GetEntriesVernacularTableValues> entriesVernacularList, RecyclerView rvFormBundlesScrollDisplayTl){
        this.context = context;
        this.entriesVernacularList = entriesVernacularList;
        this.rvFormBundlesScrollDisplayTl = rvFormBundlesScrollDisplayTl;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterFormBundlesScrollDisplayTl.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_form_bundles_scroll_display_tl, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterFormBundlesScrollDisplayTl.ViewHolder viewHolder, int i) {
        GetEntriesVernacularTableValues entryVernacular = entriesVernacularList.get(i);

        vernacular = entryVernacular.getVernacular();
        viewHolder.rowVernacular.setText(""+ vernacular);




    }

    @Override
    public int getItemCount() {
        return entriesVernacularList.size();
    }
}
