package com.example.firstemail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class enter_group_mail_class extends  MainActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.enter_group_mail_xml );
    }
    public void submit_group_mail_class(View view)
    {
        EditText email=findViewById( R.id.editTextTextPersonName2 );
        EditText group_mail=findViewById( R.id.editTextTextPersonName3 );
        String s=email.getText().toString();
        String s1=group_mail.getText().toString();
        Intent in5=new Intent( getApplicationContext(),send_group_mail_class.class );
        in5.putExtra( "email",s );
        in5.putExtra( "group_mail",s1 );
        startActivity( in5 );

    }



}
