package japiim.dicionario.ui.alphabetic_target;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetEntriesGlossesTableValues;
import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplayTl;

public class EntriesTargetAdapter extends RecyclerView.Adapter<EntriesTargetAdapter.ViewHolder> {


    //Initialize variable
    List<GetTargetLettersTableValues> targetLettersList;

    Context context;
    RecyclerView rvEntriesScrollDisplayTl;

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterEntriesScrollDisplayTl recyclerViewAdapterEntriesScrollDisplayTl;
     List<GetEntriesGlossesTableValues> entriesGlossesList;

    //Create constructor

    public EntriesTargetAdapter(Context context, List<GetTargetLettersTableValues> targetLettersList, List<GetEntriesGlossesTableValues> entriesGlossesList, RecyclerView rvEntriesScrollDisplayTl ){
        this.entriesGlossesList = entriesGlossesList;
        this.targetLettersList =targetLettersList;
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
        recyclerViewAdapterEntriesScrollDisplayTl = new RecyclerViewAdapterEntriesScrollDisplayTl(context, entriesGlossesList, rvEntriesScrollDisplayTl);
        rvEntriesScrollDisplayTl.setAdapter(recyclerViewAdapterEntriesScrollDisplayTl);
    }

    @Override
    public int getItemCount() {
        return targetLettersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
                   super(itemView);
                   //Assign variable
             rvEntriesScrollDisplayTl = itemView.findViewById(R.id.rvEntriesScrollDisplayTl);
        }
    }
}
