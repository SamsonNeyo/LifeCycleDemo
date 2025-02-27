package com.example.lifecycledemo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainViewModel viewModel;
    private TextView lifecycleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called");

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        lifecycleTextView = findViewById(R.id.lifecycleTextView);
        MaterialButton buttonGoToSecond = findViewById(R.id.buttonGoToSecond);

        // Observe ViewModel message updates
        viewModel.getLifecycleMessage().observe(this, lifecycleTextView::setText);

        buttonGoToSecond.setOnClickListener(v -> {
            viewModel.updateLifecycleMessage("MainActivity Paused, Moving to SecondActivity");
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
        viewModel.updateLifecycleMessage("MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
        viewModel.updateLifecycleMessage("MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
        viewModel.updateLifecycleMessage("MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
        viewModel.updateLifecycleMessage("MainActivity: onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
        viewModel.updateLifecycleMessage("MainActivity: onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
        viewModel.updateLifecycleMessage("MainActivity: onDestroy()");
    }
}
