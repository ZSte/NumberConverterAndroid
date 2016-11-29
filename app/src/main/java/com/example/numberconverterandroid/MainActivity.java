package com.example.numberconverterandroid;
/**
 * The main activity for the program
 * @author ZSte
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String [] it = new String [] {"2", "10"};
    public static int fromN;
    public static int toN;
    public static int num;
    public static int convNum;
    public Conversion c = new Conversion();
    public TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        t = (TextView) findViewById(R.id.result);
        Spinner from = (Spinner) findViewById(R.id.spinnerFrom);
        Spinner to = (Spinner) findViewById(R.id.spinnerTo);

        //sets the numbers based on what the user has chosen
        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch(pos) {
                    case 0: fromN = 2;
                        break;
                    case 1: fromN = 10;
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> view) {

            }
        });

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch(pos) {
                    case 0: toN = 2;
                        break;
                    case 1: toN = 10;
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> view) {

            }
        });

        ArrayAdapter<String> a = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, it);
        from.setAdapter(a);
        to.setAdapter(a);

    }

    /**
     * Displays the converted number in a TextView
     * @param view actual view
     */
    public void convert(View view) {
        //preCalc();
        EditText userInput = (EditText) findViewById(R.id.number);
        num = Integer.parseInt(userInput.getText().toString());
        convNum = Integer.parseInt(c.convert(num, fromN, toN));
        t.setText(getString(R.string.yourResult) + " " + convNum);
    }

    /**
     * Creates the Menu in the toolbar
     * @param menu actual menu
     * @return returns true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                this.startActivity(intent);
                return true;

            /*case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;*/

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
