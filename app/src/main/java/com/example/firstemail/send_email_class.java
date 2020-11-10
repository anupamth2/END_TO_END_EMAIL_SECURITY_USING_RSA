package com.example.firstemail;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class send_email_class extends MainActivity{
    int k=0;
    String s15,s16;
    int private_key=23;
    Map m1= new HashMap(  );
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.send_email_xml );
        int kd=encrypt_the_text( 56,13,23 );
        m1.put(17,19);
        m1.put(29,31);
        m1.put( 13,23 );
        m1.put( 47,53 );
        Toast.makeText( getApplicationContext(),"the kd is "+kd,Toast.LENGTH_SHORT ).show();
    }
    //this section check that is the email is register in our database
    public void check_email(View view)
    {
        EditText e11=findViewById( R.id.email2 );
        String s11=e11.getText().toString();
        s15=s11;
      //  String s1235=encrypt_text122( "hello h i is " );

        final String[] s12 = new String[1];
        final TextView t5=findViewById( R.id.t5 );
        final EditText t123=findViewById( R.id.e123 );


 //this sagment in registered maill section is mail is registered to firebase
        DocumentReference docRef = db.collection("Registered Mail").document(s11);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {


            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //00(TAG, "DocumentSnapshot data: " + document.getData());
                        s12[0] =document.getData().toString();

                        //from here we are extracting key from s12[0
                        int i,j;
                        String ke1="";
                        for(i=0;i<s12[0].length();i++)
                        {
                            if(i!=s12[0].length()-1)
                            ke1=ke1+s12[0].charAt( i );


                            if(s12[0].charAt( i )=='=')
                                ke1="";



                        }
                        Toast.makeText(getApplicationContext(),ke1,Toast.LENGTH_LONG ).show();

                        //till here we extracting key from s12[0]
                        int kk=Integer.parseInt( ke1 );


                        t123.setText( "paste or enter your email text here" );
                        k=kk;



                    } else {
                        Toast.makeText( getApplicationContext(),"no such email ",Toast.LENGTH_LONG ).show();
                       //og.d(TAG, "No such document");

                        t5.setText( "ask your friend to download the app and register" );
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });








    }



    //this funcition does two things it goes in database and
    //in recieved section ofreciever add the given email with sender email
    //in sender section of sender it adds reciever mail and send content
    public void send_ecrypted_mail(View view)
    {
        /*try{
            EditText t24=findViewById( R.id.edit91 );
            s16=t24.getText().toString();
            if(s16.length()==0)
                return;
            EditText e123=findViewById( R.id.e123 );
            String s=e123.getText().toString();
            final TextView t5=findViewById( R.id.t5 );
            t5.setText(s);
            //here a mail is send from s16 to s15



        //it should be encrypted before sending
            //s=encrypt_text122(s);
            int k3=k;
            String enc="";
            int e4=Character.getNumericValue('v');
            int a,b;
            for(a=0;a<s.length();a++)
            {
                int ae=Character.getNumericValue( s.charAt( a ));
                ae=ae+900;
                ae=ae+1;

            }
            s=enc;
            CollectionReference s11 = db.collection( s15 );


        Map<String, Object> data1 = new HashMap<>();

        data1.put( s16, s );
        Random rand=new Random( );
        int re=rand.nextInt(100);
        String recieve="RECEIVED"+re;
        s11.document( recieve ).set( data1 );
        Toast.makeText( this,"your email is sent as "+enc,Toast.LENGTH_LONG ).show();




    }catch (Exception e)
    {
        Toast.makeText( this,"fail to sent email",Toast.LENGTH_LONG ).show();

    }*/
        EditText t24=findViewById( R.id.edit91 );
        s16=t24.getText().toString();
        EditText e123=findViewById( R.id.e123 );
        String s;
        s=e123.getText().toString();

        t24.setText( s );
        Toast.makeText( getApplicationContext(),"we have reached here ",Toast.LENGTH_LONG ).show();
        String s233="";
        int k12=k;
        int i,j;
        //here we have started encryption

        for(i=0;i<s.length();i++)
        {
            //int kk1=Character.getNumericValue( s.charAt( i ) );
            int kk1=(int)(s.charAt( i ));
            int ker=(int)(m1.get( k ));
            kk1=encrypt_the_text( kk1,ker,k );
            kk1=kk1+11000;
            s233=s233+kk1;

        }
        //here we have done encryption and result is stord in no in s233
        t24.setText( s233 );
        Toast.makeText( getApplicationContext(),"this is text "+s233,Toast.LENGTH_LONG ).show();

        CollectionReference s1123=db.collection( s15 );
        Map<String,Object> data2=new HashMap<>(  );
        data2.put(s16,s233);
        Random ren=new Random(  );
        int rew=ren.nextInt(100);
        String sent1="";
        sent1="recieved"+rew;

        s1123.document(sent1).set(data2);






        try{
            CollectionReference s112=db.collection( s16 );
            //EditText e123=findViewById( R.id.e123 );
            s=e123.getText().toString();
            Map<String,Object> data1=new HashMap<>( );
            data1.put(s15,s233);
            Random rand = new Random();
            int re=rand.nextInt(100);
            String sent="SENT"+re;

           // s112.document(sent).set(data1);
          //  Toast.makeText( this,"added to sent folder s15 "+s15+" s16 "+s16,Toast.LENGTH_LONG ).show();




        }catch (Exception e)
        {
            Toast.makeText( this,"unable to add"+s15+"  "+s16,Toast.LENGTH_LONG ).show();
        }


    }
    //here a mail is sent from s16 to s15;
    public String encrypt_text122(String s) {
        try {
            if(s.length()==0)
                return "no error";


            final String[] s123 = new String[1];
            final String s35 = "99";
            Toast.makeText( this, "we have called  ", Toast.LENGTH_LONG ).show();
            if (s15.length() == 0)
                return "empty string";


            DocumentReference docRef = db.collection( "Registered Mail" ).document( "abc123" );
            docRef.get().addOnCompleteListener( new OnCompleteListener<DocumentSnapshot>() {


                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            //00(TAG, "DocumentSnapshot data: " + document.getData());

                            s123[0] = document.getData().toString();
                            // Toast.makeText(getApplicationContext(),"the public of sender is "+s12[0],Toast.LENGTH_LONG ).show();

                            //t123.setText( "paste or enter your email text here" );
                            //k=1;


                        } else {
                            Toast.makeText( getApplicationContext(), "no such email ", Toast.LENGTH_LONG ).show();
                            //og.d(TAG, "No such document");

                            //t5.setText( "ask your friend to download the app and register" );
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),"here is the errot",Toast.LENGTH_LONG ).show();
                        //Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            } );
            //we can start your encryption proecess
            //we have collected data of public key in s12[0] as public key=no
            //return the encrypted string;
            EditText e123 = findViewById( R.id.e123 );
            String s543 = e123.getText().toString();
            int i, j = 0;
            String s56 = "";

            for (i = 0; i < s123[0].length(); i++) {
                if (s123[0].charAt( i ) == '=')
                    j = 1;

                if (j != 0) {
                    i = i + 1;
                    if (i < s123[0].length())
                        s56 = s56 + s123[0].charAt( i );

                }


            }
            Toast.makeText( this, "we have getsting as " + s56, Toast.LENGTH_LONG ).show();
            e123.setText( "we havve ddoen " );

        }catch (Exception e)
        {
            Toast.makeText( getApplicationContext(),"we got some error",Toast.LENGTH_LONG ).show();
        }


        return "he we are checking";

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
