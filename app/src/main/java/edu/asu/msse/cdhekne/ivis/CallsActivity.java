package edu.asu.msse.cdhekne.ivis;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CallsActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageButton mic_button;
    private ImageButton back_button;
    private ImageButton one, two, three, four, five, six, seven, eight, nine, asterisk, hash, zero;
    private TextView mainTV;
    private static final int SPEECH_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);

        mic_button =(ImageButton)findViewById(R.id.mic_button);
        mic_button.setOnClickListener(this);

        back_button = (ImageButton)findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        mainTV = (TextView)findViewById(R.id.mainTV);

        one = (ImageButton)findViewById(R.id.button_one);
        one.setOnClickListener(this);
        two = (ImageButton)findViewById(R.id.button_two);
        two.setOnClickListener(this);
        three = (ImageButton)findViewById(R.id.button_three);
        three.setOnClickListener(this);
        four = (ImageButton)findViewById(R.id.button_four);
        four.setOnClickListener(this);
        five = (ImageButton)findViewById(R.id.button_five);
        five.setOnClickListener(this);
        six = (ImageButton)findViewById(R.id.button_six);
        six.setOnClickListener(this);
        seven = (ImageButton)findViewById(R.id.button_seven);
        seven.setOnClickListener(this);
        eight = (ImageButton)findViewById(R.id.button_eight);
        eight.setOnClickListener(this);
        nine = (ImageButton)findViewById(R.id.button_nine);
        nine.setOnClickListener(this);
        asterisk = (ImageButton)findViewById(R.id.button_asterisk);
        asterisk.setOnClickListener(this);
        hash = (ImageButton)findViewById(R.id.button_hash);
        hash.setOnClickListener(this);
        zero = (ImageButton)findViewById(R.id.button_zero);
        zero.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==mic_button.getId()){
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        }

        if(v.getId() == back_button.getId()){
            Intent intent = new Intent(CallsActivity.this, CallAndContactsHomePageActivity.class);
            startActivity(intent);
        }

        if(v.getId() == one.getId()){
            mainTV.append("1");
        }
        if(v.getId() == two.getId()){
            mainTV.append("2");
        }
        if(v.getId() == three.getId()){
            mainTV.append("3");
        }
        if(v.getId() == four.getId()){
            mainTV.append("4");
        }
        if(v.getId() == five.getId()){
            mainTV.append("5");
        }
        if(v.getId() == six.getId()){
            mainTV.append("6");
        }
        if(v.getId() == seven.getId()){
            mainTV.append("7");
        }
        if(v.getId() == eight.getId()){
            mainTV.append("8");
        }
        if(v.getId() == nine.getId()){
            mainTV.append("9");
        }
        if(v.getId() == zero.getId()){
            mainTV.append("0");
        }
        if(v.getId() == asterisk.getId()){
            mainTV.append("*");
        }
        if(v.getId() == hash.getId()){
            mainTV.append("#");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
//            Log.d("Speech Output:---->>>>>",spokenText);
            if(spokenText.contains("navigate")){

                /*Intent goToNavigationIntent = new Intent();
                startActivity(goToNavigationIntent);*/
                Toast.makeText(getApplicationContext(), spokenText, Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("media")){
                /*Intent goToMediaIntent = new Intent();
                startActivity(goToMediaIntent);*/
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("phone")|| spokenText.contains("call")){
                /*Intent goToPhoneIntent = new Intent();
                startActivity(goToPhoneIntent);*/
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("controls")){
                /*Intent goToControlsIntent = new Intent();
                startActivity(goToControlsIntent);*/
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("climate")){
                /*Intent goToClimateIntent = new Intent();
                startActivity(goToClimateIntent);*/
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("apps")){
                /*Intent goToAppsIntent = new Intent();
                startActivity(goToAppsIntent);*/
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("home")){
                Intent goToHomeIntent = new Intent(CallsActivity.this, LandingPage.class);
                startActivity(goToHomeIntent);
            }
            else if(spokenText.contains("back")){
                Intent goToHomeIntent = new Intent(CallsActivity.this, CallAndContactsHomePageActivity.class);
                startActivity(goToHomeIntent);
            }
            else if(spokenText.matches("[0-9]+")){
                mainTV.append(spokenText);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calls, menu);
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
}
