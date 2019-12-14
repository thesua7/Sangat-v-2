package ahameds.com.sangatv12;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

   private DrawerLayout drawer;
   private LinearLayout linearLayout;
   private DatabaseHelper myDB;
   private Dialog myDialog;
           ActionBarDrawerToggle actionBarDrawerToggle;

   private ImageButton india,bd,pakistan,srilanka,maldives,nepal,bhutan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDialog = new Dialog(this);//Declaring Dialog
        myDB = new DatabaseHelper(this);//DB OBJECT



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        linearLayout = (LinearLayout) findViewById(R.id.line1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:

                        Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

        india = (ImageButton) findViewById(R.id.indiajar);
        bd = (ImageButton) findViewById(R.id.bdjar);
        pakistan =(ImageButton) findViewById(R.id.pakistanjar);
        maldives = (ImageButton) findViewById(R.id.maldivesjar);
        nepal = (ImageButton) findViewById(R.id.nepaljar);
        srilanka = (ImageButton) findViewById(R.id.srilanka);
        bhutan = (ImageButton) findViewById(R.id.bhutanjar);


        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "India" ;
                ShowPopup(v,nation);
            }
        });

        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "Bangladesh" ;
                ShowPopup(v,nation);
            }
        });

        pakistan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "Pakistan" ;
                ShowPopup(v,nation);
            }
        });

        maldives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "Maldives" ;
                ShowPopup(v,nation);
            }
        });

        srilanka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "Sri-lanka" ;
                ShowPopup(v,nation);
            }
        });

        nepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "Nepal" ;
                ShowPopup(v,nation);
            }
        });

        bhutan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"OKOKOKOKOKOKOW!!",Toast.LENGTH_SHORT).show();
                String nation = "Bhutan" ;
                ShowPopup(v,nation);
            }
        });





    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }


    protected void ShowPopup(View v,String nation){

        final TextView display,exit;
        final EditText fullname,phone,email,passport,organization,sponsorship,age,city;
        Button add;



        myDialog.setContentView(R.layout.custompopup);

        final String n = nation;

        exit = (TextView) myDialog.findViewById(R.id.exitbtn);

        display =(TextView) myDialog.findViewById(R.id.toshow);

        fullname =(EditText) myDialog.findViewById(R.id.name);
        phone = (EditText) myDialog.findViewById(R.id.contact);
        email = (EditText) myDialog.findViewById(R.id.email);
        passport = (EditText) myDialog.findViewById(R.id.passport);
        city = (EditText) myDialog.findViewById(R.id.city);
        organization = (EditText) myDialog.findViewById(R.id.orgnz);
        sponsorship = (EditText) myDialog.findViewById(R.id.sponser);
        age = (EditText) myDialog.findViewById((R.id.age));
        add = (Button) myDialog.findViewById(R.id.adduserbtn);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });


          myDialog.show();

//          String s = "ok";
//          display.setText(s);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag =myDB.insertData(fullname.getText().toString(),email.getText().toString(),phone.getText().toString(),n,city.getText().toString(),passport.getText().toString(),organization.getText().toString(),sponsorship.getText().toString());
                if(flag==true){
                    display.setText("Added");
                }
                else{
                    display.setText("Not Added");//FOR TESTING
                }
            }
        });






    }


}

//    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull MenuItem menuItem){
//
//        switch (menuItem.getItemId()){
//
//            case R.id.home:
//                Toast.makeText(MainActivity.this,"Home is selected",Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.history:
//                Toast.makeText(MainActivity.this,"History is selected",Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.help:
//                Toast.makeText(MainActivity.this,"Help is selected",Toast.LENGTH_SHORT).show();
//                break;
//
//
//
//        }
//
//
//
//
//        return false;
//    }

