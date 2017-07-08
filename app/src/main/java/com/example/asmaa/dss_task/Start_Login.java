package com.example.asmaa.dss_task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Start_Login extends AppCompatActivity {
    EditText Email;
    EditText Pass;
    Button Login;
    TextView fg;
    TextView Count;
    //static String mail ="m";

    String Em;
    String Ps;
    Mydatabase_Sqlite database = new Mydatabase_Sqlite(Start_Login.this);
    int Time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = (EditText) findViewById(R.id.Eamil);
        Pass = (EditText) findViewById(R.id.pass);
        Login = (Button) findViewById(R.id.login);
        fg=(TextView)findViewById(R.id.forget);
        Count=(TextView)findViewById(R.id.times);




        Users_Data user = new Users_Data("asmaa@yahoo.com", "1234","asmaa","moawad");


        database.insert(user);


        fg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//forget


                Em = Email.getText().toString();
                if(Em.isEmpty()){
                    Toast.makeText(Start_Login.this,"Enter Your Email Please",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent= new Intent(Start_Login.this,HomePage.class);
                    intent.putExtra("email",Em);
                    intent.putExtra("is_login",false);
                    startActivity(intent);

                }



        }
    }

    );







    Login.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){//login
        Ps = Pass.getText().toString();
        Em = Email.getText().toString();

        Mydatabase_Sqlite mydatabaseSqlite = new Mydatabase_Sqlite(Start_Login.this);

        boolean x = mydatabaseSqlite.login(Em, Ps);
            if(Ps.isEmpty() || Em.isEmpty() ) {
                Toast.makeText(Start_Login.this,"Complete Your Data ",Toast.LENGTH_LONG).show();

            }
            else {
                if (x == true) {
                    Toast.makeText(Start_Login.this, "welcome  ", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Start_Login.this,HomePage.class);
                    intent.putExtra("email",Em);
                    intent.putExtra("is_login",true);

                    startActivity(intent);

                } else if (x == false && Time != 3) {


                    Toast.makeText(Start_Login.this, "Please Try Again", Toast.LENGTH_SHORT).show();
                    Time++;
                    Count.setText(String.valueOf(Time));
                } else {

                    finish();
                }

            }



    }
    }

    );

}


}






