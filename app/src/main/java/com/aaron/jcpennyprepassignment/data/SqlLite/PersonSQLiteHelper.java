package com.aaron.jcpennyprepassignment.data.SqlLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aaron.jcpennyprepassignment.model.Contact;

import java.util.ArrayList;

import static com.aaron.jcpennyprepassignment.data.Constants.SqlDBConstants.*;

/**
 * Created by aaron on 10/10/17.
 */

public class PersonSQLiteHelper extends SQLiteOpenHelper {
    public PersonSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create TABLE " + RANDOM_CONTACTS_TABLE + "("
                + RANDOM_CONTACT_NAME_FIRST + " TEXT, "
                + RANDOM_CONTACT_NAME_MID +  " TEXT, "
                + RANDOM_CONTACTS_NAME_LAST +  " TEXT, "
                + RANDOM_CONTACTS_LOC_STREET +  " TEXT, "
                + RANDOM_CONTACTS_LOC_CITY  +  " TEXT, "
                + RANDOM_CONTACTS_LOC_STATE +  " TEXT, "
                + RANDOM_CONTACTS_LOC_POSTAL +  " TEXT, "
                + RANDOM_CONTACTS_EMAIL +  " TEXT, "
                + RANDOM_CONTACTS_DOB +  " TEXT, "
                + RANDOM_CONTACT_LAN +  " TEXT, "
                + RANDOM_CONTACT_CELL +  " TEXT, "
                + RANDOM_CONTACT_IMG_LG +  " TEXT, "
                + RANDOM_CONTACT_IMG_MD  +  " TEXT, "
                + RANDOM_CONTACT_IMG_THUMB +  " TEXT );" ;
        sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            onCreate(sqLiteDatabase);
    }

    public boolean insertNewContact(Contact passedContact){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RANDOM_CONTACT_NAME_FIRST, passedContact.getFirstName());
        contentValues.put(RANDOM_CONTACT_NAME_MID, passedContact.getMiddleName());
        contentValues.put(RANDOM_CONTACTS_NAME_LAST, passedContact.getLastName());
        contentValues.put(RANDOM_CONTACTS_LOC_STREET, passedContact.getStreetLocation());
        contentValues.put(RANDOM_CONTACTS_LOC_CITY, passedContact.getCityLocation());
        contentValues.put(RANDOM_CONTACTS_LOC_STATE, passedContact.getStateLocation());
        contentValues.put(RANDOM_CONTACTS_LOC_POSTAL, passedContact.getPostalCode());
        contentValues.put(RANDOM_CONTACTS_EMAIL, passedContact.geteMailAddress());
        contentValues.put(RANDOM_CONTACTS_DOB, passedContact.getDateOfBirth());
        contentValues.put(RANDOM_CONTACT_LAN, passedContact.getLandPhoneNumber());
        contentValues.put(RANDOM_CONTACT_CELL, passedContact.getCellPhoneNumber());
        contentValues.put(RANDOM_CONTACT_IMG_LG, passedContact.getImageLargeSizedLocation());
        contentValues.put(RANDOM_CONTACT_IMG_MD, passedContact.getImageMidSizedLocation());
        contentValues.put(RANDOM_CONTACT_IMG_THUMB, passedContact.getImageThumbnailLocation());

        return sqLiteDatabase.insert(RANDOM_CONTACTS_TABLE, null, contentValues) > 0;
    }

    public ArrayList<Contact> queryAllContactsReturned(){
        String query = "SELECT * FROM " + RANDOM_CONTACTS_TABLE;
        ArrayList<Contact> returnContactList = null;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor;

        cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            returnContactList = new ArrayList<>();
            do{
                Contact currentContact = new Contact();
                currentContact.setFirstName(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_NAME_FIRST)));
                currentContact.setLastName(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_NAME_LAST)));
                currentContact.setMiddleName(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_NAME_MID)));
                currentContact.setStreetLocation(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_LOC_STREET)));
                currentContact.setCityLocation(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_LOC_CITY)));
                currentContact.setStateLocation(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_LOC_STATE)));
                currentContact.setPostalCode(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_LOC_POSTAL)));
                currentContact.seteMailAddress(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_EMAIL)));
                currentContact.setDateOfBirth(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACTS_DOB)));
                currentContact.setLandPhoneNumber(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_LAN)));
                currentContact.setCellPhoneNumber(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_CELL)));
                currentContact.setImageLargeSizedLocation(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_IMG_LG)));
                currentContact.setImageMidSizedLocation(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_IMG_MD)));
                currentContact.setImageThumbnailLocation(cursor.getString(cursor.getColumnIndex(RANDOM_CONTACT_IMG_THUMB)));
                returnContactList.add(currentContact);
            }while (cursor.moveToNext());
        }
        return returnContactList;
    }
}
