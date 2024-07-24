package com.example.android55_btvn_day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText edtUserName;

    private EditText edtPassword;

    private ImageButton btnBackHome;

    private Button btnLogin;

    private static String USER_NAME_DEFAULT = "hoan";
    private static String PASSWORD_DEFAULT = "12345";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        btnBackHome = findViewById(R.id.btnBackHome);
        btnLogin = findViewById(R.id.btnLogin);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUserName.getText().toString();
                String passWord = edtPassword.getText().toString();
                if(userName != null && !userName.isEmpty() && passWord != null && !passWord.isEmpty()){
                    if(userName.equals(USER_NAME_DEFAULT) && passWord.equals(PASSWORD_DEFAULT)){
                        Intent intent = getIntent();
                        intent.putExtra("USER_NAME_DATA", userName);
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Thong tin nhap sai", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Vui long nhap thong tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
//                setResult(RESULT_CANCELED);
//                finish();
            }
        });
    }

}