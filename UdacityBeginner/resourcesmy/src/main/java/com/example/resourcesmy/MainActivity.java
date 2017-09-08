package com.example.resourcesmy;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
/*
        // Считывание  обычной  строки  и  помещение  ее  в  текстовый  вид
        String simpleString  =  getString (R.string.simple_string);
        textView.setText(simpleString);

// Считывание  строки в кавычках и помещение ее в текстовый вид
        String quotedString  =  getString(R.string.quoted_string);
        textView.setText(quotedString);

// Считывание строки в двойных кавычках и помещение ее в текстовый  вид
        String  doubleQuotedString  =  getString(R.string.double_quoted_string);
        textView.setText(doubleQuotedString);

//  Считывание строки форматирования Java
        String javaFormatString  =  getString(R.string.java_format_string);
// Преобразование отформатированной строки при  помощи  данных
// передаваемых в аргументах
        String  substitutedString  =  String.format(javaFormatString,
                "Рыжик",  "Барсик" );
// помещение вывода в текстовый  вид
        textView.setText(substitutedString);
*/
//  Считывание  строки  html_string из ресурса и помещение ее в текстовый  вид
        //String htmlTaggedString  =  getString(R.string.tagged_string);
// Преобразование строки во фрагмент текста,
// который  может  быть  помещен  в  текстовом  виде
// Класс  android.text.Html допускает  рисование строк "html" (не все теги)
      //  Spanned textSpan  =  android.text.Html.fromHtml(htmlTaggedString);
// Поместить  информацию  в  текстовый  вид
       // textView.setText(R.string.tagged_string);

        //textView.setText(Html.fromHtml(getString(R.string.long_message)));

        //textView.setText(getString(R.string.title, "Васька", "Толя"));

       /* Resources res = getResources();
        boolean autostartSetting = res.getBoolean(R.bool.sound);

        textView.setText(String.valueOf(autostartSetting));*/

        // загрузка массива строк из res/values/arrays.xml в текстовое поле textStrings

        StringBuffer textStrings = new StringBuffer("");
        String[] names = getResources().getStringArray(R.array.choose);
        for(int i = 0; i < names.length; i++) {
            textStrings.append("Name[" + i + "]: "+ names[i] + "\n");
        }
        textView.setText(textStrings);

// загрузка массива целых чисел из res/values/arrays.xml в текстовое поле textDigits
        int[] digits = getResources().getIntArray(R.array.years);
        for(int i = 0; i < digits.length; i++) {
            textStrings.append("Digit[" + i + "]: "+ digits[i] + "\n");
        }
        textView.setText(textStrings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


}
