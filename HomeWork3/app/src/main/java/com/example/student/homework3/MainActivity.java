package com.example.student.homework3;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_DIALOG = "key";
    private ImageButton runTask;
    private EditText editText;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setDialog();
    }


    public void findView() {
        runTask = findViewById(R.id.start_button);
        editText = findViewById(R.id.edit_text);
    }

    private void setDialog() {
        runTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_DIALOG, editText.getText().toString());
                MyDialog progressDialogFragment = new MyDialog();
                progressDialogFragment.setArguments(bundle);
                progressDialogFragment.show(getSupportFragmentManager(), "key");

            }
        });
    }
}
