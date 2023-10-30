package com.nassrallah.cdamtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    private TextView firstNameTV;
    private TextView lastNameTV;
    private TextView emailTV;
    private TextView passwordTV;
    private TextView mobileTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Bundle data = getIntent().getExtras();
        assert data != null;
        String firstName = data.getString("firstName");
        String lastName = data.getString("lastName");
        String email = data.getString("email");
        String password = data.getString("password");
        String phoneNumber = data.getString("phoneNumber");

        firstNameTV = findViewById(R.id.text_prenom);
        lastNameTV = findViewById(R.id.text_nom);
        emailTV = findViewById(R.id.text_email);
        passwordTV = findViewById(R.id.text_password);
        mobileTV = findViewById(R.id.text_mobile);

        firstNameTV.setText(firstName);
        lastNameTV.setText(lastName);
        emailTV.setText(email);
        passwordTV.setText(password);
        mobileTV.setText(phoneNumber);

    }
}