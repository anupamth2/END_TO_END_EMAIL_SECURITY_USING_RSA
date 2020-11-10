package com.example.firstemail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.example.firstemail.R.layout.new_user_xml;

public class New1_user_class extends MainActivity  {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( new_user_xml );

    }
    public void register_user(View view)
    {

        TextView t1=findViewById( R.id.e1 );
        String s1=t1.getText().toString();
        try {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            if (s1.length() == 0)
                return;
            CollectionReference s11 = db.collection( "Registered Mail" );
            Map<String, Object> data1 = new HashMap<>();
            Random rand=new Random();

            int rand_int = rand.nextInt(3);
            int[] x={17,13,13,47};
            rand_int=x[rand_int];

            String rt=Integer.toString( rand_int );
            data1.put( "PUBLIC KEY", rt );
            s11.document( s1 ).set( data1 );
            Toast.makeText( this,"your email is registed",Toast.LENGTH_LONG ).show();


        }catch (Exception e)
        {
            Toast.makeText( this,"fail to register",Toast.LENGTH_LONG ).show();

        }

        try{
            Intent in1=new Intent( getApplicationContext(),MainActivity.class );
            startActivity( in1 );
        }catch(Exception e)
        {
            Toast.makeText( this,"main activity started ",Toast.LENGTH_LONG ).show();

        }
        //CollectionReference cities = db.collection("cities");

        /*Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
        cities.document("SF").set(data1);*/

    }


}

