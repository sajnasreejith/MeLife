package com.technohub.melife.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.elasticviews.ElasticButton;
import com.technohub.melife.R;
import com.technohub.melife.activities.BaseActivity;

public class ChooseLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_choose_login);
        ElasticButton login,signup;
        login=(ElasticButton)findViewById(R.id.login) ;
        signup=(ElasticButton)findViewById(R.id.signup) ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginScreen.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpScreen.class));
            }
        });

    }
}
