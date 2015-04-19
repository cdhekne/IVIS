package edu.asu.msse.cdhekne.ivis;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


public class CallAndContactsHomePageActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageButton mic_button;
    private ImageButton home_button;
    private ImageButton back_button, call_button, contacts_button;
    private static final int SPEECH_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_and_contacts_home_page);
        mic_button =(ImageButton)findViewById(R.id.mic_button);
        mic_button.setOnClickListener(this);

        home_button = (ImageButton)findViewById(R.id.home_button);
        home_button.setOnClickListener(this);

        back_button = (ImageButton)findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        call_button = (ImageButton)findViewById(R.id.call_button);
        call_button.setOnClickListener(this);

        contacts_button = (ImageButton)findViewById(R.id.contacts_button);
        contacts_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==mic_button.getId()){
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        }

        if(v.getId() == home_button.getId()){
            Intent goToHomeIntent = new Intent(CallAndContactsHomePageActivity.this, LandingPage.class);
            goToHomeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(goToHomeIntent);
        }

        if(v.getId() == back_button.getId()){
            this.finish();
        }

        if(v.getId() == call_button.getId()){
            Intent intent = new Intent(CallAndContactsHomePageActivity.this, CallsActivity.class);
            startActivity(intent);
        }
        /*if(v.getId() == contacts_button.getId()){

            Intent intent = new Intent(CallAndContactsHomePageActivity.this, LandingPage.class);
            startActivity(intent);
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
            if(spokenText.contains("phone")){
                Intent goToAppsPhone = new Intent(CallAndContactsHomePageActivity.this, CallsActivity.class);
                startActivity(goToAppsPhone);
                Toast.makeText(getApplicationContext(),spokenText,Toast.LENGTH_SHORT).show();
            }
            else if(spokenText.contains("home")){
                Intent goToHomeIntent = new Intent(CallAndContactsHomePageActivity.this, LandingPage.class);
                goToHomeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(goToHomeIntent);
            }
            else if(spokenText.contains("back")){
                this.finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_call_and_contacts_home_page, menu);
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
