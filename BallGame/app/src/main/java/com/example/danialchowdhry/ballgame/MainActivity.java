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
            Welcome initialFragment = new Welcome();
            initialFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, initialFragment).commit();
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
        int rando = (int) (Math.random() * 5);
        correctNum = ((Integer)(rando+1)).toString();
        Bundle args = new Bundle();
        Game newFragment = new Game();
        args.putInt("param1", rando);
        newFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.commit();
    }

    public void checkAnswer(View view) {
        TextView mTextView =  (TextView) findViewById(R.id.resultView);
        String answer = ((EditText) findViewById(R.id.edit_message)).getText().toString();
        if (answer.equals(correctNum)) {
            mTextView.setTextColor(Color.GREEN);
            mTextView.setText("Correct!");
        } else {
            mTextView.setTextColor(Color.RED);
            mTextView.setText("Incorrect");
        }
    }
}
