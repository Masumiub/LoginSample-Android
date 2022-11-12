package com.masum.myloginsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameID, emailID, usernameID, passwordID;
    private Button signupBtn;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupBtn = (Button)findViewById(R.id.signupBtn);
        nameID = (EditText) findViewById(R.id.nameID);
        emailID = (EditText)findViewById(R.id.emailID);
        usernameID = (EditText)findViewById(R.id.usernameID);
        passwordID = (EditText)findViewById(R.id.passwordID);

        signupBtn.setOnClickListener(this);

        userDetails = new UserDetails();

        databaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View view) {
        String name = nameID.getText().toString();
        String email = emailID.getText().toString();
        String username = usernameID.getText().toString();
        String password = passwordID.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseHelper.insertData(userDetails);
    }
}