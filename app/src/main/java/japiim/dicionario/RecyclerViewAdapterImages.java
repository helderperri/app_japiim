
package japiim.dicionario;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import japiim.dicionario.GetImagesTableValues;
import japiim.dicionario.R;

public class RecyclerViewAdapterImages extends RecyclerView.Adapter<RecyclerViewAdapterImages.ViewHolder> {

    Context context;
    List<GetImagesTableValues> imagesList;
    RecyclerView rvImages;




    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowImageId;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //rowImageId = itemView.findViewById(R.id.tvImageId);
            rowImage = itemView.findViewById(R.id.ivImage);
        }
    }

    public RecyclerViewAdapterImages(Context context, List<GetImagesTableValues> imagesList, RecyclerView rvImages){
        this.context = context;
        this.imagesList = imagesList;
        this.rvImages = rvImages;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterImages.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item_image, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterImages.ViewHolder viewHolder, int i) {
        GetImagesTableValues getImagesTableValues = imagesList.get(i);
        String imageString = getImagesTableValues.getImage();
        String imageStringNoExtension = imageString.substring(0, imageString.lastIndexOf('.'));
        int image = context.getResources().getIdentifier(imageStringNoExtension, "drawable", context.getPackageName());
        viewHolder.rowImage.setImageResource(image);
        //viewHolder.rowImage.setImageResource(R.drawable.gta_20190702_gg_abanador);
        //viewHolder.rowImageId.setText("image id: "+getImagesTableValues.getImageId());
        //viewHolder.rowImageId.setText("image id: "+imageString);



    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

}
