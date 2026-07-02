package com.example.simpledictionary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    public interface OnItemClickListener {
        void onClick(int position);
        void onLongClick(int position);
    }

    private ArrayList<Word> wordList;
    private OnItemClickListener listener;

    public WordAdapter(ArrayList<Word> wordList, OnItemClickListener listener) {
        this.wordList = wordList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word, parent, false);

        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        Word word = wordList.get(position);

        holder.wordText.setText(word.getWord());
        holder.meaningText.setText(word.getMeaning());

        // click = edit
        holder.itemView.setOnClickListener(v -> listener.onClick(position));

        // long click = delete
        holder.itemView.setOnLongClickListener(v -> {
            listener.onLongClick(position);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {

        TextView wordText;
        TextView meaningText;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            wordText = itemView.findViewById(R.id.textView_word);
            meaningText = itemView.findViewById(R.id.textView_meaning);
        }
    }
}