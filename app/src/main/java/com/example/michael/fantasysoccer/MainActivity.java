package com.example.michael.fantasysoccer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.michael.fantasysoccer.PlayerDataBase;
import com.example.michael.fantasysoccer.SoccerPlayer.Player;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, View.OnTouchListener {

    //variables
    PlayerDataBase base = new PlayerDataBase();
    Player player1 ;

    String firstName;
    String lastName;
    int playerNum;
    String teamName;
    String position;
    int rating;
    boolean addBoolean;

    private Button nextButton;
    private Button addPlayerButton;
    private Button removeButton;
    private EditText fNameField;
    private EditText lNameField;
    private EditText playerNumberField;
    private EditText teamNameField;
    private TextView checkField;
    private EditText positionField;
    private EditText ratingField;
    private TextView removeText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates buttons
        nextButton = (Button) findViewById(R.id.toActivity2);
        addPlayerButton = (Button) findViewById(R.id.AddPlayer);
        removeButton = (Button) findViewById(R.id.RemoveButton);

        //creates  edit views and text views
        fNameField = (EditText) findViewById(R.id.firstNameField);
        lNameField = (EditText) findViewById(R.id.lastNameField);
        playerNumberField = (EditText) findViewById(R.id.playerNumberField);
        teamNameField = (EditText) findViewById(R.id.TeamField);
        checkField = (TextView) findViewById(R.id.Check);
        positionField = (EditText) findViewById(R.id.PositionField);
        ratingField = (EditText) findViewById(R.id.RatingField);
        removeText = (EditText) findViewById(R.id.RemovedText);


        //setting onClickListeners
        nextButton.setOnClickListener(this) ;
        addPlayerButton.setOnClickListener(this);
        removeButton.setOnClickListener(this);


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


    @Override
    public void onClick(View v) {
        if(v == nextButton) {

            startActivity(new Intent(MainActivity.this, SecondScreen.class));
        }

        if (v == addPlayerButton){
            //get the inputs from the text fields
            firstName = fNameField.getText().toString();
            lastName = lNameField.getText().toString();
            playerNum = Integer.parseInt(playerNumberField.getText().toString().trim());
            teamName = teamNameField.getText().toString();
            position = positionField.getText().toString();
            rating = Integer.parseInt(ratingField.getText().toString().trim());


            addBoolean = base.addPlayer(firstName, lastName, playerNum, teamName, position, rating);

            player1 = base.getPlayer(firstName, lastName);


              if ( addBoolean) {

                  checkField.append(player1.toString());
              }


        }

        if( v == removeButton){
           //calls removePlayer
            firstName = fNameField.getText().toString();
            lastName = lNameField.getText().toString();
            playerNum = Integer.parseInt(playerNumberField.getText().toString().trim());
            teamName = teamNameField.getText().toString();
            addBoolean= base.removePlayer(firstName, lastName);
          if(addBoolean){
              removeText.append(player1.toString());
          }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
