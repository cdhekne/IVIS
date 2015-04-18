package edu.asu.msse.cdhekne.ivis;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


public class LandingPage extends ActionBarActivity implements View.OnClickListener {

    private ImageButton mic_button,car_controls,apps,climate,phone,navigation,media,settings,help;
    private static final int SPEECH_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mic_button =(ImageButton)findViewById(R.id.mic_button);
        mic_button.setOnClickListener(this);

        navigation = (ImageButton)findViewById(R.id.nav_button);
        navigation.setOnClickListener(this);

        media= (ImageButton)findViewById(R.id.media_button);
        media.setOnClickListener(this);

        phone = (ImageButton)findViewById(R.id.call_button);
        phone.setOnClickListener(this);

        car_controls = (ImageButton)findViewById(R.id.carControls_button);
        car_controls.setOnClickListener(this);

        climate = (ImageButton)findViewById(R.id.climate_button);
        climate.setOnClickListener(this);

        apps = (ImageButton)findViewById(R.id.apps_button);
        apps.setOnClickListener(this);

        /*settings = (ImageButton)findViewById(R.id.settings_button);
        settings.setOnClickListener(this);*/
/*
        help = (ImageButton)findViewById(R.id.help_button);
        help.setOnClickListener(this);*/
    }

    @Override
    public void onClick(View v){
        if(v.getId()==mic_button.getId()){
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        }
        else if(v.getId()==navigation.getId()){
            Intent intent = new Intent(LandingPage.this, NavigationActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==media.getId()){
            Intent intent = new Intent(LandingPage.this,MediaAndRadioHomePageActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==phone.getId()){
            Intent intent = new Intent(LandingPage.this,CallAndContactsHomePageActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==car_controls.getId()){
            Intent intent = new Intent(LandingPage.this,CarControls.class);
            startActivity(intent);
        }
        else if(v.getId()==climate.getId()){
            /*Intent intent = new Intent(LandingPage.this,);
            startActivity(intent);*/
        }
        else if(v.getId()==apps.getId()){
            /*Intent intent = new Intent(LandingPage.this,);
            startActivity(intent);*/
        }
        /*else if(v.getId()==settings.getId()){
            *//*Intent intent = new Intent(LandingPage.this,);
            startActivity(intent);*//*
        }
        else if(v.getId()==help.getId()){
            *//*Intent intent = new Intent(LandingPage.this,);
            startActivity(intent);*//*
        }*/
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
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("media")){
                Intent goToMediaIntent = new Intent(LandingPage.this, MediaAndRadioHomePageActivity.class);
                startActivity(goToMediaIntent);
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("phone")|| spokenText.contains("call")){
                Intent goToPhoneIntent = new Intent(LandingPage.this, CallAndContactsHomePageActivity.class);
                startActivity(goToPhoneIntent);
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("controls")){
                Intent goToControlsIntent = new Intent(LandingPage.this,CarControls.class);
                startActivity(goToControlsIntent);
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
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing_page, menu);
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
