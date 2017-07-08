package com.example.asmaa.dss_task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * Created by Asmaa on 01-May-17.
 */

public class Tab1_ForgetPass extends Fragment {
    EditText E1;
    EditText E2;
    EditText E3;
    EditText E4;
    Button update;
    String mail;

    String fname;
    String lname;
    Mydatabase_Sqlite mydatabaseSqlite;

    String newpass="";
    Boolean Checkfnam=false;
    Boolean Checklname=false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mydatabaseSqlite =new Mydatabase_Sqlite(getContext());


        View view = inflater.inflate(R.layout.tab1, container, false);
        E1 = (EditText)view.findViewById(R.id.nameview);
        E2 = (EditText) view.findViewById(R.id.passview);
        E3 = (EditText)view. findViewById(R.id.fnameviwe);
        E4 = (EditText)view. findViewById(R.id.lnameview);
        update = (Button) view.findViewById(R.id.save);
        mail  = getActivity().getIntent().getExtras().getString("email");

        E1.setText(mail);

        E1.setEnabled(false);
        E2.setEnabled(false);

//        lname = E4.getText().toString();
//        fname = E3.getText().toString();








        E3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    lname = E4.getText().toString();
                    fname = E3.getText().toString();
                    // code to execute when EditText loses focus
                    boolean check = mydatabaseSqlite.CheckPass(mail, fname, lname);

                    if (check == true) {
                        E2.setEnabled(true);
                        E3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.right,0);
                        E4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.right,0);

                        Checkfnam=true;

                    }
                    else {
                        E3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.wrong,0);

                    }
                }
            }
        });

        E4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    lname = E4.getText().toString();
                    fname = E3.getText().toString();
                    // code to execute when EditText loses focus
                    boolean check = mydatabaseSqlite.CheckPass(mail, fname, lname);

                    if (check == true) {
                        E2.setEnabled(true);
                        E4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.right,0);
                        E3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.right,0);

                        Checklname=true;

                    }
                    else {
                        E4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.wrong,0);

                    }
                }
            }
        });







        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(E2.getText().toString().length() < 0|| E3.getText().toString().length() < 0
                        ||  E4.getText().toString().length() < 0){
                    Toast.makeText(getContext(), "Complete Your Data", Toast.LENGTH_LONG).show();

                }
                else if (Checkfnam==true && Checklname==true) {
                    //newpass=E2.getText().toString();
                    mydatabaseSqlite.updatepass(E2.getText().toString(),mail);
                    Toast.makeText(getContext(), "Saved New Password", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getContext(), "Error in Your Data", Toast.LENGTH_LONG).show();

                }


            }
        });






        return view;
    }
}





//        E3.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//l
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                boolean check = mydatabaseSqlite.CheckPass(mail, fname, lname);
//                if (check == true) {
//                    E2.setEnabled(true);
//                  //  E3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.mm,0);
//                    Checkfnam=true;
//
//                }
//                else {
//                  //  E3.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ww,0);
//
//                }
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//
//            }
//        });






//        E3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if (lname.isEmpty() || fname.isEmpty()) {
//                    Toast.makeText(getContext(), "Complete Your Data", Toast.LENGTH_LONG).show();
//                } else {
//
//                    boolean check = mydatabaseSqlite.CheckPass(mail, fname, lname);
//                    if (check == oky) {
//                        E2.setFocusable(oky);
//                        Fnamecb.setChecked(oky);
//                        Lnamecb.setChecked(oky);
//                        newpass=E2.getText().toString();
//
//
//                    } else {
//                        Toast.makeText(getContext(), "YourData is Wrong , please try again", Toast.LENGTH_LONG).show();
//
//                    }
//
//
//                }
//            }
//        });





/////////////////////////////////////////////////////////////////////////////////////////////////


//
//        E4.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                boolean check = mydatabaseSqlite.CheckPass(mail, fname, lname);
//                if (check == true) {
//                    E2.setEnabled(true);
//                    E4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ww,0);
//                    Checklname=true;
//
//
//                }
//                else {
//                    E4.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.mm,0);
//                }
//
//            }
//        });


//E3.addTextChangedListener(new TextWatcher() {
//
//public void onTextChanged(CharSequence s, int start, int before,
//        int count) {
//
//
//
//        }
//
//public void beforeTextChanged(CharSequence s, int start, int count,
//        int after) {
//
//        }
//
//public void afterTextChanged(Editable s) {
//        if(!s.equals("") )
//        {
//
//        }
//
//        }
//        });

