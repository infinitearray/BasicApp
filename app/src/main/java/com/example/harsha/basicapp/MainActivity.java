package com.example.harsha.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.harsha.basicapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropdown1 = (Spinner)findViewById(R.id.spinner1);
        String[] items1 = new String[]{"Harsha", "Vishal", "Vivek", "Varshit", "Ram"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter1);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{"Harsha", "Vishal", "Vivek", "Varshit", "Ram"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //called when user clicks send button
    public void sendMessage(View view) {
        // do something
        Intent intent=new Intent(this, DisplayMessageActivity.class);
        EditText edittext = (EditText) findViewById(R.id.message);
        String message = edittext.getText().toString();
        Spinner giver = (Spinner) findViewById(R.id.spinner1);
        String givers = giver.getSelectedItem().toString();
        Spinner taker = (Spinner) findViewById(R.id.spinner2);
        String takers = taker.getSelectedItem().toString();
        intent.putExtra("Message", message);
        intent.putExtra("Giver", givers);
        intent.putExtra("Taker", takers);
        startActivity(intent);

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
