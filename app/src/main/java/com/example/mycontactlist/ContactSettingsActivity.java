package com.example.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ContactSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_settings);

        initListButton();
        initSettingsButton();
        initMapButton();
        initSettings();
        initRadioGroupSortBy();
    }

    private void initListButton() {
        Button listButton = findViewById(R.id.buttonList);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initSettingsButton() {
        Button settingsButton = findViewById(R.id.buttonSettings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton() {
        Button mapButton = findViewById(R.id.buttonMap);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initSettings() {
        SharedPreferences sharedPref = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE);
        String sortBy = sharedPref.getString("sortfield", "name");
        String sortOrder = sharedPref.getString("sortorder", "ascending");
        RadioButton rbName = findViewById(R.id.radioName);
        RadioButton rbCity = findViewById(R.id.radioCity);
        RadioButton rbBirthday = findViewById(R.id.radioBirthday);
        if (sortBy.equals("name")) {
            rbName.setChecked(true);
        } else if (sortBy.equals("city")) {
            rbCity.setChecked(true);
        } else {
            rbBirthday.setChecked(true);
        }
        RadioButton rbAscending = findViewById(R.id.radioAscending);
        RadioButton rbDescending = findViewById(R.id.radioDescending);
        if (sortOrder.equals("ascending")) {
            rbAscending.setChecked(true);
        } else {
            rbDescending.setChecked(true);
        }
    }

    private void initRadioGroupSortBy() {
        RadioGroup rg = findViewById(R.id.radioGroupSortBy);
        RadioButton rbName = findViewById(R.id.radioName);
        RadioButton rbCity = findViewById(R.id.radioCity);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbName.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortfield", "name");
                    editor.apply();
                } else if (rbCity.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortfield", "city");
                    editor.apply();
                } else {
                    SharedPreferences sp = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sortfield", "birthday");
                    editor.apply();
                }
            }
        });
    }

}










