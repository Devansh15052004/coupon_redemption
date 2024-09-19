package com.example.sem5_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        TextInputEditText regName=findViewById(R.id.name);
        TextInputEditText regUsername=findViewById(R.id.username);
        TextInputEditText regEmail=findViewById(R.id.email);
        TextInputEditText regPhoneNo=findViewById(R.id.phoneNo);
        TextInputEditText regPassword=findViewById(R.id.password);
        Button signup=findViewById(R.id.GO);
//        DbHelper DB=new DbHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=regName.getText().toString();
                String username=regUsername.getText().toString();
                String email=regEmail.getText().toString();
                String PhoneNo=regPhoneNo.getText().toString();
                String password=regPassword.getText().toString();
//                if(username.equals("")||name.equals("")||password.equals("")||email.equals("")||password.equals("")){
//                    Toast.makeText(SignUp.this,"please enter all the details",Toast.LENGTH_SHORT).show();
//                }
//
//                else{
//                    Boolean checkuser=DB.checkusername(name,password);
//                    if(checkuser==false){
//                        Boolean insert=DB.insertData(username,name,password,email,PhoneNo);
//                        if(insert==true){
//                            Toast.makeText(getApplicationContext(),"register successfully,please login now",Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(SignUp.this,Login.class);
//                            startActivity(intent);
//                        }
//
//                        else{
//                            Toast.makeText(SignUp.this,"register failed",Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                    else{
//                        Toast.makeText(SignUp.this,"user already exist",Toast.LENGTH_SHORT).show();
//
//                    }
//                }
                mAuth=FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                   Toast.makeText(SignUp.this,"Account created",Toast.LENGTH_SHORT).show();


                                   Intent i=new Intent(SignUp.this,Login.class);
                                   startActivity(i);
                                   finish();
                                } else {
                                    Toast.makeText(SignUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

}