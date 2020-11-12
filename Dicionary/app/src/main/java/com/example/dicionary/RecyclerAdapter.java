package com.example.dicionary;

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
    private final LinkedList<String> listWord;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, LinkedList<String> listWord)
    {
        this.listWord = listWord;
        this.inflater = LayoutInflater.from(context);
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder
    {
        public final TextView word;
        final RecyclerAdapter ReAdapter;

        public RecyclerHolder(@NonNull View itemView, RecyclerAdapter reAdapter)
        {
            super(itemView);
            this.word = itemView.findViewById(R.id.word);
            ReAdapter = reAdapter;
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_word, parent, false);
        return new RecyclerHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position)
    {
        String currentItem = listWord.get(position);
        holder.word.setText(currentItem);
    }

    @Override
    public int getItemCount()
    {
        return listWord.size();
    }
}
