package com.example.diku.upload;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;




/**
 * Created by Diku on 19-05-2017.
 */

public class StartActivity extends AppCompatActivity {

    String password2;
    TextView login;
    EditText password;
    ImageView rightarrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellcome);

        login =(TextView)findViewById(R.id.login);
        password=(EditText)findViewById(R.id.password);
        rightarrow=(ImageView)findViewById(R.id.rightarrow);
        password.setVisibility(View.GONE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login.setVisibility(View.GONE);
                password.setVisibility(View.VISIBLE);
                rightarrow.setVisibility(View.VISIBLE);
                password.setTransformationMethod(new AsteriskPasswordTransformationMethod());



            }
        });


        rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password2 =password.getText().toString();
                if(password2.equals("hellolina"))
                {
                    Intent i= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                else {

                    Snackbar.make(v, ""+password2, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


    }


    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }
            public char charAt(int index) {
                return '*'; // This is the important part
            }
            public int length() {
                return mSource.length(); // Return default
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    };
}
