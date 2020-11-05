package com.example.chegg.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chegg.R;
import com.example.chegg.modelactivity.ChapterModel;
import com.example.chegg.modelactivity.ChapterSubModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Context mContext;
    ArrayList<ChapterModel> list_p;
    ArrayList<ChapterSubModel> list_c;
    int pos = -1;
    ChildAdapter childAdapter;
    public OnClickItem onClickItem;
    boolean enable = true;

    public MainAdapter(Context mContext, ArrayList<ChapterModel> list_p, OnClickItem onClickItem) {
        this.mContext = mContext;
        this.list_p = list_p;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ChapterModel model = list_p.get(position);
        Log.d("model__txt", model.getChapter());
        holder.item_name.setText(model.getChapter());

        list_c = model.getChildList();
        holder.item_LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pos = position;
                onClickItem.onClickItem(model);
                notifyDataSetChanged();

            }
        });

        if (pos == position) {
            if (enable == true) {
                childAdapter = new ChildAdapter(mContext, list_c);
                holder.child_rv.setAdapter(childAdapter);
                holder.child_rv.setVisibility(View.VISIBLE);
                enable = false;
            } else {
                enable = true;
                holder.child_rv.setVisibility(View.GONE);

            }
        } else {
            holder.child_rv.setVisibility(View.GONE);

        }

        // Toast.makeText(mContext, ""+enable, Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return list_p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item_name;
        public LinearLayout item_LL;
        public RecyclerView child_rv;
        private ImageView icon__;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            child_rv = itemView.findViewById(R.id.child_rv);
            item_LL = itemView.findViewById(R.id.item_LL);
            icon__ = itemView.findViewById(R.id.icon__);
        }
    }

    public interface OnClickItem {
        public void onClickItem(ChapterModel model);
    }

}
