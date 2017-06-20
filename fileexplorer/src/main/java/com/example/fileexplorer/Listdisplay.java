package com.example.fileexplorer;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Listdisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdisplay);
        LoadList();
    }

    private void LoadList() {

       //File file = Environment.getExternalStoragePublicDirectory("");
        File file = getExternalFilesDir("");
        List<MyFileitems> fileitem = new ArrayList<>();
        File[] files = file.listFiles();

        for(File fl : files){
            fileitem.add(new MyFileitems(fl.getName(),fl.length()+"",fl.lastModified()+"",(fl.isDirectory() ? R.drawable.ic_folder_black_24dp : R.drawable.ic_insert_drive_file_black_24dp)));
        }
        ((ListView)findViewById(R.id.fileList)).setAdapter(new MyListViewAdapter(this,fileitem));
    }
}
