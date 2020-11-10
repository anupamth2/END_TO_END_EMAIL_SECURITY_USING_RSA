package com.example.firstemail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class enter_recieved_mail_class  extends MainActivity{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.enter_recieved_mail_xml );

    }
    //this function take the user email input and check in registered main
    // database and call a intent to registered user class
    public void check_mail_call_next(View view)
    {
        EditText e1=findViewById( R.id.editTextTextPersonName );
        final String se=e1.getText().toString();
        final Intent in=new Intent(this,recieve_mail_class.class);
        if(se.length()==0)
            return;
        DocumentReference docRef = db.collection("Registered Mail").document(se);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Toast.makeText( getApplicationContext(),"successful email found",Toast.LENGTH_LONG ).show();
                        String s11=se;
                        String der=document.getString("PUBLIC KEY");
                        int ddr=Integer.parseInt( der );
                        in.putExtra( "PUBLIC KEY",ddr );
                        in.putExtra( "EMAIL",se );
                        Toast.makeText( getApplicationContext(),"public key = "+ddr ,Toast.LENGTH_LONG).show();
                        startActivity( in );

                    } else {
                        /*
                        v
                         v
                         Log.d(TAG, "No such document");
                        */
                        Toast.makeText( getApplicationContext(),"no such email",Toast.LENGTH_LONG ).show();
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                    Toast.makeText( getApplicationContext(),"failed connection",Toast.LENGTH_LONG ).show();
                }
            }
        });



    }
}
