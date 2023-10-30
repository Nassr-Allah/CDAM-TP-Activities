package com.nassrallah.cdamtp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText passwordEditText;
    private TextInputLayout phoneNumberEditText;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText = findViewById(R.id.edittext_email);
        firstNameEditText = findViewById(R.id.edittext_prenom);
        lastNameEditText = findViewById(R.id.edittext_nom);
        passwordEditText = findViewById(R.id.edittext_password);
        phoneNumberEditText = findViewById(R.id.edittext_mobile);
        confirmBtn = findViewById(R.id.button_confirm);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getEditText().getText().toString();

                if (fieldsValidated(firstName, lastName, email, password, phoneNumber)) {
                    Intent startUserInfoIntent = new Intent(RegisterActivity.this, UserInfoActivity.class);
                    startUserInfoIntent.putExtra("firstName", firstName);
                    startUserInfoIntent.putExtra("lastName", lastName);
                    startUserInfoIntent.putExtra("email", email);
                    startUserInfoIntent.putExtra("password", password);
                    startUserInfoIntent.putExtra("phoneNumber", phoneNumber);
                    startActivity(startUserInfoIntent);
                } else {
                    Toast.makeText(
                            RegisterActivity.this,
                            "Fields are not valid! Please retry",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    private Boolean fieldsValidated(
            String firstName,
            String lastName,
            String email,
            String password,
            String phoneNumber
    ) {
        return isTextValid(firstName)
                && isTextValid(lastName)
                && isEmailValid(email)
                && isPasswordValid(password)
                && isPhoneNumberValid(phoneNumber);
    }

    private Boolean isTextValid(String text) {
        return !text.isEmpty();
    }

    private Boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private Boolean isPhoneNumberValid(String phoneNumber) {
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }

    private Boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

}