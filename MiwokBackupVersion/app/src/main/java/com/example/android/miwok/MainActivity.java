/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mNumbers;
    TextView mFamily;
    TextView mColors;
    TextView mPhrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        mNumbers = (TextView) findViewById(R.id.numbers);
        mFamily = (TextView) findViewById(R.id.family);
        mColors = (TextView) findViewById(R.id.colors);
        mPhrases = (TextView) findViewById(R.id.phrases);

        mNumbers.setOnClickListener(this);
        mFamily.setOnClickListener(this);
        mColors.setOnClickListener(this);
        mPhrases.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intenet;
        switch (v.getId()) {
            case R.id.numbers:
                intenet = new Intent(this, NumbersActivity.class);
                startActivity(intenet);
                break;
            case R.id.family:
                intenet = new Intent(this, FamilyActivity.class);
                startActivity(intenet);
                break;
            case R.id.colors:
                intenet = new Intent(this, ColorsActivity.class);
                startActivity(intenet);
                break;
            case R.id.phrases:
                intenet = new Intent(this, PhrasesActivity.class);
                startActivity(intenet);
                break;
        }

    }
}
