package com.escaperadius.cursorlist;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chris on 6/6/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TabViewHolder> {

    private LayoutInflater inflater;
    List<WordDTO> data = Collections.emptyList();

    public ListAdapter(Context context, List<WordDTO> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_library, parent, false);
        TabViewHolder holder = new TabViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {
        WordDTO current = data.get(position);
        holder.row_word.setText(current.word);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TabViewHolder extends RecyclerView.ViewHolder {
        TextView row_word;
        public TabViewHolder(View itemView) {
            super(itemView);
            row_word = (TextView) itemView.findViewById(R.id.row_word);
        }
    }
}