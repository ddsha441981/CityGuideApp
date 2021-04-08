package com.example.cityguideapp.HelperClasses.HomeAdpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    //variable
    ArrayList<FeaturedHelperClass> featuredLocations;

    //constructor
    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    //Inner class
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        //Constructor of inner class
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }

    //hold view(Like LinearLayout, CardView,RelativeLayout,RecyclerView)
    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);

        return featuredViewHolder;
    }

    //data binding with that method
    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());

    }

    //how much slide we will use in recyclerView
    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }


}
