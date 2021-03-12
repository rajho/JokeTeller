package com.example.android.jokedisplay;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.android.jokedisplay.databinding.ActivityJokeBinding;

public class JokeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);

    Intent intent = getIntent();
    if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
      String joke = intent.getStringExtra(Intent.EXTRA_TEXT);
      binding.jokeText.setText(joke);
    }
  }
}