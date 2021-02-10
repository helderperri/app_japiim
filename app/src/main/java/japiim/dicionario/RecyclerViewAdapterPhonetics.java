
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

public class RecyclerViewAdapterPhonetics extends RecyclerView.Adapter<RecyclerViewAdapterPhonetics.ViewHolder> {

    Context context;
    List<GetPhoneticsTableValues> phoneticsList;
    RecyclerView rvPhonetics;




    RecyclerView.LayoutManager layoutManager;

    DatabasePronsAdapter databasePronsAdapter;
    RecyclerView rvProns;
    RecyclerViewAdapterProns recyclerViewAdapterProns;
    List<GetPronsTableValues> pronsList = new ArrayList<>();
    long phoneticId;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowPhoneticId;
        TextView rowPhonetic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowPhoneticId = itemView.findViewById(R.id.tvPhoneticId);
            rowPhonetic = itemView.findViewById(R.id.tvPhonetic);
        }
    }

    public RecyclerViewAdapterPhonetics(Context context, List<GetPhoneticsTableValues> phoneticsList, RecyclerView rvPhonetics){
        this.context = context;
        this.phoneticsList = phoneticsList;
        this.rvPhonetics = rvPhonetics;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterPhonetics.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_phonetic, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterPhonetics.ViewHolder viewHolder, int i) {
        GetPhoneticsTableValues getPhoneticTableValues = phoneticsList.get(i);

        //viewHolder.rowPhoneticId.setText("phonetic id: "+getPhoneticTableValues.getPhoneticId());
        viewHolder.rowPhonetic.setText(""+getPhoneticTableValues.getPhonetic());



        phoneticId = getPhoneticTableValues.getPhoneticId();


        databasePronsAdapter = new DatabasePronsAdapter(context, phoneticId, 0);
        pronsList = databasePronsAdapter.getProns();
        rvProns = viewHolder.itemView.findViewById(R.id.rvProns);
        rvProns.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvProns.setLayoutManager(layoutManager);
        recyclerViewAdapterProns = new RecyclerViewAdapterProns(context, pronsList, rvProns);
        rvProns.setAdapter(recyclerViewAdapterProns);


    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }

}
