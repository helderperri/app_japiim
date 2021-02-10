
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

public class RecyclerViewAdapterVernaculars extends RecyclerView.Adapter<RecyclerViewAdapterVernaculars.ViewHolder> {

    Context context;
    List<GetFormsTableValues> vernacularsList;
    RecyclerView rvVernaculars;


    RecyclerView.LayoutManager layoutManager;

    DatabasePhonemicsAdapter databasePhonemicsAdapter;
    RecyclerView rvPhonemics;
    RecyclerViewAdapterPhonemics recyclerViewAdapterPhonemics;
    List<GetPhonemicsTableValues> phonemicsList = new ArrayList<>();
    long formId;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowFormId;
        TextView rowVernacular;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowFormId = itemView.findViewById(R.id.tvFormId);
            rowVernacular = itemView.findViewById(R.id.tvVernacular);
        }
    }

    public RecyclerViewAdapterVernaculars(Context context, List<GetFormsTableValues> vernacularsList, RecyclerView rvVernaculars){
        this.context = context;
        this.vernacularsList = vernacularsList;
        this.rvVernaculars = rvVernaculars;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterVernaculars.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_vernacular, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterVernaculars.ViewHolder viewHolder, int i) {
        GetFormsTableValues getFormsTableValues = vernacularsList.get(i);

        //viewHolder.rowFormId.setText("form id: "+getFormsTableValues.getFormId());
        viewHolder.rowVernacular.setText(""+getFormsTableValues.getVernacular());

        formId = getFormsTableValues.getFormId();


        databasePhonemicsAdapter = new DatabasePhonemicsAdapter(context, formId, 0);
        phonemicsList = databasePhonemicsAdapter.getPhonemics();
        rvPhonemics = viewHolder.itemView.findViewById(R.id.rvPhonemics);
        rvPhonemics.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvPhonemics.setLayoutManager(layoutManager);
        recyclerViewAdapterPhonemics = new RecyclerViewAdapterPhonemics(context, phonemicsList, rvPhonemics);
        rvPhonemics.setAdapter(recyclerViewAdapterPhonemics);




    }

    @Override
    public int getItemCount() {
        return vernacularsList.size();
    }

}
