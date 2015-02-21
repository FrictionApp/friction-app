package com.frictionapp.friction;

import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.EditText;

import org.w3c.dom.Text;

/**
 * Created by Luqmaan on 2/20/2015.
 */
public class JSonActivity extends MainActivity{
    public SearchView input;
    public EditText output;


    public void pushInterests(View w) {
        input = (SearchView) findViewById(R.id.aboutme_searchview);
        output.setText(input.getQuery());

        TextView setThis = (TextView) findViewById(R.id.aboutme_textbox);
        setThis.setText(output.toString());
    }

}
