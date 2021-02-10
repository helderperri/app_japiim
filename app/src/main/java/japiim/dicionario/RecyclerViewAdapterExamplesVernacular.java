
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

public class RecyclerViewAdapterExamplesVernacular extends RecyclerView.Adapter<RecyclerViewAdapterExamplesVernacular.ViewHolder> {

    Context context;
    List<GetExamplesVernacularTableValues> examplesVernacularList;
    RecyclerView rvExamplesVernacular;


    RecyclerView.LayoutManager layoutManager;

    DatabaseExamplePronsAdapter databaseExamplePronsAdapter;
    RecyclerView rvExampleProns;
    RecyclerViewAdapterExampleProns recyclerViewAdapterExampleProns;
    RecyclerView rvExamplePhonetics;
    RecyclerViewAdapterExamplePhonetics recyclerViewAdapterExamplePhonetics;
    List<GetExamplePronsTableValues> pronsList = new ArrayList<>();
    long exampleId;



    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowExampleVernacularId;
        TextView rowExampleVernacular;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowExampleVernacularId = itemView.findViewById(R.id.tvExampleId);
            rowExampleVernacular = itemView.findViewById(R.id.tvExampleVernacular);
        }
    }

    public RecyclerViewAdapterExamplesVernacular(Context context, List<GetExamplesVernacularTableValues> examplesVernacularList, RecyclerView rvExamplesVernacular){
        this.context = context;
        this.examplesVernacularList = examplesVernacularList;
        this.rvExamplesVernacular = rvExamplesVernacular;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterExamplesVernacular.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_example_vernacular, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterExamplesVernacular.ViewHolder viewHolder, int i) {
        GetExamplesVernacularTableValues getExampleVernacularTableValues = examplesVernacularList.get(i);

        //viewHolder.rowExampleVernacularId.setText("example vernacular id: "+getExampleVernacularTableValues.getExampleId());
        viewHolder.rowExampleVernacular.setText(""+getExampleVernacularTableValues.getExampleVernacular());


        exampleId = getExampleVernacularTableValues.getExampleId();


        databaseExamplePronsAdapter = new DatabaseExamplePronsAdapter(context, exampleId, 0);
        pronsList = databaseExamplePronsAdapter.getExampleProns();

        layoutManager = new LinearLayoutManager(context);

        rvExampleProns = viewHolder.itemView.findViewById(R.id.rvExampleProns);
        rvExampleProns.setHasFixedSize(true);

        rvExampleProns.setLayoutManager(layoutManager);
        recyclerViewAdapterExampleProns = new RecyclerViewAdapterExampleProns(context, pronsList, rvExampleProns);
        rvExampleProns.setAdapter(recyclerViewAdapterExampleProns);

        rvExamplePhonetics = viewHolder.itemView.findViewById(R.id.rvExamplePhonetics);
        rvExamplePhonetics.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(context);

        rvExamplePhonetics.setLayoutManager(layoutManager);
        recyclerViewAdapterExamplePhonetics = new RecyclerViewAdapterExamplePhonetics(context, pronsList, rvExamplePhonetics);
        rvExamplePhonetics.setAdapter(recyclerViewAdapterExamplePhonetics);


    }

    @Override
    public int getItemCount() {
        return examplesVernacularList.size();
    }

}
