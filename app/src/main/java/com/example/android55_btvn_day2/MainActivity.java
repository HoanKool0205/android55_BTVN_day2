package com.example.android55_btvn_day2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;

    private Button btnJoinNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLoad();
        btnJoinNow = findViewById(R.id.btnJoinNow);
        textView = findViewById(R.id.textView);

        btnJoinNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                loginResultLancher.launch(intent);
            }
        });
    }

    private ActivityResultLauncher<Intent> loginResultLancher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if(o.getResultCode() == RESULT_OK){
                Intent intent = o.getData();
                String dataName = intent.getStringExtra("USER_NAME_DATA");
                textView.setText(dataName);
            } else {
                Toast.makeText(MainActivity.this, "Huy dang nhap", Toast.LENGTH_SHORT).show();
            }
        }
    });

    private void initLoad(){
        Log.d(TAG, "initLoad: ");
    }
}