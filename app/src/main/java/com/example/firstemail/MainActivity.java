package com.example.firstemail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("a new path ")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText( getApplicationContext(),"successed ",Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                       // Log.w(TAG, "Error adding document", e);
                        Toast.makeText( getApplicationContext(),"failed ",Toast.LENGTH_LONG ).show();


                    }
                });
    }
    public void new_user(View view)
    {



        this.view = view;
        Toast.makeText(getApplicationContext(),"you have clicked newser",Toast.LENGTH_LONG ).show();
        Intent in = new Intent( getApplicationContext(),New1_user_class.class);
        startActivity( in );

    }
    public void registered_user(View view)
    {
        Intent in2= new Intent(getApplicationContext(),registered_user_class.class);
        startActivity( in2 );

    }
}