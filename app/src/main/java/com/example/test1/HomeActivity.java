package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView textView_name, textView_pass;
    Button btn_exit;
    SharedPreferences sharedPreferences;
    private  static  final String SHARED_PREF_NAME ="mypref";
    private static  final String KEY_NAME="name";
    private static  final String KEY_PASS="pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView_name= findViewById(R.id.output_name);
        textView_pass= findViewById(R.id.output_pass);
        btn_exit = findViewById(R.id.btn_exit);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String pass = sharedPreferences.getString(KEY_PASS, null);
        if(name != null || pass !=null){
            textView_name.setText("FULL NAME : " + name);
            textView_pass.setText("Pass:"+pass);

        }
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(HomeActivity.this,"Logout sucess",Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}