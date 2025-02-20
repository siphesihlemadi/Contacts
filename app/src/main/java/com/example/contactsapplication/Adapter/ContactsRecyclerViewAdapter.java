package com.example.contactsapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapplication.Model.ContactsModel;
import com.example.contactsapplication.R;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactsModel> contactsModels;
    public ContactsRecyclerViewAdapter(Context context, ArrayList<ContactsModel> contactsModels) {
        this.context = context;
        this.contactsModels = contactsModels;
    }

    @NonNull
    @Override
    public ContactsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_layout, parent, false);
        return new ContactsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.contactsTextView.setText(contactsModels.get(position).getContactName());
        holder.phoneNumberTextView.setText(contactsModels.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactsModels.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView contactsTextView;
        TextView phoneNumberTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contactsTextView = itemView.findViewById(R.id.contactNameTextView);
            phoneNumberTextView = itemView.findViewById(R.id.phoneNumberTextView);
        }
    }
}
