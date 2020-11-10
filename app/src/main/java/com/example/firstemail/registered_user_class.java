package com.example.firstemail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registered_user_class extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registered_user );





    }
    public void send_email(View view)
    {
        Intent in5=new Intent( getApplicationContext(),send_email_class.class);
        startActivity( in5 );

    }
    public  void recieve_mail(View view)
    {
        Intent in6 = new Intent( getApplicationContext(),enter_recieved_mail_class.class);
        startActivity( in6 );
    }
    public void start_group_mail_class(View view)
    {
        Intent in7=new Intent( getApplicationContext(),enter_group_mail_class.class );
        startActivity( in7 );
    }
}
