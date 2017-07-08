package com.example.asmaa.dss_task;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Asmaa on 01-May-17.
 */

public class Tab2_Courses extends Fragment {
    ListView ls;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tab2, container, false);
        final View Dialog= inflater.inflate(R.layout.dialog, container, false);

        final String[] myIntArray = {"CS","IS","IA","Ns","DSS"};
        ls=(ListView)view.findViewById(R.id.lst);

        final ArrayAdapter adapter = new ArrayAdapter(getContext(),R.layout.listview, myIntArray);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                LayoutInflater dialogInflater1 = ((Activity)getContext()).getLayoutInflater();
                View alertView = dialogInflater1.inflate(R.layout.dialog,null);
                builder1.setView(alertView);
                builder1.setTitle("Rigister Your Courses");
                //builder1.setCancelable(false);


                final EditText text = (EditText)alertView.findViewById(R.id.courseedit);
                final Button update=(Button)alertView.findViewById(R.id.updatecourse);
                Button cancel=(Button)alertView.findViewById(R.id.cancelcourse);


                final  AlertDialog ad =  builder1.show();

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newcourse=text.getText().toString();
                        if(newcourse.isEmpty()){
                            Toast.makeText(getContext(), "Enter Name Course", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            myIntArray[position] = newcourse;
                            adapter.notifyDataSetChanged();
                            ad.dismiss();
                        }

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Canceled", Toast.LENGTH_SHORT).show();
                        ad.dismiss();


                    }
                });



            }
        });


        return view;
    }

}
