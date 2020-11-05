package com.example.chegg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chegg.R;
import com.example.chegg.modelactivity.ChapterSubModel;

import java.util.ArrayList;

public class childAdapter extends RecyclerView.Adapter<childAdapter.ViewHolder> {
    Context mContext;
    ArrayList<ChapterSubModel> chilsList;

    public childAdapter(Context mContext, ArrayList<ChapterSubModel> chilsList) {
        this.mContext = mContext;
        this.chilsList = chilsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChapterSubModel model = chilsList.get(position);
        holder.tv_1.setText(model.getSub_chapter());

    }

    @Override
    public int getItemCount() {
        return chilsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_1 = itemView.findViewById(R.id.item_name_child);
        }
    }


}
