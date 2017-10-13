package com.aaron.jcpennyprepassignment.view.ContactListActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aaron.jcpennyprepassignment.R;
import com.aaron.jcpennyprepassignment.model.Contact;

import java.util.ArrayList;

import static com.aaron.jcpennyprepassignment.data.Constants.IntentConstants.CONTACT_ARRAY_LIST;

public class ContactListActivity extends AppCompatActivity {
    ArrayList<Contact> contactList;
    RecyclerView rvConactsList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    ContactListAdaptor contactListAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        Intent intent = getIntent();
        contactList = intent.getParcelableArrayListExtra(CONTACT_ARRAY_LIST);
        rvConactsList = (RecyclerView)findViewById(R.id.rvContactsList);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        rvConactsList.setLayoutManager(layoutManager);
        rvConactsList.setItemAnimator(itemAnimator);
        contactListAdaptor = new ContactListAdaptor(contactList);
        rvConactsList.setAdapter(contactListAdaptor);

    }
}
