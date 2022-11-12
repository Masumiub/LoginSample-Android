package com.masum.myloginsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper databaseHelper;
    private Button LoginBtn, SignupBtn;
    private EditText username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        LoginBtn= (Button)findViewById(R.id.LoginBtn);
        SignupBtn = (Button)findViewById(R.id.SignupBtn);
        username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.Password);

        LoginBtn.setOnClickListener(this);
        SignupBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user_name = username.getText().toString();
        String Pass_word = Password.getText().toString();

        if(view.getId()==R.id.LoginBtn){
            Boolean result = databaseHelper.findPassword(user_name, Pass_word);

            if(result == true){
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Username & password didn't Match", Toast.LENGTH_LONG).show();
            }
        }
        else if(view.getId()==R.id.SignupBtn){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}