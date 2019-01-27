package com.coderunners.auto2fa_authenticator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private Button authenticate;
    private DatabaseReference mDatabase;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authenticate = (Button) findViewById(R.id.authenticate);
        message = (EditText) findViewById(R.id.message);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String msg = message.getText().toString().trim();
                mDatabase.child("Name").setValue(msg);

            }
        });
    }
}
