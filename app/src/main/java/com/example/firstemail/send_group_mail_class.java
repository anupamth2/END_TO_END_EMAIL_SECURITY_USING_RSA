package com.example.firstemail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class send_group_mail_class extends MainActivity {
    ArrayList<String> array=new ArrayList<String>(  );
    ArrayList<String> key_array=new ArrayList<String>(  );
    ArrayList<String> array2=new ArrayList<String>(  );
    ArrayList<String> array3=new ArrayList<String>(  );
    int private_key=23;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    int no;
    String sr="";
    Map m1= new HashMap(  );


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.send_group_mail_xml );
        m1.put(17,19);
        m1.put(29,31);
        m1.put( 13,23 );
        m1.put( 47,53 );
        Intent in=getIntent();
        String s=in.getStringExtra( "email" );
        sr=s;
        String s1=in.getStringExtra( "group_mail" );
        add_mail_to_array(s1);
        TextView t13=findViewById( R.id.textView12 );
        //Toast.makeText( getApplicationContext(),"the size of s1 "+array.get( 1 ),Toast.LENGTH_LONG ).show();
        int i,j,k;
    // add_public_key_of_mail_to_array( array.get( 0 ) );
        int n=array.size();
        no=n;
        for(i=0;i< array.size();i++) {
            add_public_key_of_mail_to_array( array.get( i ) );
            //add_public_key_of_mail_to_array( array.get( 1 ) );
        }
        EditText t1=findViewById( R.id.editTextTextPersonName4 );
        //String s2=t1.getText().toString();
        //t13.setText( s2 );
        //add_public_key_from_edit_text_to_array(s2);
        //Toast.makeText( getApplicationContext(),"the size of s1 "+key_array.size(),Toast.LENGTH_LONG ).show();








    }
    // here our start after button is clidkefd
    public void check_fun_working(View view)
    {

        EditText t6=findViewById( R.id.editTextTextPersonName4 );
        String s6=t6.getText().toString();
        // here an error is identified the error is public key not belong to mail
        add_public_key_from_edit_text_to_array( s6 );
        EditText e1=findViewById( R.id.editTextTextPersonName5 );
        String s=e1.getText().toString();
        int i,j,k;
        for(i=0;i<no;i++)
        {
           // TextView t1239=findViewById( R.id.textView12 );
            EditText t1239=findViewById( R.id.editTextTextPersonName7 );
            t1239.append( array3.get( i ) );
            t1239.append( " " );
            t1239.append( s );
            t1239.append(" " );

            t1239.append( array2.get( i ) );
            t1239.append( "\n" );
            String s16=encrypt_email_text(array3.get( i ),array2.get( i ),s);
        }


        //Toast.makeText( getApplicationContext(),"the size is "+array.size(),Toast.LENGTH_LONG ).show();
    }

    private String encrypt_email_text(String s, String s1, String s2) {
        int i,j,k;
        String s4="";
        int pub=Integer.parseInt( s1 );
        for(i=0;i<s2.length();i++)
        {
            int k1=(int)(s2.charAt( i ));
            int k3221=(int)(m1.get( pub ));
            k1=encrypt_the_text( k1,k3221,pub );

            k1=k1+11000;
            s4+=k1;

        }
        EditText r2=findViewById( R.id.editTextTextPersonName6 );
        r2.append( s4 );
        add_in_firebase_email_section(s,s4);
        return  s4;


    }

    private void add_in_firebase_email_section(String s, String s4) {
        HashMap<String,String> hash=new HashMap<String, String>(  );
        hash.put( sr,s4 );
        CollectionReference cities = db.collection(s);
        Random rand=new Random(  );
        int k4=rand.nextInt(1000);
        String s6="received "+k4;
        cities.document(s6).set(hash);


    }


    private void add_public_key_from_edit_text_to_array(String s2) {
        if(s2.length()==0)
        {
            Toast.makeText( getApplicationContext(),"XXXXXXXXXX",Toast.LENGTH_LONG ).show();
            return;}

        int i,j;
        String s4="";
        TextView t1=findViewById( R.id.textView12 );
        //t1.setText( s2 +" fddf ");

        for(i=0;i<s2.length();i++)
        {
            if(s2.charAt( i )=='/')
            {
                t1=findViewById( R.id.textView12 );
               // array.add( s4 );
                array2.add(s4);
                t1.append( s2 );
                s4="";
            }
            else
                s4+=s2.charAt( i );

        }
        s4="";
        EditText r4=(EditText)findViewById( R.id.editTextTextPersonName7 );
        String s11=r4.getText().toString();
        if(s11.length()==0)
            return;
        for(i=0;i<s11.length();i++)
        {
            if(s11.charAt( i )=='/')
            {
                array3.add( s4 );
                s4="";
            }
            else
                s4+=s11.charAt( i );
        }

        Toast.makeText( getApplicationContext(),"suncd "+array.size(),Toast.LENGTH_LONG ).show();
        //array.add(s4);
    }

    private void add_public_key_of_mail_to_array(final String s7) {
        DocumentReference docRef = db.collection("Registered Mail").document(s7);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        String s43= document.getString( "PUBLIC KEY" );
                        //key_array.add(s43);

                        EditText t13=findViewById( R.id.editTextTextPersonName4 );
                        t13.append( s43+"/" );
                        EditText t89=findViewById( R.id.editTextTextPersonName7 );
                        t89.append(s7+"/");
                    } else {
                       // Log.d(TAG, "No such document");
                        Toast.makeText( getApplicationContext(),"no such email",Toast.LENGTH_LONG ).show();
                        EditText t13=findViewById( R.id.editTextTextPersonName4 );
                        t13.append( "no such email" );
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                    Toast.makeText( getApplicationContext(),"connection failed",Toast.LENGTH_LONG ).show();
                }
            }
        });

    }

    private void add_mail_to_array(String s1) {
        String s3="";
        int i,j;
        for(i=0;i<s1.length();i++)
        {
            if(s1.charAt( i )==',')
            {
                array.add( s3 );
                s3="";

            }
            else
                s3+=s1.charAt( i );


        }
        array.add( s3 );
    }
    public static int encrypt_the_text(int msg1,int se,int se2)
    {
        Scanner sc=new Scanner(System.in);
        int p,q,n,z,d=0,e,i;
        System.out.println("Enter the number to be encrypted and decrypted");
        int msg=msg1;
        double c;
        BigInteger msgback;
        System.out.println("Enter 1st prime number p");
        p=se;
        System.out.println("Enter 2nd prime number q");
        q=se2;

        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("the value of z = "+z);

        for(e=2;e<z;e++)
        {
            if(gcd(e,z)==1)            // e is for public key exponent
            {
                break;
            }
        }
        System.out.println("the value of e = "+e);
        for(i=0;i<=9;i++)
        {
            int x=1+(i*z);
            if(x%e==0)      //d is for private key exponent
            {
                d=x/e;
                break;
            }
        }
        System.out.println("the value of d = "+d);
        c=(Math.pow(msg,e))%n;
        System.out.println("Encrypted message is : -");
        System.out.println(c);
        int k43=(int)c;
        //converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
        //converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Derypted message is : -");
        System.out.println(msgback);
        return k43;

    }
    static int gcd(int e, int z)
    {
        if(e==0)
            return z;
        else
            return gcd(z%e,e);
    }

}
