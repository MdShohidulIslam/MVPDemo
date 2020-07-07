package com.example.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{
    MainActivityContract.Presenter presenter;

    EditText email,password;
    Button login_btn,clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        presenter= new MainActivityPresenter(this);

        email=findViewById(R.id.etEmail_id);
        password=findViewById(R.id.etPassword_id);
        login_btn=findViewById(R.id.login_btn_id);
        clearBtn=findViewById(R.id.clear_btn_id);

        // click login

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate inputs
                String email1=email.getText().toString();
                String password1=password.getText().toString();

                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                    onError("Field's Required");
                }
                else{
                    presenter.doLogin(email1,password1);
                    Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    email.setText("");
                    password.setText("");
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText(null);
                password.setText(null);
            }
        });
    }

    @Override
    public void onSuccess(String mess) {
        Toast.makeText(this,mess, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String mess) {
        Toast.makeText(this,mess, Toast.LENGTH_SHORT).show();

    }
}
