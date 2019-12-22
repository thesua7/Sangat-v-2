package ahameds.com.sangatv12;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Context;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager; //package for android hardware

import android.app.Dialog;
import android.os.Bundle;
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
                Boolean flag =myDB.insertData(fullname.getText().toString(),email.getText().toString(),phone.getText().toString(),n,city.getText().toString(),passport.getText().toString(),organization.getText().toString(),sponsorship.getText().toString());
                if(flag==true){
                    Toast.makeText(MainActivity.this,"Added!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Not Added!!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        Cursor cur = myDB.getAllData();

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

