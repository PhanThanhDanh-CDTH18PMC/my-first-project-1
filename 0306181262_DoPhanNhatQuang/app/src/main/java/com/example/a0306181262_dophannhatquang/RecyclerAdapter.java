package com.example.a0306181262_dophannhatquang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>
{
    private final LinkedList<WordDict> listWord;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, LinkedList<WordDict> listWord)
    {
        this.listWord = listWord;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position)
    {
        WordDict currentItem = listWord.get(position);
        holder.word.setText(currentItem.getWord().toString());
        holder.def.setText(currentItem.getDef().toString());
    }

    @Override
    public int getItemCount()
    {
        return listWord.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder
    {
        public final TextView word;
        public final TextView def;
        final RecyclerAdapter ReAdapter;

        public RecyclerHolder(@NonNull View itemView, RecyclerAdapter reAdapter)
        {
            super(itemView);
            this.word = itemView.findViewById(R.id.word);
            this.def = itemView.findViewById(R.id.def);
            ReAdapter = reAdapter;
        }
    }
}
