
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

public class RecyclerViewAdapterProns extends RecyclerView.Adapter<RecyclerViewAdapterProns.ViewHolder> {

    Context context;
    List<GetPronsTableValues> pronsList;
    RecyclerView rvProns;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowPronId;
        TextView rowPron;
        ImageButton rowPronBtn;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowPronId = itemView.findViewById(R.id.tvPronId);
            //rowPron = itemView.findViewById(R.id.tvPron);
            rowPronBtn = itemView.findViewById(R.id.pronBtn);
        }
    }

    public RecyclerViewAdapterProns(Context context, List<GetPronsTableValues> pronsList, RecyclerView rvProns){
        this.context = context;
        this.pronsList = pronsList;
        this.rvProns = rvProns;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterProns.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_pron, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterProns.ViewHolder viewHolder, int i) {
        GetPronsTableValues getPronTableValues = pronsList.get(i);
        String pronString = getPronTableValues.getPron();

        String pronStringNoExtension = pronString.substring(0, pronString.lastIndexOf('.'));
        int pron = context.getResources().getIdentifier(pronStringNoExtension, "raw", context.getPackageName());

        final MediaPlayer mp = MediaPlayer.create(context, pron);
        //final MediaPlayer mp = MediaPlayer.create(context, R.raw.gta_20200314_kb_gg_vs_mulher_faz_esteira_de_acuri);

        viewHolder.rowPronBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();

            }
        });

        //viewHolder.rowPronId.setText("pron id: "+pronStringNoExtension);

        //viewHolder.rowPronId.setText("pron id: "+getPronTableValues.getPronId());
        //viewHolder.rowPron.setText(""+getPronTableValues.getPron());




    }

    @Override
    public int getItemCount() {
        return pronsList.size();
    }

}
