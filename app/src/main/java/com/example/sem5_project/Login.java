package com.example.sem5_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sem5_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {
    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputEditText username, password;
    FirebaseAuth mAuth;

//    SharedPreferences sp;
@Override
public void onStart() {
    super.onStart();
    FirebaseUser currentUser = mAuth.getCurrentUser();
    if(currentUser!=null){
        Intent i=new Intent(getApplicationContext(),Home.class);
        startActivity(i);
        finish();
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //This Line will hide the status bar from the screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //Hooks
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);
        mAuth=FirebaseAuth.getInstance();
//        DbHelper DB=new DbHelper(this);
//        sp = getSharedPreferences("login",MODE_PRIVATE);

//        if(sp.contains("username") && sp.contains("password")){
//            startActivity(new Intent(this,Home.class));
//        }

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(sloganText, "logo_desc");
                pairs[3] = new Pair<View, String>(username, "username_tran");
                pairs[4] = new Pair<View, String>(password, "password_tran");
                pairs[5] = new Pair<View, String>(login_btn, "button_tran");
                pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");
                startActivity(intent);
            }
        });
//        login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user=username.getText().toString();
//                String pass=password.getText().toString();
//                if(user.equals("")||pass.equals("")){
//                    Toast.makeText(Login.this,"please enter all the details",Toast.LENGTH_SHORT).show();
//
//                }
//                else{
//                    Boolean checkuserpass=DB.checkusername(user,pass);
//                    if(checkuserpass==true){
//                        Toast.makeText(Login.this,"login successfull",Toast.LENGTH_SHORT).show();
//                        SharedPreferences.Editor edit = sp.edit();
//                        edit.putString("username",user);
//                        edit.putString("password",pass);
//                        edit.commit();
//                        Intent intent = new Intent(Login.this,Home.class);
//                        startActivity(intent);
//                    }
//                    else{
//                        Toast.makeText(Login.this,"not valid enter correct or sign up",Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            }
//        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=username.getText().toString();
                String pass=password.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(Login.this,Home.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });

    }
}