package ahameds.com.sangatv12;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;


import android.app.AlertDialog;

import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager; //package for android hardware

import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
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
import android.hardware.SensorManager; //package for android hardware
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

   private DrawerLayout drawer;
   private LinearLayout linearLayout;
   private DatabaseHelper myDB;
   private Dialog myDialog;
           ActionBarDrawerToggle actionBarDrawerToggle;

    private SensorManager mSensorManager;
    private float accelVal;
    private float accelLast;
    private float shake;

   private ImageButton india,bd,pakistan,srilanka,maldives,nepal,bhutan;
   private ImageButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20; //Rooms



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ShakeDetector initialization
        mSensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(sensorListener,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        accelVal=SensorManager.GRAVITY_EARTH;
        accelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;

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


        r1 = (ImageButton) findViewById(R.id.room1);
        r2 = (ImageButton) findViewById(R.id.room2);
        r3 = (ImageButton) findViewById(R.id.room3);
        r4 = (ImageButton) findViewById(R.id.room4);
        r5 = (ImageButton) findViewById(R.id.room5);
        r6 = (ImageButton) findViewById(R.id.room6);
        r7 = (ImageButton) findViewById(R.id.room7);
        r8 = (ImageButton) findViewById(R.id.room8);
        r9 = (ImageButton) findViewById(R.id.room9);
        r10 = (ImageButton) findViewById(R.id.room10);
        r11 = (ImageButton) findViewById(R.id.room11);
        r12 = (ImageButton) findViewById(R.id.room12);
        r13 = (ImageButton) findViewById(R.id.room13);
        r14 = (ImageButton) findViewById(R.id.room14);
        r15 = (ImageButton) findViewById(R.id.room15);
        r16 = (ImageButton) findViewById(R.id.room16);
        r17 = (ImageButton) findViewById(R.id.room17);
        r18 = (ImageButton) findViewById(R.id.room18);
        r19 = (ImageButton) findViewById(R.id.room19);
        r20 = (ImageButton) findViewById(R.id.room20);





        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlert("Testing");

            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        r8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        r10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        r11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        r15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        r20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

























    }

    private final SensorEventListener sensorListener=new SensorEventListener(){

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];
            accelLast=accelVal;
            accelVal=(float) Math.sqrt((double)(x*x+y*y+z*z));
            float delta=accelVal-accelLast;
            shake=shake * 0.9f+delta;
            if(shake>8.00){
                System.out.println("Do not shake me");
                Toast toast=Toast.makeText(getApplicationContext(),"Madhuri from india\nAyesha from bangladesh\nhave been assigned in room 3",Toast.LENGTH_LONG);
                toast.show();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

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
                Boolean flag =myDB.insertData(fullname.getText().toString(),email.getText().toString(),phone.getText().toString(),n,city.getText().toString(),passport.getText().toString(),organization.getText().toString(),sponsorship.getText().toString(),age.getText().toString());
                if(flag==true){
                    Toast.makeText(MainActivity.this,"Added!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Not Added!!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        Cursor cur = myDB.getDataByCountry(nation);



        if(cur.getCount()==0){

            display.setText("No data found");

        }


        StringBuffer buffer = new StringBuffer();

        while(cur.moveToNext()){

            buffer.append("ID: "+cur.getString(0)+"\n");
            buffer.append("NAME: "+cur.getString(1)+"\n");
            buffer.append("CONTACT NUMBER: "+cur.getString(2)+"\n");
            buffer.append("EMAIL: "+cur.getString(3)+"\n");

        }


         display.setText(buffer.toString());

         display.setMovementMethod(new ScrollingMovementMethod());

//        StringBuffer buffer = new StringBuffer();
//
//        while(cur.moveToNext()){
//            buffer.append("ID: "+cur.getString(0)+"\n");
//            buffer.append("NAME: "+cur.getString(1)+"\n");
//            buffer.append("CONTACT NUMBER: "+cur.getString(2)+"\n");
//            buffer.append("EMAIL: "+cur.getString(3)+"\n");
//
//        }
//
//        display.setText(buffer.toString());
//
//        display.setMovementMethod(new ScrollingMovementMethod());


    }


    public void showAlert(String Data){//AlertBox
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
       // builder.setTitle(title);
         builder.setTitle(Html.fromHtml("<font color='#F9A44F'>Peoples</font>"));
        builder.setMessage(Data);
        builder.show();
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

