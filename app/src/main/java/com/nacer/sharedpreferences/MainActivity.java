package com.nacer.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SharedPreferences mPreference;
    private SharedPreferences.Editor mEditor;
    private EditText mName, mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.etName);
        mPassword =  findViewById(R.id.etPassword);
        btnLogin =  findViewById(R.id.btnLogin);
        mCheckBox =  findViewById(R.id.checkbox);
        mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreference=getSharedPreferences("tabian.com.sharedpreferncestest", Context.MODE_PRIVATE)
        mEditor = mPreference.edit();
        checkSharedPrefernce();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox.isChecked()) {
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();

                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password), password);
                    mEditor.commit();

                } else {
                    if (mCheckBox.isChecked()) {
                        mEditor.putString(getString(R.string.checkbox), "False");
                        mEditor.commit();

                        String name = mName.getText().toString();
                        mEditor.putString(getString(R.string.name), "");
                        mEditor.commit();

                        String password = mPassword.getText().toString();
                        mEditor.putString(getString(R.string.password), "");
                        mEditor.commit();

                    }
                }
            }
        }) ;

    }
     /*   mEditor.putString("key","mitch");
        mEditor.commit();

        String name=mPreference.getString("Key","default");
        Log.d(TAG, "onCreate: name :"+name );*/




    private void checkSharedPrefernce(){
        String checkbox= mPreference.getString(getString(R.string.checkbox), "False");
        String name= mPreference.getString(getString(R.string.name),"");
        String password= mPreference.getString(getString(R.string.password),"");

        mName.setText(name);
        mPassword.setText(password);

        if (checkbox.equals("true")){
            mCheckBox.setChecked(true);
        }
        else {
            mCheckBox.setChecked((false));
        }
    }
}