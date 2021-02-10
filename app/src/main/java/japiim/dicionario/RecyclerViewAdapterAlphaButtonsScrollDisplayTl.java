
package japiim.dicionario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterAlphaButtonsScrollDisplayTl extends RecyclerView.Adapter<RecyclerViewAdapterAlphaButtonsScrollDisplayTl.ViewHolder> {

    Context context;
    List<GetTargetLettersTableValues> targetLettersList;
    RecyclerView rvAlphaButtonsScrollDisplayTl;
    RecyclerViewAdapterEntriesScrollDisplayTl recyclerViewAdapterEntriesScrollDisplayTl;
      long glyphId;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView rvEntriesDisplayTl;


    DatabaseEntriesVernacularAdapter databaseEntriesVernacularAdapter;
    List<GetEntriesVernacularTableValues> entriesVernacularList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{

        Button rowBtnGlyph;
        //RecyclerView rvEntriesDisplayTl;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowPhoneticId = itemView.findViewById(R.id.tvPhoneticId);
            rowBtnGlyph = itemView.findViewById(R.id.btnGlyph);
          //  rvEntriesDisplayTl = itemView.findViewById(R.id.rvEntriesScrollDisplayTl);


        }
    }

    public RecyclerViewAdapterAlphaButtonsScrollDisplayTl(Context context, List<GetTargetLettersTableValues> targetLettersList, RecyclerView rvAlphaButtonsScrollDisplayTl, RecyclerView rvEntriesDisplayTl){
        this.context = context;
        this.targetLettersList = targetLettersList;
        this.rvAlphaButtonsScrollDisplayTl = rvAlphaButtonsScrollDisplayTl;
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
                //int itemPosition = rvAlphaButtonsScrollDisplayTl.getChildLayoutPosition(v);
                //long itemPositionVernacular = targetLettersList.get(itemPosition).getPositionBtn();
                long getTag = (long) viewHolder.rowBtnGlyph.getTag();

                //recyclerViewAdapterEntriesScrollDisplayTl.scrollFromBtn(getTag);




                Toast.makeText(context, getTag+"", Toast.LENGTH_SHORT).show();

                /*
                rvEntriesDisplayTl = viewHolder2.itemView.findViewById(R.id.rvEntriesScrollDisplayTl);
                rvEntriesDisplayTl.setLayoutManager(layoutManager);
                layoutManager.scrollToPosition((int) getTag);

                rvEntriesDisplayTl = viewHolder2.itemView.findViewById(R.id.rvEntriesScrollDisplayTl);
                //Log.d(TAG, "sdsdsdfdfgg");


                databaseEntriesVernacularAdapter = new DatabaseEntriesVernacularAdapter(context, 0, 0, 0);
                entriesVernacularList = databaseEntriesVernacularAdapter.getVernacularsToSearchDisplay();
                //rvEntriesDisplayTl = viewHolder.itemView.findViewById(R.id.rvEntriesScrollDisplayTl);
                //rvEntriesDisplayTl = v.findViewById(R.id.rvEntriesScrollDisplayTl);


                rvEntriesDisplayTl.setLayoutManager(layoutManager);
                recyclerViewAdapterEntriesScrollDisplayTl = new RecyclerViewAdapterEntriesScrollDisplayTl(context, entriesVernacularList, rvEntriesDisplayTl);
                rvEntriesDisplayTl.setAdapter(recyclerViewAdapterEntriesScrollDisplayTl);
                rvEntriesDisplayTl.scrollToPosition(88);
                //rvEntriesDisplayTl.scrollToPosition(75);


*/

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        GetTargetLettersTableValues getTargetLettersTableValues = targetLettersList.get(i);

        //viewHolder.rowPhoneticId.setText("phonetic id: "+getPhoneticTableValues.getPhoneticId());
        viewHolder.rowBtnGlyph.setText(""+getTargetLettersTableValues.getGlyph());

        //final long btnId = getTargetLettersTableValues.getGlyphId();
        final long positionBtn = getTargetLettersTableValues.getPositionBtn();
        viewHolder.rowBtnGlyph.setTag(positionBtn);

    }

    @Override
    public int getItemCount() {
        return targetLettersList.size();
    }



}
