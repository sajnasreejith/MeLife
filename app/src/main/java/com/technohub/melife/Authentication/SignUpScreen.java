package com.technohub.melife.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.technohub.melife.R;
import com.technohub.melife.activities.BaseActivity;

public class SignUpScreen extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up_screen);
    getSupportActionBar().hide();
  }
}
