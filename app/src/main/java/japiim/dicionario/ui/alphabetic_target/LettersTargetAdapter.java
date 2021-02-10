package japiim.dicionario.ui.alphabetic_target;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetTargetLettersTableValues;
import japiim.dicionario.R;

public class LettersTargetAdapter extends RecyclerView.Adapter<LettersTargetAdapter.ViewHolder> {

    //Initialize variable
    List<GetTargetLettersTableValues> targetLettersList;

    //Create constructor

    public LettersTargetAdapter(List<GetTargetLettersTableValues> targetLettersList){
        this.targetLettersList = targetLettersList;
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
        GetTargetLettersTableValues getTargetLettersTableValues = targetLettersList.get(position);
        holder.btnLetter.setText(""+getTargetLettersTableValues.getGlyph());
    }

    @Override
    public int getItemCount() {
        return targetLettersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button btnLetter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            btnLetter = itemView.findViewById(R.id.btnLetter);
        }
    }
}
