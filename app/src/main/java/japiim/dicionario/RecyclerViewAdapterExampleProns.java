
package japiim.dicionario;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterExampleProns extends RecyclerView.Adapter<RecyclerViewAdapterExampleProns.ViewHolder> {

    Context context;
    List<GetExamplePronsTableValues> examplePronsList;
    RecyclerView rvExampleProns;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowExamplePronId;
        TextView rowExamplePron;
        ImageButton rowExamplePronBtn;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowExamplePronId = itemView.findViewById(R.id.tvExamplePronId);
            //rowExamplePron = itemView.findViewById(R.id.tvExamplePron);
            rowExamplePronBtn = itemView.findViewById(R.id.btnExamplePron);
        }
    }

    public RecyclerViewAdapterExampleProns(Context context, List<GetExamplePronsTableValues> examplePronsList, RecyclerView rvExampleProns){
        this.context = context;
        this.examplePronsList = examplePronsList;
        this.rvExampleProns = rvExampleProns;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterExampleProns.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_example_pron, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterExampleProns.ViewHolder viewHolder, int i) {
        GetExamplePronsTableValues getExamplePronTableValues = examplePronsList.get(i);
        String examplePronString = getExamplePronTableValues.getExamplePron();

        String examplePronStringNoExtension = examplePronString.substring(0, examplePronString.lastIndexOf('.'));
        int examplePron = context.getResources().getIdentifier(examplePronStringNoExtension, "raw", context.getPackageName());

        final MediaPlayer mp = MediaPlayer.create(context, examplePron);
        //final MediaPlayer mp = MediaPlayer.create(context, R.raw.gta_20200314_kb_gg_vs_mulher_faz_esteira_de_acuri);

        viewHolder.rowExamplePronBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();

            }
        });

        //viewHolder.rowExamplePronId.setText("examplePron id: "+examplePronStringNoExtension);

        //viewHolder.rowExamplePronId.setText("examplePron id: "+getExamplePronTableValues.getExamplePronId());
        //viewHolder.rowExamplePron.setText(""+getExamplePronTableValues.getExamplePron());




    }

    @Override
    public int getItemCount() {
        return examplePronsList.size();
    }

}
