package com.example.harsha.basicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String message = extras.getString("Message");
        String givers = extras.getString("Giver");
        String takers = extras.getString("Taker");
        TextView textview = new TextView(this);
        textview.setTextSize(40);
        textview.setText(givers+" gave Rs."+message+" to "+takers);

        setContentView(textview);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
