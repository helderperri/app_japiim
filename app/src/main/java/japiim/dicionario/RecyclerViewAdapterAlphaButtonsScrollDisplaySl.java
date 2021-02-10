
package japiim.dicionario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterAlphaButtonsScrollDisplaySl extends RecyclerView.Adapter<RecyclerViewAdapterAlphaButtonsScrollDisplaySl.ViewHolder> {

    Context context;
    List<GetSourceLettersTableValues> sourceLettersList;
    RecyclerView rvAlphaButtonsScrollDisplaySl;
    RecyclerViewAdapterEntriesScrollDisplaySl recyclerViewAdapterEntriesScrollDisplaySl;
      long glyphId;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView rvEntriesDisplaySl;


    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    List<GetEntriesVernacularTableValues> entriesVernacularList = new ArrayList<>();




    public static class ViewHolder extends RecyclerView.ViewHolder{

        Button rowBtnGlyph;
        RecyclerView rvEntriesDisplaySl;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowPhoneticId = itemView.findViewById(R.id.tvPhoneticId);
            rowBtnGlyph = itemView.findViewById(R.id.btnGlyph);
            rvEntriesDisplaySl = itemView.findViewById(R.id.rvEntriesScrollDisplaySl);


        }
    }

    public RecyclerViewAdapterAlphaButtonsScrollDisplaySl(Context context, List<GetSourceLettersTableValues> sourceLettersList, RecyclerView rvAlphaButtonsScrollDisplaySl, RecyclerView rvEntriesDisplaySl){
        this.context = context;
        this.sourceLettersList = sourceLettersList;
        this.rvAlphaButtonsScrollDisplaySl = rvAlphaButtonsScrollDisplaySl;
         }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.single_item_btn_alpha, viewGroup, false);
         final ViewHolder viewHolder = new ViewHolder(view);



        viewHolder.rowBtnGlyph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int itemPosition = rvAlphaButtonsScrollDisplaySl.getChildLayoutPosition(v);
                //long itemPositionVernacular = sourceLettersList.get(itemPosition).getPositionBtn();
                long getTag = (long) viewHolder.rowBtnGlyph.getTag();

                //recyclerViewAdapterEntriesScrollDisplaySl.scrollFromBtn(getTag);


                Toast.makeText(context, getTag+"", Toast.LENGTH_SHORT).show();


               /*   databaseEntriesVernacularAdapter = new DatabaseEntriesVernacularAdapter(context, 0, 0, 0);
                entriesVernacularList = databaseEntriesVernacularAdapter.getVernacularsToSearchDisplay();



                rvEntriesDisplaySl.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(context);
                rvEntriesDisplaySl.setLayoutManager(layoutManager);
                recyclerViewAdapterEntriesScrollDisplaySl = new RecyclerViewAdapterEntriesScrollDisplaySl(context, entriesVernacularList, rvEntriesDisplaySl);
                rvEntriesDisplaySl.setAdapter(recyclerViewAdapterEntriesScrollDisplaySl);

                rvEntriesDisplaySl.scrollToPosition(88);

                rvEntriesDisplaySl = viewHolder2.itemView.findViewById(R.id.rvEntriesScrollDisplaySl);

                rvEntriesDisplaySl.setLayoutManager(layoutManager);
                layoutManager.scrollToPosition((int) getTag);

                rvEntriesDisplaySl = viewHolder2.itemView.findViewById(R.id.rvEntriesScrollDisplaySl);
                //Log.d(TAG, "sdsdsdfdfgg");


                //rvEntriesDisplaySl = viewHolder.itemView.findViewById(R.id.rvEntriesScrollDisplaySl);
                //rvEntriesDisplaySl = v.findViewById(R.id.rvEntriesScrollDisplaySl);


                rvEntriesDisplaySl.setLayoutManager(layoutManager);
                recyclerViewAdapterEntriesScrollDisplaySl = new RecyclerViewAdapterEntriesScrollDisplaySl(context, entriesVernacularList, rvEntriesDisplaySl);
                rvEntriesDisplaySl.setAdapter(recyclerViewAdapterEntriesScrollDisplaySl);
                rvEntriesDisplaySl.scrollToPosition(88);
                //rvEntriesDisplaySl.scrollToPosition(75);


*/

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        GetSourceLettersTableValues getSourceLettersTableValues = sourceLettersList.get(i);

        //viewHolder.rowPhoneticId.setText("phonetic id: "+getPhoneticTableValues.getPhoneticId());
        viewHolder.rowBtnGlyph.setText(""+getSourceLettersTableValues.getGlyph());

        //final long btnId = getSourceLettersTableValues.getGlyphId();
        final long positionBtn = getSourceLettersTableValues.getPositionBtn();
        viewHolder.rowBtnGlyph.setTag(positionBtn);

    }

    @Override
    public int getItemCount() {
        return sourceLettersList.size();
    }



}
