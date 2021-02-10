package japiim.dicionario.ui.semantic_source;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetEntriesSdsTableValues;
import japiim.dicionario.GetEntriesVernacularSdsTableValues;
import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;
import japiim.dicionario.RecyclerViewAdapterEntriesSdsScrollDisplaySl;
import japiim.dicionario.ui.alphabetic_source.EntriesSourceAdapter;

public class EntriesSemanticSourceAdapter extends RecyclerView.Adapter<EntriesSemanticSourceAdapter.ViewHolder> {


    //Initialize variable
    List<GetEntriesSdsTableValues> semanticDomainsList;


    Context context;
    RecyclerView rvEntriesScrollDisplaySl;

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterEntriesSdsScrollDisplaySl recyclerViewAdapterEntriesSdsScrollDisplaySl;
    List<GetEntriesVernacularSdsTableValues> entriesVernacularList;


    //Create constructor

    public EntriesSemanticSourceAdapter(Context context, List<GetEntriesSdsTableValues> semanticDomainsList, List<GetEntriesVernacularSdsTableValues> entriesVernacularList, RecyclerView rvEntriesScrollDisplaySl ){
        this.entriesVernacularList = entriesVernacularList;
        this.semanticDomainsList =semanticDomainsList;
      this.rvEntriesScrollDisplaySl = rvEntriesScrollDisplaySl;
        this.context = context;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_sl, parent, false);

        //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        rvEntriesScrollDisplaySl.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvEntriesScrollDisplaySl.setLayoutManager(layoutManager);
        recyclerViewAdapterEntriesSdsScrollDisplaySl = new RecyclerViewAdapterEntriesSdsScrollDisplaySl(context, entriesVernacularList, rvEntriesScrollDisplaySl);
        rvEntriesScrollDisplaySl.setAdapter(recyclerViewAdapterEntriesSdsScrollDisplaySl);
    }

    @Override
    public int getItemCount() {
        return semanticDomainsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
                   super(itemView);
                   //Assign variable
            rvEntriesScrollDisplaySl = itemView.findViewById(R.id.rvEntriesScrollDisplaySl);
        }
    }
}
