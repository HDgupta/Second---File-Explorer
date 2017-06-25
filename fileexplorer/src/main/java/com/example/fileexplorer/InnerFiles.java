package com.example.fileexplorer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InnerFiles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_files);

        loadFrag(R.id.constantFrame,ListShowFrag.getInstance());
    }

    private void loadFrag(int fragid, Fragment frag){

        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction  txn = manager.beginTransaction();

        txn.replace(fragid,frag);
        txn.commit();

    }
}
