package com.example.mycontacts;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // declare Intent
    Intent intent;

    // declare a DBHandler
    DBHandler dbHandler;

    // declare shoppinglist cursoradapter
    CursorAdapter myContactsCursorAdapter;

    // decare a listview
    ListView contactsListView;

    /**
     *This method initializes the Action Bar and View of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initialize the View and Action Bar of the main activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // initializes dbhandler
        dbHandler = new DBHandler(this, null);

        // initializes listview
        contactsListView = (ListView) findViewById(R.id.contactsListView);

        // initialize shoppinglsts cursoradapter
        myContactsCursorAdapter = new MyContacts(this,
                dbHandler.getMyContacts(), 0);

        // set shopping lists cursoradapater on the listview
        contactsListView.setAdapter(myContactsCursorAdapter);
    }

    /**
     * This method further initializes the Action Bar of the activity
     * It gets the code (XML) in the menu resource file and incorporates it into the Action Bar
     * @param menu menu resource file for the activity
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * this method gets called when a menu item in the overflow menu is selected and it
     * controls what happens when the menu item is selected.
     * @param item selected menu item in the overflow menu
     * @return true if menu is selected, else false
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // get the id of menu item selected
        switch (item.getItemId()){
            case R.id.action_home :
                // initialize and Intent for the MainActivity and start it
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_add_contact :
                // initialize and Intent for the MainActivity and start it
                intent = new Intent(this, AddContact.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This method gets called when the add Floating Action Button is clicked.
     * It starts the CreateList Activity
     * @param view MainActivity view
     */
    public void openAddContact(View view){
        // initialize and Intent for the MainActivity and start it
        intent = new Intent(this, AddContact.class);
        startActivity(intent);
    }
}