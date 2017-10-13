package com.aaron.jcpennyprepassignment.view.MainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaron.jcpennyprepassignment.Events.MessageEvent;
import com.aaron.jcpennyprepassignment.R;
import com.aaron.jcpennyprepassignment.data.SqlLite.PersonSQLiteHelper;
import com.aaron.jcpennyprepassignment.data.WebData.GetRandomPeopleService;
import com.aaron.jcpennyprepassignment.model.Contact;
import com.aaron.jcpennyprepassignment.model.RandomPersonList;
import com.aaron.jcpennyprepassignment.model.Result;
import com.aaron.jcpennyprepassignment.view.ContactListActivity.ContactListActivity;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.aaron.jcpennyprepassignment.data.Constants.IntentConstants.CONTACT_ARRAY_LIST;

public class MainActivity extends AppCompatActivity {
    RandomPersonList randomPersonList;
    Contact currentNewContact;
    TextView tvFirstName;
    TextView tvLastName;
    TextView tvStreetLocation;
    TextView tvCityLocation;
    TextView tvStateLocation;
    TextView tvPostalCode;
    TextView tvEmail;
    TextView tvCellNumber;
    TextView tvLanNumber;
    ImageView imgContact;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        GetRandomPeopleService getRandomPeopleService = new GetRandomPeopleService();
        getRandomPeopleService.execute("Starting");
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void buttonClickHandler(View view) {
        switch(view.getId()){
            case R.id.btnViewAllLocContacts:
                Intent intent = new Intent(this, ContactListActivity.class);
                PersonSQLiteHelper personSQLiteHelper = new PersonSQLiteHelper(this);
                intent.putParcelableArrayListExtra(CONTACT_ARRAY_LIST,personSQLiteHelper.queryAllContactsReturned());
                startActivity(intent);
                break;
            case R.id.btnGenerateNewContact:
                GetRandomPeopleService getRandomPeopleService = new GetRandomPeopleService();
                getRandomPeopleService.execute("Starting");
                break;
            case R.id.btnAddContactToLocal:
                PersonSQLiteHelper personSQLiteHelper1 = new PersonSQLiteHelper(this);
                if(personSQLiteHelper1.insertNewContact(currentNewContact)){
                    Log.d("TAG", "buttonClickHandler: CONTACT INSERTED" );
                }
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        String recievedJson = event.getMessage();
        Gson gson = new Gson();
        randomPersonList = gson.fromJson(recievedJson, RandomPersonList.class);
        Result result = randomPersonList.getResults().get(0);
        Log.d("TAG", "onMessageEvent: " + randomPersonList.getResults().get(0).getName().getFirst());
        currentNewContact = new Contact(result);

        tvFirstName = (TextView)findViewById(R.id.tvFirstName);
        tvLastName = (TextView)findViewById(R.id.tvLastName);
        tvStreetLocation = (TextView)findViewById(R.id.tvStreetLocation);
        tvCityLocation = (TextView)findViewById(R.id.tvCityLocation);
        tvStateLocation = (TextView)findViewById(R.id.tvStateLocation);
        tvPostalCode = (TextView)findViewById(R.id.tvPostalCode);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvCellNumber = (TextView)findViewById(R.id.tvCellNumber);
        tvLanNumber= (TextView)findViewById(R.id.tvLanNumber);
        imgContact = (ImageView)findViewById(R.id.imgContact);

        tvFirstName.setText(currentNewContact.getFirstName());
        tvLastName.setText(currentNewContact.getLastName());
        tvStreetLocation.setText(currentNewContact.getStreetLocation());
        tvCityLocation.setText(currentNewContact.getCityLocation());
        tvStateLocation.setText(currentNewContact.getStateLocation());
        tvPostalCode.setText(currentNewContact.getPostalCode());
        tvEmail.setText(currentNewContact.geteMailAddress());
        tvCellNumber.setText(currentNewContact.getCellPhoneNumber());
        tvLanNumber.setText(currentNewContact.getLandPhoneNumber());
        Glide.with(this).load(currentNewContact.getImageLargeSizedLocation()).into(imgContact);


    };


}
