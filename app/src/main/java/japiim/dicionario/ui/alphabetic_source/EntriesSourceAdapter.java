package japiim.dicionario.ui.alphabetic_source;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetEntriesVernacularTableValues;
import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;
import japiim.dicionario.RecyclerViewAdapterEntriesScrollDisplaySl;

public class EntriesSourceAdapter extends RecyclerView.Adapter<EntriesSourceAdapter.ViewHolder> {


    //Initialize variable
    List<GetSourceLettersTableValues> sourceLettersList;


    Context context;
    RecyclerView rvEntriesScrollDisplaySl;

    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterEntriesScrollDisplaySl recyclerViewAdapterEntriesScrollDisplaySl;
    List<GetEntriesVernacularTableValues> entriesVernacularList;


    //Create constructor

    public EntriesSourceAdapter(Context context, List<GetSourceLettersTableValues> sourceLettersList, List<GetEntriesVernacularTableValues> entriesVernacularList, RecyclerView rvEntriesScrollDisplaySl ){
        this.entriesVernacularList = entriesVernacularList;
        this.sourceLettersList =sourceLettersList;
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

//        rvEntriesScrollDisplaySl.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(context);
//        rvEntriesScrollDisplaySl.setLayoutManager(layoutManager);
        Log.e("Alphhaentri ",sourceLettersList.get(0).getGlyph()+" w "+entriesVernacularList.get(0).getVernacular() );
        recyclerViewAdapterEntriesScrollDisplaySl = new RecyclerViewAdapterEntriesScrollDisplaySl(context, entriesVernacularList, rvEntriesScrollDisplaySl);
        rvEntriesScrollDisplaySl.setAdapter(recyclerViewAdapterEntriesScrollDisplaySl);
    }

    @Override
    public int getItemCount() {
        return sourceLettersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
                   super(itemView);
                   //Assign variable
            rvEntriesScrollDisplaySl = itemView.findViewById(R.id.rvEntriesScrollDisplaySl);
        }
    }
}
