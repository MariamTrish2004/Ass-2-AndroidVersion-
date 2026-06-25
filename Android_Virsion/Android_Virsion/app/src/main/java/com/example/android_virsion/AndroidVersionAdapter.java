package com.example.android_virsion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AndroidVersionAdapter extends RecyclerView.Adapter<AndroidVersionAdapter.ViewHolder> {

    private List<AndroidVersion> versionList;

    public AndroidVersionAdapter(List<AndroidVersion> versionList) {
        this.versionList = versionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_version, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AndroidVersion item = versionList.get(position);
        holder.ivLogo.setImageResource(item.getImageResId());
        holder.tvCodeName.setText(item.getCodeName());
        holder.tvVersion.setText(item.getVersion());

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(0xFFE3F2FD);
        } else {
            holder.itemView.setBackgroundColor(0xFFFFFFFF);
        }

        // معالجة النقر
        holder.itemView.setOnClickListener(v -> {
            String message = "You selected: " + item.getCodeName() + " (" + item.getVersion() + ")";
            Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLogo;
        TextView tvCodeName;
        TextView tvVersion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogo = itemView.findViewById(R.id.iv_logo);
            tvCodeName = itemView.findViewById(R.id.tv_code_name);
            tvVersion = itemView.findViewById(R.id.tv_version);
        }
    }
}