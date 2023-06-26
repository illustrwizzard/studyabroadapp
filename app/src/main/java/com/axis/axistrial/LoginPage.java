package com.axis.axistrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.axistrial.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class LoginPage extends AppCompatActivity {
    String url_login="https://axisoverseascareers.in/api/student/Login";//done
    TextView forgotpassword_id;

    TextView newregister,signintextid;
    EditText username,password;
    int count;
    SQLDB sqldb;
    ProgressBar progressBarlogin;
    Button LoginButton;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN=100;

    // Construct a request for phone numbers and show the picker


    @Override
    public void onBackPressed() {

        finishAffinity();
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        sqldb=new SQLDB(this);
       // count=sqldb.count_UniversityDetails();
        sqldb=new SQLDB(this);
        sqldb.deleteStudentid();
        sqldb.deletetable();
        sqldb.deletetable_bookmark();

        SmsRetrieverClient client = SmsRetriever.getClient(this /* context */);

// Starts SmsRetriever, which waits for ONE matching SMS message until timeout
// (5 minutes). The matching SMS message will be sent via a Broadcast Intent with
// action SmsRetriever#SMS_RETRIEVED_ACTION.
        Task<Void> task = client.startSmsRetriever();

// Listen for success/failure of the start Task. If in a background thread, this
// can be made blocking using Tasks.await(task, [timeout]);
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.w("got the otp","yppp");
                // Successfully started retriever, expect broadcast intent
                // ...
            }
        });


        ////////////////////////////////////////////////////////////////////////////////////////////////
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        Intent extra=getIntent();
        if(extra.getStringExtra("signout")!=null){
            mGoogleSignInClient.signOut()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {


                        }
                    });


        }



        ////////////////////////////////////////////////////////////////////////////////////////////////////





        progressBarlogin=findViewById(R.id.progressBarlogin);
       // progressBarlogin.setBackgroundColor(R.color.white);
        signintextid=findViewById(R.id.signintextid);
        signintextid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);

            }
        });

        Intent ioi=getIntent();
        String toastmsg=ioi.getStringExtra("toastmessage");
        if (toastmsg!=null){
            Toast.makeText(this,toastmsg,Toast.LENGTH_SHORT).show();
        }




        newregister=findViewById(R.id.new_register_id);
        username=findViewById(R.id.usermail);
        password=findViewById(R.id.userpassword);
        forgotpassword_id=findViewById(R.id.forgotpassword_id);
        forgotpassword_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ti=new Intent(LoginPage.this,ChangePasswordInAccountPage0.class);
                startActivity(ti);
            }
        });

        newregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i=new Intent(LoginPage.this,SendOtp.class);
                startActivity(i);
            }
        });






        LoginButton=findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") & !password.getText().toString().equals("")){
                    progressBarlogin.setVisibility(View.VISIBLE);
                    Login();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Field Cannot Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });







        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
            }
            Intent i=new Intent(LoginPage.this,RegisterPage.class);
            startActivity(i);

            // Signed in successfully, show authenticated UI.
            // updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }



    public void Login() {


        StringRequest request=new StringRequest(Request.Method.POST, url_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {


                if(response.equals("login failed")){
                    {
                        progressBarlogin.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "wrong password or username", Toast.LENGTH_SHORT).show();
                        Log.w("GHGHJHGHJ",response);

                    }

                }else{

                    try {
                        JSONArray jsonArray=new JSONArray(response);
                        JSONObject jsonObject = jsonArray.getJSONObject(0);



                        if(sqldb.count_login()>0){
                            Intent i = new Intent(LoginPage.this,BottomNavEx.class);
                            startActivity(i);


                        }else{
                            sqldb.insert_StuReg(jsonObject.getString("name"),jsonObject.getJSONArray("student_profile").getJSONObject(0).getString("mobile"),jsonObject.getJSONArray("student_profile").getJSONObject(0).getString("dob"),jsonObject.getString("email"),jsonObject.getString("password"));
                            sqldb.insert_username(String.valueOf(username.getText()));
                            Intent i = new Intent(LoginPage.this,BottomNavEx.class);
                            startActivity(i);

                        }






                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }






            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBarlogin.setVisibility(View.INVISIBLE);

                Log.w("",error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("User_name", String.valueOf(username.getText()));
                map.put("Password", String.valueOf(password.getText()));
                return map;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }
}