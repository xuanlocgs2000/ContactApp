package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_name, txt_pass;
    Button btn_save;
    SharedPreferences sharedPreferences;
    private  static  final String SHARED_PREF_NAME ="mypref";
    private static  final String KEY_NAME="name";
    private static  final String KEY_PASS="pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_name = findViewById(R.id.txt_name);
        txt_pass = findViewById(R.id.txt_pass);
        btn_save = findViewById(R.id.btn_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);
        if(name != null){
            //check data
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
//            Toast.makeText(MainActivity.this,"Login sucess",Toast.LENGTH_SHORT).show();
        }
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(KEY_NAME,txt_name.getText().toString());
                editor.putString(KEY_PASS,txt_pass.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Login sucess",Toast.LENGTH_SHORT).show();

            }
        });



    }
}