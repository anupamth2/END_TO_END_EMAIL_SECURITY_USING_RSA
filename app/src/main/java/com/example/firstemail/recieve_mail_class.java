package com.example.firstemail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class recieve_mail_class extends MainActivity {
    Map m1= new HashMap(  );

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String[] s12;
                int k=0;
                int private_key=23;
                Map<String,Object> hmap;
                ArrayList<String> array =new ArrayList<String>(  );
                int key12;





                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate( savedInstanceState );
                    setContentView( R.layout.recieve_mail_xml );
                    m1.put(17,19);
                    m1.put(29,31);
                    m1.put( 13,23 );
                    m1.put( 47,53 );
                    final EditText e19 = findViewById( R.id.edit1 );
                    // here we are receive the intent result like email and public key
                    Intent in1=getIntent();
                    final int public_key=in1.getIntExtra( "PUBLIC KEY",34322 );
                    key12=public_key;
                    final String sys=in1.getStringExtra( "EMAIL" );
                    String s = e19.getText().toString();
                    if (s == "")
                        return;

                    try {

                        final String[] s5 = new String[1];
                        // this function is collecting all the recieve mails and and store
                        // in the string s344 and then all those are appended to t345 edit text
                        Task<QuerySnapshot> cities = db.collection( sys )
                                .get()
                                .addOnCompleteListener( new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                //Log.d( TAG, document.getId() + " => " + document.getData() );
                                                 String s344 = document.getData().toString();
                                                 EditText t345=findViewById( R.id.edit_text );
                                                //Enumeration<String> keys= (Enumeration<String>) document.getData().keySet();
                                              //  while(keys.hasMoreElements())
                                              //      t345.append( keys.nextElement() );
                                                TextView tr2=findViewById( R.id.textView5 );
                                                hmap=document.getData();

                                                Set<String> keys=document.getData().keySet();
                                                //h1map=document.getData();

                                                Iterator<String> itr=keys.iterator();
                                                while(itr.hasNext())
                                                {
                                                    tr2.append(itr.next());

                                                    //String hrea= itr.next();




                                                }
                                                 t345.append( s344 );


                                                Toast.makeText( getApplicationContext(), s344, Toast.LENGTH_SHORT ).show();



                                            }
                                        } else {
                                            //Log.d( TAG, "Error getting documents: ", task.getException() );
                                            Toast.makeText( getApplicationContext(), "there is an error ", Toast.LENGTH_LONG ).show();
                                        }
                                    }


                                } );
                        // here we are trying to decrypt the key and getting public keys



                    }catch (Exception e)
                    {
                        Toast.makeText( getApplicationContext(),"we catched an error ", Toast.LENGTH_LONG).show();
                    }
                    //hmap_function();


                }
            // the hmap create and ilitrate through the map
                public void hmap_function() {
                    String ser="";
                    for (Map.Entry<String, Object> me : hmap.entrySet()) {
                        //System.out.print(me.getKey() + ":");
                        ser += me.getKey();
                       // System.out.println(me.getValue());
                        ser += (me.getValue()).toString();
                        //Toast.makeText( getApplicationContext(),ser,Toast.LENGTH_LONG ).show();
                    }
                }

                public void classify_recieved_mail(View view) {
                    // this function is going to manupulate the recieve string in the edit text box
                    // we are getting the editext value in string s3432 we  are two loop to get the first
                    //email address and its value
                    //k44 store intial and k45 store final value
                    //we are adding all this to a string st12
                    // st12 is further break into email and encrypted text
                    // then we are calling afunction that will recieve public key from the email for furhter decryption


                    EditText e390 = findViewById( R.id.edit_text );
                    String s3432 = e390.getText().toString();

                    String get = s3432;
                    int k44 = 0;
                    int k45 = 1;
                    int j;
                    int cont=0;


                        while (k44 < get.length()) {
                            k44++;
                            if (get.charAt( k44 ) == '{')
                                break;
                        }

                        while (k45 < get.length()) {
                            k45++;
                            cont++;
                            if (get.charAt( k45 ) == '}')
                                break;
                        }
                        k45--;
                        String st12 = "";
                        for (int i = k44; i < k45; i++)
                            st12 += get.charAt( i );

                        int k435 = 0;
                        String st15 = "";
                        while (k435 < st12.length()) {
                            k435++;
                            if (st12.charAt( k435 ) == '=')
                                break;
                            st15 += st12.charAt( k435 );

                        }
                        // TextView er1=findViewById( R.id.set_text );
                        //er1.setText( st15 );
                 /*   st15="";
                    while(k435<st12.length())
                    {
                        st15=st15+st12.charAt( k435 );
                    }*/
                        //   er1.setText( st15 );
                        //  Toast.makeText(getApplicationContext(),st15,Toast.LENGTH_SHORT ).show();
                        //we don't need a function to retutn a public as all the text  is encrypted using
                        // the reciver key so we do not need this function at this time but still
                        String st16 = return_public_key_of_email( "abcxyz" );
                        String s433 = "";
                        k435++;
                        while (k435 < st12.length()) {
                            s433 += st12.charAt( k435 );
                            k435++;
                        }
                        Toast.makeText( getApplicationContext(), "the is " + cont, Toast.LENGTH_LONG ).show();
                        // s433 has stored the string that need to be dencrypted
                        int ln = 0;
                        int cnt1 = 0;
                        String s1294 = "";
                        while (ln < s433.length()) {

                            if (ln % 5 == 0) {
                                EditText ter = findViewById( R.id.edit1 );
                                //int ke3=Integer.parseInt( s1294 );
                                //int ke4=Integer.parseInt( st16 );
                                //ke3=ke3-ke4;
                                // int ke3=Integer.parseInt( s1294 );
                                // int ke3=Integer.getInteger( s1294 );



                                ter.append( s1294 );
                                ter.append( "  " );
                                s1294 = "";

                            }

                            s1294 += s433.charAt( ln );
                            ln++;
                        }



                    EditText ed43=findViewById(R.id.edit1 );
                    TextView tr34=findViewById( R.id.text5 );
                    String s431d=ed43.getText().toString();
                    tr34.append( Integer.toString( s431d.length() )  );
                }


                private String return_public_key_of_email(String st15) {
                    final String s32510;

                    DocumentReference docRef = db.collection("Registered Mail").document(st15);
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    //Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                                    String st124=document.getString( "PUBLIC KEY" ).toString();
                                    Toast.makeText( getApplicationContext(),st124,Toast.LENGTH_LONG ).show();
                                    TextView text5=findViewById( R.id.text5 );
                                    text5.setText( st124 );

                                } else {
                                    Toast.makeText( getApplicationContext(),"no such email ",Toast.LENGTH_LONG ).show();
                                }
                            } else {
                                Toast.makeText( getApplicationContext(),"get failed ",Toast.LENGTH_LONG ).show();
                                //Log.d(TAG, "get failed with ", task.getException());
                            }
                        }
                    });
                    return "enjoy your life";

                }


                private String return_decrypt_text(String get, int k44, int k45) {
                    TextView t145=findViewById( R.id.edit1 );
                    int i;
                    String r88="";
                    t145.append(Integer.toString( k44 ));
                    t145.append(" ");
                    t145.append( Integer.toString( k45 ) );

                    for(i=k44;i<k45;i++)
                    {
                        r88=r88+get.charAt( i );

                    }
                    t145.append( r88 );
                    return "srer ";

                }


                public void final_string_function(View view)
                {// this string will call on clicking button this will manupulate the string
                    // here we are doing string manupulation and store the result in array
                    // the result are stored in format index =0 email id index =1 encrypted t

                    EditText t3412=findViewById( R.id.edit_text );
                    String s=t3412.getText().toString();

                    String s1="";
                    int i,j,k;
                    i=0;

                    //removing the name part
                    while(i<s.length())
                    {
                        s1+=s.charAt( i );
                        i++;


                    }
                    i=0;
                    String s3="";
                    String s4="";
                    String s5="";


                    while(i<s1.length())
                    {
                        if(s1.charAt( i )=='{')
                        {
                            s3="";
                            s4="";
                        }
                        else if(s1.charAt(i)=='}')
                        {
                            array.add(s3);
                            EditText t34=findViewById( R.id.edit1 );
                            t34.append( s3 +" - ");
                            s3="";
                        }
                        else if(s1.charAt( i )=='=')
                        {
                            array.add(s3);
                            TextView t13=findViewById( R.id.textView5 );
                            EditText t24=findViewById( R.id.edit1 );
                            t24.append( s3+" " );
                            t13.append( s3+" : " );


                            s3="";
                            s4="";

                        }
                        else
                            s3+=s1.charAt( i );
                        i++;

                    }
                    Toast.makeText(getApplicationContext(),"we have reched here "+array.size(),Toast.LENGTH_LONG ).show();

                    String s4303=return_int_of_string("54322/--");
                    int k3532=Integer.parseInt( s4303 );

                        Toast.makeText( getApplicationContext(), "we have recieved string as " + s4303, Toast.LENGTH_LONG ).show();
                        //return_decrypt_email(0,1);
                        //return_decrypt_email( 2,3 );
                        for(int kd=0;kd+1<array.size();kd=kd+2)
                        {
                            return_decrypt_email( kd,kd+1 );
                        }



                }
                // this function take a b as input and then go to string array take the value of email and
                //encrypted text decrypt the mail and appeed to a text view

                public void return_decrypt_email(int a,int b) {
                    try {
                        String sw = array.get( b );
                        int kk;
                        String ss = "";
                        String sw44 = "";
                        //from here we are deviding the string into 5 digit no and subtracting with public key
                        for (kk = 0; kk < sw.length(); kk++) {
                            ss = ss + sw.charAt( kk );

                            if ((kk + 1) % 5 == 0) {
                                // here we are decrypting the text

                                ss = return_int_of_string( ss );
                                int k431 = Integer.parseInt( ss );
                                k431 = k431 - 11000;
                                int k12353=(int)(m1.get( key12 ));
                                k431=dencrypt_the_text(k431,k12353,key12);


                                //char s4848= Character.forDigit(  )
                                // char s4848 = Character.forDigit( k431, 10 );

                                //Toast.makeText( getApplicationContext(), "eee " + s4848, Toast.LENGTH_LONG ).show();
                                try {


                                    sw44 += (char) k431;
                                }catch (Exception e)
                                {
                                    Toast.makeText( getApplicationContext(),"char is error ",Toast.LENGTH_LONG ).show();

                                }


                                ss = "";


                            }
                        }
                        TextView text5 = findViewById( R.id.textView6 );
                        text5.append( array.get( a ) + ":" + sw44 +"\n");

                    } catch (Exception e) {
                        Toast.makeText( getApplicationContext(), "there is an error ", Toast.LENGTH_LONG ).show();

                    }
                }
                // this function return only those string that conatins only no like "455-55" this will r
                //retunr 45555 as a string
                public  String return_int_of_string(String s43) {
                    int i, j, k;
                    String d2 = "";
                    for (i = 0; i < s43.length(); i++) {
                        switch (s43.charAt( i )) {
                            case '1':
                                d2 += '1';
                                break;
                            case '2':
                                d2 += '2';
                                break;
                            case '3':
                                d2 += '3';
                                break;
                            case '4':
                                d2 += '4';
                                break;
                            case '5':
                                d2 += '5';
                                break;
                            case '6':
                                d2 += '6';
                                break;
                            case '7':
                                d2 += '7';
                                break;
                            case '8':
                                d2 += '8';
                                break;
                            case '9':
                                d2 += '9';
                                break;
                            case '0':
                                d2 += '0';
                                break;


                        }
                    }
                        return d2;
                    }

    public static int dencrypt_the_text(int msg1,int se,int se2)
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
        c=msg1;

        //converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
        //converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Derypted message is : -");
        System.out.println(msgback);
        int k43=msgback.intValue();
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
