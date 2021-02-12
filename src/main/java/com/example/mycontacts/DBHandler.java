package com.example.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // initialize constants for the DB name and version
    public static final String DATABASE_NAME = "contacts.db";
    public static final int DATABASE_VERSION = 1;

    // initialize constants for the shoppingList table
    public static final String TABLE_MY_CONTACTS = "myContacts";
    public static final String COLUMN_LIST_ID = "_id";
    public static final String COLUMN_LIST_NAME = "name";
    public static final String COLUMN_LIST_EMAIL = "email";
    public static final String COLUMN_LIST_PHONE = "phone";


    /**
     * Create a version of the myContacts database
     * @param context reference to the activity that initializes a DBHandler
     * @param factory null
     */
    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /**
     * Creates shopper database tables
     * @param sqLiteDatabase reference to shopper database
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // define create statement for shoppingLList table and store it in a String
        String query = "CREATE TABLE " + TABLE_MY_CONTACTS + "(" + COLUMN_LIST_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_LIST_NAME + " TEXT, " +
                COLUMN_LIST_EMAIL + " TEXT, " + COLUMN_LIST_PHONE + " TEXT);";

        // execute the statement
        sqLiteDatabase.execSQL(query);
    }

    /**
     * Create a new version of the myContacts database
     * @param sqLiteDatabase reference to myContacts database
     * @param oldVersion old version of the myContacts database
     * @param newVersion new version of the myContacts database
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // define drop statement and store it in a String
        String query = "DROP TABLE IF EXISTS " + TABLE_MY_CONTACTS;

        // execute the drop statement
        sqLiteDatabase.execSQL(query);

        // call method that creates the tables
        onCreate(sqLiteDatabase);
    }

    /**
     * This method gets called when the add button in the Action Bar of the
     * AddContact activity gets clicked. It inserts a new row into the contact table
     * @param name  myContacts name
     * @param email myContacts store
     * @param phone myContacts date
     */
    public void addContact(String name, String email, String phone){
        // get reference to the shopper database
        SQLiteDatabase db = getWritableDatabase();

        // initialize a content values object
        ContentValues values = new ContentValues();

        // put data into ContentValues object
        values.put(COLUMN_LIST_NAME, name);
        values.put(COLUMN_LIST_EMAIL, email);
        values.put(COLUMN_LIST_PHONE, phone);

        // insert data in ContentVales object into shoppinglist table
        db.insert(TABLE_MY_CONTACTS, null, values);

        //close database reference
        db.close();
    }

    /**
     * This method gets called when the MainActivity is created. It will select
     * and return all of the data in the myContacts table
     * @return Cursor that contains all data in the myContacts table
     */
    public Cursor getMyContacts(){

        // get reference to the shopper database
        SQLiteDatabase db = getWritableDatabase();

        // define select statement and store it in a string
        String query = "SELECT * FROM " + TABLE_MY_CONTACTS;

        // execute select statement and return it as a Cursor
        return db.rawQuery(query, null);
    }
}
