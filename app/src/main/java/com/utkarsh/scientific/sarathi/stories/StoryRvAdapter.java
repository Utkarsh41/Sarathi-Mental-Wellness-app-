package com.utkarsh.scientific.sarathi.stories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.utkarsh.scientific.sarathi.R;

import java.util.List;


public class StoryRvAdapter extends RecyclerView.Adapter<StoryRvAdapter.StoryViewHolder> {

    Context context;
    List<StoryModal> storyModalList;

    public StoryRvAdapter(Context context, List<StoryModal> storyModalList) {
        this.context = context;
        this.storyModalList = storyModalList;
    }

    @NonNull
    @Override
    public StoryRvAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.storyrv_item, parent, false);
        return new StoryRvAdapter.StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryRvAdapter.StoryViewHolder holder, int position) {
        StoryModal storyModal = storyModalList.get(position);
        holder.storyTitile_tv.setText(storyModal.getStoryTitle());
        holder.storyDes_tv.setText(storyModal.getStoryDesc());
        String strImgUrl = storyModal.getImgUrl();
        Glide.with(context)
                .load(strImgUrl)
                .placeholder(R.drawable.krishna)
                .into(holder.themeIv);
    }

    @Override
    public int getItemCount() {
        return storyModalList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {

        TextView storyTitile_tv, storyDes_tv;
        ImageView themeIv;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyTitile_tv = itemView.findViewById(R.id.storyTitle_TV);
            storyDes_tv = itemView.findViewById(R.id.storyDescTv);
            themeIv = itemView.findViewById(R.id.StoryIv);
        }
    }
}
