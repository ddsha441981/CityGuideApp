package com.example.cityguideapp.HelperClasses.HomeAdpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewHolder> {

    //variable
    ArrayList<MostViewedHelperClass> mostViewLocations;

    //constructor
    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewLocations) {
        this.mostViewLocations = mostViewLocations;
    }



    //Inner class
    public static class MostViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;

        //Constructor of inner class
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.ms_image);
            title = itemView.findViewById(R.id.ms_title);
            desc = itemView.findViewById(R.id.mv_desc);
        }
    }

    //hold view(Like LinearLayout, CardView,RelativeLayout,RecyclerView)
    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    //data binding with that method
    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {

        MostViewedHelperClass mostViewedHelperClass = mostViewLocations.get(position);
        holder.image.setImageResource(mostViewedHelperClass.getMsImage());
        holder.title.setText(mostViewedHelperClass.getMsTitle());
        holder.desc.setText(mostViewedHelperClass.getMsDesc());
    }

    //how much slide we will use in recyclerView
    @Override
    public int getItemCount() {
        return mostViewLocations.size();
    }




}
