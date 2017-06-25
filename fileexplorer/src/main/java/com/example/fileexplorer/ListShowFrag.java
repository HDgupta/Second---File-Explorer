package com.example.fileexplorer;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListShowFrag extends Fragment{

    public ListShowFrag() {
        // Required empty public constructor
    }

    public static ListShowFrag getInstance(){
        ListShowFrag listShowFrag = new ListShowFrag();
        return listShowFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_show, container, false);
        showList(rootView);
        return rootView;
    }

    private void showList(View rootView) {
        Intent responsibleintent = getActivity().getIntent();
        Bundle bundle = responsibleintent.getExtras();
        String name = bundle.getString("KeyStr");

        Log.i("@@@@",name);
        File file = Environment.getExternalStoragePublicDirectory(name);
        List<MyFileitems> filelist = new ArrayList<>();
        File []files = file.listFiles();
        Log.i("@@@@","list "+file.listFiles().length);

        for (File file1:files) {
            Log.i("@@@@", file1.getName());
        }

        for (File fl: files)
            filelist.add(new MyFileitems(fl.getName(),fl.length()+"",fl.lastModified()+"",(fl.isDirectory() ? R.drawable.ic_folder_black_24dp : R.drawable.ic_insert_drive_file_black_24dp)));

        ((ListView)rootView.findViewById(R.id.lstInner)).setAdapter(new MyListViewAdapter(getContext(),filelist));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
