package com.example.dasha.educationalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int numberOfCorrectAnswers = 0;

    CheckBox chbDesign;
    CheckBox chbDevelopment;
    CheckBox chbDestribution;


    RadioButton rbFindView;
    RadioButton rbManifest;
    RadioButton rbListener;

    EditText etViewGroup;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbDesign = (CheckBox) findViewById(R.id.chb_design);
        chbDevelopment = (CheckBox) findViewById(R.id.chb_development);
        chbDestribution = (CheckBox) findViewById(R.id.chb_distribution);


        chbDesign.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        chbDevelopment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        chbDestribution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chbDesign.isChecked() && chbDevelopment.isChecked() && chbDestribution.isChecked()) {
                    numberOfCorrectAnswers++;
                }
            }
        });


        rbFindView = (RadioButton) findViewById(R.id.rb_findview);

        rbFindView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    numberOfCorrectAnswers++;
                }
            }
        });


        etViewGroup = (EditText) findViewById(R.id.et_viewgroup);

        etViewGroup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int before) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String answer = charSequence.toString();
                if (answer.equals("ViewGroup")) {
                    numberOfCorrectAnswers++;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        rbManifest = (RadioButton) findViewById(R.id.rb_manifest);
        if (rbManifest.isChecked() == false) {
            rbManifest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b == true) {
                        numberOfCorrectAnswers++;
                    }
                }
            });
        }


        rbListener = (RadioButton) findViewById(R.id.rb_listener);


        rbListener.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    numberOfCorrectAnswers++;
                }
            }
        });


        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Your result is " + numberOfCorrectAnswers,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
