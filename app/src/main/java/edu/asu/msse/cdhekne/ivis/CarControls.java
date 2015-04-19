package edu.asu.msse.cdhekne.ivis;

import android.content.Intent;
import android.media.Image;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


public class CarControls extends ActionBarActivity implements View.OnClickListener {

    private ImageButton front_wiper, rear_wiper, front_wiper_off, front_wiper_1, front_wiper_2, front_wiper_3, rear_wiper_off, rear_wiper_on;
    private ImageButton low_beam, high_beam, mic, settings, home, help, back;
    private static final int SPEECH_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_controls);

        front_wiper = (ImageButton) findViewById(R.id.front_wiper_button);
        front_wiper_off = (ImageButton)findViewById(R.id.front_wiper_off_button);

        front_wiper_1 = (ImageButton) findViewById(R.id.front_wiper_1_button);
        front_wiper_2 = (ImageButton) findViewById(R.id.front_wiper_2_button);
        front_wiper_3 = (ImageButton) findViewById(R.id.front_wiper_3_button);
        rear_wiper = (ImageButton) findViewById(R.id.rear_wiper_button);
        rear_wiper_off = (ImageButton) findViewById(R.id.rear_wiper_off_button);
        rear_wiper_on = (ImageButton) findViewById(R.id.rear_wiper_on_button);
        low_beam = (ImageButton) findViewById(R.id.low_beam_button);
        high_beam = (ImageButton) findViewById(R.id.high_beam_button);
        mic = (ImageButton) findViewById(R.id.mic_button);
        settings = (ImageButton) findViewById(R.id.settings_button);
        help = (ImageButton) findViewById(R.id.help_button);
        back = (ImageButton) findViewById(R.id.back_button);
        home = (ImageButton)findViewById(R.id.home_button);

        back.setOnClickListener(this);
        help.setOnClickListener(this);
        settings.setOnClickListener(this);
        mic.setOnClickListener(this);
        high_beam.setOnClickListener(this);
        low_beam.setOnClickListener(this);
        rear_wiper_on.setOnClickListener(this);
        rear_wiper_off.setOnClickListener(this);
        home.setOnClickListener(this);
        front_wiper_off.setOnClickListener(this);
        front_wiper_1.setOnClickListener(this);
        front_wiper_2.setOnClickListener(this);
        front_wiper_3.setOnClickListener(this);
        rear_wiper_off.setOnClickListener(this);
        rear_wiper_on.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_car_controls, menu);
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
        if (v.getId() == mic.getId()) {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } else if (v.getId() == back.getId()) {
            this.finish();
        } else if (v.getId() == home.getId()) {
            Intent goToHomeIntent = new Intent(CarControls.this, LandingPage.class);
            goToHomeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(goToHomeIntent);
        } else if (v.getId() == low_beam.getId()) {
            low_beam.setVisibility(View.INVISIBLE);
            high_beam.setVisibility(View.VISIBLE);
        } else if (v.getId() == high_beam.getId()) {
            high_beam.setVisibility(View.INVISIBLE);
            low_beam.setVisibility(View.VISIBLE);
        } else if (v.getId() == rear_wiper_off.getId()) {
            rear_wiper_on.setVisibility(View.VISIBLE);
            rear_wiper_off.setVisibility(View.INVISIBLE);
        } else if (v.getId() == rear_wiper_on.getId()) {
            rear_wiper_off.setVisibility(View.VISIBLE);
            rear_wiper_on.setVisibility(View.INVISIBLE);
        } else if (v.getId() == front_wiper_off.getId()) {
            front_wiper_off.setBackgroundResource(R.drawable.wiper_off_rear_xhdpi);
            front_wiper_1.setBackgroundResource(R.drawable.wiper1_xhdpi);
            front_wiper_2.setBackgroundResource(R.drawable.wiper2_xhdpi);
            front_wiper_3.setBackgroundResource(R.drawable.wiper3_xhdpi);
        } else if (v.getId() == front_wiper_1.getId()) {
            front_wiper_off.setBackgroundResource(R.drawable.wiper_off_xhdpi);
            front_wiper_1.setBackgroundResource(R.drawable.wiper_1_active_xhdpi);
            front_wiper_2.setBackgroundResource(R.drawable.wiper2_xhdpi);
            front_wiper_3.setBackgroundResource(R.drawable.wiper3_xhdpi);
        } else if (v.getId() == front_wiper_2.getId()) {
            front_wiper_off.setBackgroundResource(R.drawable.wiper_off_xhdpi);
            front_wiper_1.setBackgroundResource(R.drawable.wiper1_xhdpi);
            front_wiper_2.setBackgroundResource(R.drawable.wiper_2_active_xhdpi);
            front_wiper_3.setBackgroundResource(R.drawable.wiper3_xhdpi);
        } else if (v.getId() == front_wiper_3.getId()) {
            front_wiper_off.setBackgroundResource(R.drawable.wiper_off_xhdpi);
            front_wiper_1.setBackgroundResource(R.drawable.wiper1_xhdpi);
            front_wiper_2.setBackgroundResource(R.drawable.wiper2_xhdpi);
            front_wiper_3.setBackgroundResource(R.drawable.wiper_3_active_xhdpi);
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
            Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            if (spokenText.contains("low")) {
                if(spokenText.contains("beam")) {
                    low_beam.setVisibility(View.VISIBLE);
                    high_beam.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), spokenText, Toast.LENGTH_SHORT).show();
                }
            }
            else if(spokenText.contains("max")){
                if(spokenText.contains("beam")) {
                    high_beam.setVisibility(View.VISIBLE);
                    low_beam.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), spokenText, Toast.LENGTH_SHORT).show();
                }
            }
            else if(spokenText.contains("home")){
                Intent goToHomeIntent = new Intent(CarControls.this,LandingPage.class);
                Toast.makeText(getApplicationContext(), spokenText, Toast.LENGTH_SHORT).show();
                startActivity(goToHomeIntent);
            }
            else if(spokenText.contains("go back")){
                Intent goBackIntent = new Intent(CarControls.this,LandingPage.class);
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
                startActivity(goBackIntent);
            }
            else if(spokenText.contains("settings")){
                /*Intent goBackIntent = new Intent(CarControls.this,LandingPage.class);
                startActivity(goBackIntent);*/
            }
            else if(spokenText.contains("back wiper"))
            {
                if(spokenText.contains("on")) {
                    rear_wiper_on.setVisibility(View.VISIBLE);
                    rear_wiper_off.setVisibility(View.INVISIBLE);
                }
                else if(spokenText.contains("off")){
                    rear_wiper_off.setVisibility(View.VISIBLE);
                    rear_wiper_on.setVisibility(View.INVISIBLE);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
