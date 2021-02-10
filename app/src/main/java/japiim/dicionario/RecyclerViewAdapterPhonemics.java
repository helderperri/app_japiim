
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

public class RecyclerViewAdapterPhonemics extends RecyclerView.Adapter<RecyclerViewAdapterPhonemics.ViewHolder> {

    Context context;
    List<GetPhonemicsTableValues> phonemicsList;
    RecyclerView rvPhonemics;


    RecyclerView.LayoutManager layoutManager;

    DatabasePhoneticsAdapter databasePhoneticsAdapter;
    RecyclerView rvPhonetics;
    RecyclerViewAdapterPhonetics recyclerViewAdapterPhonetics;
    List<GetPhoneticsTableValues> phoneticsList = new ArrayList<>();
    long phonemicId;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowPhonemicId;
        TextView rowPhonemic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowPhonemicId = itemView.findViewById(R.id.tvPhonemicId);
            rowPhonemic = itemView.findViewById(R.id.tvPhonemic);
        }
    }

    public RecyclerViewAdapterPhonemics(Context context, List<GetPhonemicsTableValues> phonemicsList, RecyclerView rvPhonemics){
        this.context = context;
        this.phonemicsList = phonemicsList;
        this.rvPhonemics = rvPhonemics;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterPhonemics.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_phonemic, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterPhonemics.ViewHolder viewHolder, int i) {
        GetPhonemicsTableValues getPhonemicTableValues = phonemicsList.get(i);

        //viewHolder.rowPhonemicId.setText("phonemic id: "+getPhonemicTableValues.getPhonemicId());
        viewHolder.rowPhonemic.setText(""+getPhonemicTableValues.getPhonemic());


        phonemicId = getPhonemicTableValues.getPhonemicId();


        databasePhoneticsAdapter = new DatabasePhoneticsAdapter(context, phonemicId, 0);
        phoneticsList = databasePhoneticsAdapter.getPhonetics();
        rvPhonetics = viewHolder.itemView.findViewById(R.id.rvPhonetics);
        rvPhonetics.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvPhonetics.setLayoutManager(layoutManager);
        recyclerViewAdapterPhonetics = new RecyclerViewAdapterPhonetics(context, phoneticsList, rvPhonetics);
        rvPhonetics.setAdapter(recyclerViewAdapterPhonetics);



    }

    @Override
    public int getItemCount() {
        return phonemicsList.size();
    }

}
