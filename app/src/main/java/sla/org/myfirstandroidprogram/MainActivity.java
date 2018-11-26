package sla.org.myfirstandroidprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Controller myController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ttv = findViewById(R.id.topTextView);
        TextView btv = findViewById(R.id.bottomTextView);
        TextView ftv = findViewById(R.id.feedbackTextView);
        EditText et = findViewById(R.id.editText);
        Button fb = findViewById(R.id.footballButton);
        Button lb = findViewById(R.id.lacrosseButton);
        RadioGroup rg = findViewById(R.id.radioGroup);
        RadioButton frb = findViewById(R.id.firstRadioButton);
        RadioButton srb = findViewById(R.id.secondRadioButton);
        RadioButton trb = findViewById(R.id.thirdRadioButton);

        myController = new Controller(ttv, btv, ftv, et, fb, lb, rg, frb, srb, trb);
    }

    @Override
    protected void onStop() {
        myController.save();
        super.onStop();
    }
}
