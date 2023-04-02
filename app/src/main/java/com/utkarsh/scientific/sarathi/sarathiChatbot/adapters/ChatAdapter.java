package com.utkarsh.scientific.sarathi.sarathiChatbot.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;
import com.utkarsh.scientific.sarathi.sarathiChatbot.kanhaModal.Message;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private final List<Message> messageList;
    private final Activity activity;

    public ChatAdapter(List<Message> messageList, Activity activity) {
        this.messageList = messageList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.message, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String message = messageList.get(position).getMessage();
        boolean isReceived = messageList.get(position).getIsReceived();
        if (isReceived) {
            holder.krishna_iv.setVisibility(View.VISIBLE);
            holder.User_iv.setVisibility(View.GONE);

            holder.messageReceive.setVisibility(View.VISIBLE);
            holder.messageSend.setVisibility(View.GONE);
            holder.messageReceive.setText(message);
        } else {
            holder.krishna_iv.setVisibility(View.GONE);
            holder.User_iv.setVisibility(View.VISIBLE);

            holder.messageSend.setVisibility(View.VISIBLE);
            holder.messageReceive.setVisibility(View.GONE);
            holder.messageSend.setText(message);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView messageSend;
        TextView messageReceive;
        ImageView krishna_iv, User_iv;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageSend = itemView.findViewById(R.id.message_send);
            messageReceive = itemView.findViewById(R.id.message_receive);
            krishna_iv = itemView.findViewById(R.id.ivKrish);
            User_iv = itemView.findViewById(R.id.ivUser);
        }
    }

}
