package japiim.dicionario.ui.alphabetic_source;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetSourceLettersTableValues;
import japiim.dicionario.R;

public class LettersSourceAdapter extends RecyclerView.Adapter<LettersSourceAdapter.ViewHolder> {

    //Initialize variable
    List<GetSourceLettersTableValues> sourceLettersList;

    //Create constructor

    public LettersSourceAdapter(List<GetSourceLettersTableValues> sourceLettersList){
        this.sourceLettersList = sourceLettersList;
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
        GetSourceLettersTableValues getSourceLettersTableValues = sourceLettersList.get(position);
        holder.btnLetter.setText(""+getSourceLettersTableValues.getGlyph());
    }

    @Override
    public int getItemCount() {
        return sourceLettersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button btnLetter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            btnLetter = itemView.findViewById(R.id.btnLetter);        }
    }
}
