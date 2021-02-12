package com.example.mycontacts;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * The MyContacts class will map the data selected from the myContacts
 * table, in the cursor, to the li_contacts layout resource
 */
public class MyContacts extends CursorAdapter{


        /**
         * Initialize a myContacts cursoradapter
         * @param context reference to the activity that initializes the myContacts cursoradapter
         * @param c reference to the cursor that contains the selected data from the myContacts table
         * @param flags determines special behavior of the cursor adapter. we dont want any special
         *              behavior so we will always pass 0.
         */
        public MyContacts(Context context, Cursor c, int flags) {
            super(context, c, flags);
        }

        /**
         * Makes a new view to hold the data in the cursor
         * @param context reference to the activity that initializes the myContacts cursoradapter
         * @param cursor reference to the cursor that contains the selected data from the myContacts table
         * @param parent reference to the myContacts view that will contain the new view
         *               created by this method
         * @return reference to the new view
         */
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.li_contacts, parent, false);
        }

        /**
         * Binds new view to data in cursor
         * @param view reference to new view
         * @param context reference to the activity that initializes the myContacts curdoradapter
         * @param cursor reference to the cursor that contains the selected data from the myContacts table
         */
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ((TextView) view.findViewById(R.id.nameTextView)).
                    setText(cursor.getString(cursor.getColumnIndex("name")));
            ((TextView) view.findViewById(R.id.emailTextView)).
                    setText(cursor.getString(cursor.getColumnIndex("email")));
            ((TextView) view.findViewById(R.id.phoneTextView)).
                    setText(cursor.getString(cursor.getColumnIndex("phone")));
        }
}
