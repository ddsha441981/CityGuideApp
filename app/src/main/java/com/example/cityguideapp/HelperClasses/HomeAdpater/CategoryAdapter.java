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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    //variable
    ArrayList<CategoryHelperCalss> categoryLocations;

    //Constructor
    public CategoryAdapter(ArrayList<CategoryHelperCalss> categoryLocations) {
        this.categoryLocations = categoryLocations;
    }

    //Inner class
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView categoryTitle;

        //Constructor of inner class
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryTitle = itemView.findViewById(R.id.category_title);
        }
    }

    //hold view(Like LinearLayout, CardView,RelativeLayout,RecyclerView)
    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoryAdapter.CategoryViewHolder categoryViewHolder = new CategoryAdapter.CategoryViewHolder(view);

        return categoryViewHolder;
    }

    //data binding with that method
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {

        CategoryHelperCalss categoryHelperCalss = categoryLocations.get(position);
        holder.categoryImage.setImageResource(categoryHelperCalss.getImageCategory());
        holder.categoryTitle.setText(categoryHelperCalss.getTitleCategory());

    }

    //how much slide we will use in recyclerView
    @Override
    public int getItemCount() {
        return categoryLocations.size();
    }


}
