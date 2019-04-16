package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //get the RadioGroup object
                RadioGroup rg1 = findViewById(R.id.RadioGroup1);
                RadioGroup rg2 = findViewById(R.id.RadioGroup2);
                RadioGroup rg3 = findViewById(R.id.RadioGroup3);

                //get the Id if the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();


                // Get the radio button project from the Id we had gotten above
                RadioButton rb1 = findViewById(selectedButtonId1);
                RadioButton rb2 = findViewById(selectedButtonId2);
                RadioButton rb3 = findViewById(selectedButtonId3);

                //Get the EditText that user keys in reflection
                EditText etReflect = findViewById(R.id.editTextReflect);

                // Put the answers into an array
                String[] ans = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), etReflect.getText().toString()};

                //Create an intent to start another activity called
                // DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this, activity_summary.class);

                //Pass the String array holding the name and age to new activity
                i.putExtra("ans", ans);

                //Start the new activity
                startActivity(i);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();

        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        //Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1d: Add the key-value pair
        prefEdit.putString("name", strName);

        //Step 1e: Call commit() method to save the changes into the Shared Preferences
        prefEdit.commit();
    }

}
