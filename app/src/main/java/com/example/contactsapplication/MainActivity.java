package com.example.contactsapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapplication.Adapter.ContactsRecyclerViewAdapter;
import com.example.contactsapplication.Model.ContactsModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactsModel> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.contactsRecyclerView);
        setUpContactsRecyclerViewModels();
        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this, contacts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpContactsRecyclerViewModels(){
        String[] contactNames = getResources().getStringArray(R.array.contact_names);
        String[] phoneNumbers = getResources().getStringArray(R.array.phone_numbers);
        for (int i = 0; i< contactNames.length;i++){
            contacts.add(new ContactsModel(contactNames[i],phoneNumbers[i]));
        }
    }
}