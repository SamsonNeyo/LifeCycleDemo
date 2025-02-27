package com.example.lifecycledemo1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private MainViewModel viewModel;
    private TextView lifecycleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate() called");

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        lifecycleTextView = findViewById(R.id.lifecycleTextView);
        MaterialButton buttonGoBack = findViewById(R.id.buttonGoBack);

        viewModel.getLifecycleMessage().observe(this, lifecycleTextView::setText);

        buttonGoBack.setOnClickListener(v -> {
            viewModel.updateLifecycleMessage("SecondActivity Paused, Returning to MainActivity");
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
        viewModel.updateLifecycleMessage("SecondActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
        viewModel.updateLifecycleMessage("SecondActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
        viewModel.updateLifecycleMessage("SecondActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
        viewModel.updateLifecycleMessage("SecondActivity: onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
        viewModel.updateLifecycleMessage("SecondActivity: onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
        viewModel.updateLifecycleMessage("SecondActivity: onDestroy()");
    }
}
