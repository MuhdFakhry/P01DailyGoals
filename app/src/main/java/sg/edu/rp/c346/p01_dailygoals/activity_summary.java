package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();

        // Get the String array named "ans" we passed in
        String[] ans = i.getStringArrayExtra("ans");

        // Get the TextView object
        TextView tvRead = findViewById(R.id.textViewRead);
        TextView tvTime = findViewById(R.id.textViewTime);
        TextView tvSolve = findViewById(R.id.textViewSolve);
        TextView tvDisplay = findViewById(R.id.textViewDisplay);

        // Display the name and age on the TextView
        tvRead.setText("Read up on materials before class: " + ans[0]);
        tvTime.setText("Arrive on time so as not to miss important part of the lesson: " + ans[1]);
        tvSolve.setText("Attempt the problem myself: " + ans[2]);
        tvDisplay.setText("My personal reflection today: " + ans[3]);

        // Intent to go back to main page
        Button btnBack = findViewById(R.id.buttobBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity_summary.this, MainActivity.class);

                //Start the new activity
                startActivity(i);
            }
        });
    }
}
