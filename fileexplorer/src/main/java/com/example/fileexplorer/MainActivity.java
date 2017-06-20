package com.example.fileexplorer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNext(View view){
        ProgressDialog dialog = new ProgressDialog(this);
                dialog.setMessage("Loading..");
                dialog.setTitle("Inprogress");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();

        startActivity(new Intent(this,Main2Activity.class));

    }

}
