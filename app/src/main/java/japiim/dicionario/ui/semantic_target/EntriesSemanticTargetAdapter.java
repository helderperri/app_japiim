package japiim.dicionario.ui.semantic_target;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetEntriesGlossesSdsTableValues;
import japiim.dicionario.GetEntriesSdsTableValues;
import japiim.dicionario.GetEntriesVernacularSdsTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesSdsScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesSdsScrollDisplayTl;

public class EntriesSemanticTargetAdapter extends RecyclerView.Adapter<EntriesSemanticTargetAdapter.ViewHolder> {


    //Initialize variable
    List<GetEntriesSdsTableValues> semanticDomainsList;


    Context context;
    RecyclerView rvEntriesScrollDisplayTl;

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterEntriesSdsScrollDisplayTl recyclerViewAdapterEntriesSdsScrollDisplayTl;
    List<GetEntriesGlossesSdsTableValues> entriesGlossesList;


    //Create constructor

    public EntriesSemanticTargetAdapter(Context context, List<GetEntriesSdsTableValues> semanticDomainsList, List<GetEntriesGlossesSdsTableValues> entriesGlossesList, RecyclerView rvEntriesScrollDisplaySl ){
        this.entriesGlossesList = entriesGlossesList;
        this.semanticDomainsList =semanticDomainsList;
      this.rvEntriesScrollDisplayTl = rvEntriesScrollDisplayTl;
        this.context = context;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_tl, parent, false);

        //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        rvEntriesScrollDisplayTl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvEntriesScrollDisplayTl.setLayoutManager(layoutManager);
        recyclerViewAdapterEntriesSdsScrollDisplayTl = new RecyclerViewAdapterEntriesSdsScrollDisplayTl(context, entriesGlossesList, rvEntriesScrollDisplayTl);
        rvEntriesScrollDisplayTl.setAdapter(recyclerViewAdapterEntriesSdsScrollDisplayTl);
    }

    @Override
    public int getItemCount() {
        return semanticDomainsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
                   super(itemView);
                   //Assign variable
            rvEntriesScrollDisplayTl = itemView.findViewById(R.id.rvEntriesScrollDisplayTl);
        }
    }
}
