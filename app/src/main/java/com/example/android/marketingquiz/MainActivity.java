package com.example.android.marketingquiz;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {

        EditText userName = findViewById(R.id.name_field);
        String name = userName.getText().toString();

        RadioGroup radioGroup1 = findViewById(R.id.question1);
        int question1Answer = radioGroup1.getCheckedRadioButtonId();

        RadioGroup radioGroup2 = findViewById(R.id.question2);
        int question2Answer = radioGroup2.getCheckedRadioButtonId();

        RadioGroup radioGroup3 = findViewById(R.id.question3);
        int question3Answer = radioGroup3.getCheckedRadioButtonId();

        RadioGroup radioGroup4 = findViewById(R.id.question4);
        int question4Answer = radioGroup4.getCheckedRadioButtonId();

        CheckBox q5Answer1CheckBox = findViewById(R.id.q5_a1_checkbox);
        boolean question5Answer1 = q5Answer1CheckBox.isChecked();

        CheckBox q5Answer2CheckBox = findViewById(R.id.q5_a2_checkbox);
        boolean question5Answer2 = q5Answer2CheckBox.isChecked();

        CheckBox q5Answer3CheckBox = findViewById(R.id.q5_a3_checkbox);
        boolean question5Answer3 = q5Answer3CheckBox.isChecked();

        int score = calculateScore(question1Answer, question2Answer, question3Answer, question4Answer, question5Answer1, question5Answer2, question5Answer3);

        //Toast message = Toast.makeText(this, "Thank you " + name + "for using marketing quiz. Your score is " + score + "/10", LENGTH_LONG);

                Toast message = new Toast(getApplicationContext());
        message.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        TextView tv = new TextView(MainActivity.this);
        tv.setBackgroundColor(Color.BLACK);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(25);

        //String text = new String();
        String text = "Thank you " + name + " for using Marketing quiz. Your score is " + score + "/10";

        Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
        tv.setTypeface(t);
        tv.setPadding(10, 10, 10, 10);
        tv.setText(text);
        message.setView(tv);
        message.show();
    }

    private int calculateScore(int answer1, int answer2, int answer3, int answer4, boolean answer5, boolean answer6, boolean answer7) {

        int score = 0;

        if (answer1 == R.id.q1_a1) {
            score = score + 2;
        }

        if (answer2 == R.id.q2_a3) {
            score = score + 2;
        }

        if (answer3 == R.id.q3_a1) {
            score = score + 2;
        }

        if (answer4 == R.id.q4_a1) {
            score = score + 2;
        }

        if (answer5 && answer6 && answer7) {
            score = score + 2;
        }

        return score;
    }

}
