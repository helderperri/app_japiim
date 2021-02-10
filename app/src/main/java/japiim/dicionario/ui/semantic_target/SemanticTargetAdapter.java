package japiim.dicionario.ui.semantic_target;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetEntriesSdsTableValues;
import japiim.dicionario.R;

public class SemanticTargetAdapter extends RecyclerView.Adapter<SemanticTargetAdapter.ViewHolder> {

    //Initialize variable
    List<GetEntriesSdsTableValues> semanticDomainsList;

    //Create constructor

    public SemanticTargetAdapter(List<GetEntriesSdsTableValues> semanticDomainsList){
        this.semanticDomainsList = semanticDomainsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_letter_button, parent, false);

        //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetEntriesSdsTableValues getEntriesSdsTableValues = semanticDomainsList.get(position);
        holder.btnLetter.setText(""+getEntriesSdsTableValues.getSdName());
    }

    @Override
    public int getItemCount() {
        return semanticDomainsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button btnLetter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            btnLetter = itemView.findViewById(R.id.btnLetter);        }
    }
}
