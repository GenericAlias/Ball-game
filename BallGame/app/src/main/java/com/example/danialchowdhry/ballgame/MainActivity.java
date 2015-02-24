package com.example.danialchowdhry.ballgame;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * MainActivity. Holds functionality of all buttons
 * and has a field to keep track of the correct answer
 * to the single query in the game fragment and compares
 * that user's input against it.
 */

public class MainActivity extends FragmentActivity implements Game.OnFragmentInteractionListener, Welcome.OnFragmentInteractionListener {
    String correctNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            // Set up the welcome screen as a fragment
            Welcome initialFragment = new Welcome();
            // Get a transaction from fragment manager and use it to add welcome fragment to main's
            // fragment container
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, initialFragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void onFragmentInteraction(Uri uri) {

    }

    public void gameStart(View view) {
        // Use a random variable to decide which ball picture appears on the screen
        int rando = (int) (Math.random() * 5);
        // Set the correctNum field so it can be determined whether or not the user is entering
        // the right number in
        correctNum = ((Integer)(rando+1)).toString();
        // Send it to game fragment
        Bundle args = new Bundle();
        Game newFragment = new Game();
        args.putInt("param1", rando);
        newFragment.setArguments(args);
        // Use a fragment transaction to replace contents of the container with the game fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.commit();
    }

    public void checkAnswer(View view) {
        // Get text from user input in game fragment
        TextView mTextView =  (TextView) findViewById(R.id.resultView);
        String answer = ((EditText) findViewById(R.id.edit_message)).getText().toString();
        // Check if its right and output accordingly
        if (answer.equals(correctNum)) {
            mTextView.setTextColor(Color.GREEN);
            mTextView.setText("Correct!");
        } else {
            mTextView.setTextColor(Color.RED);
            mTextView.setText("Incorrect");
        }
    }
}
