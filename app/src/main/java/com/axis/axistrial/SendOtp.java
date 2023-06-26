package com.axis.axistrial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.axistrial.R;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendOtp extends AppCompatActivity {

    PhoneAuthProvider.ForceResendingToken mResendToken;
    String otpgetnumber,mobilenumber;
    String mVerificationId,smsget;
    boolean flag=true;
    TextView t1,t2;
    Button getotpbutton, verifybutton;
    PhoneAuthCredential Credential, credential2;
    LinearLayout linearLayout1, linearLayout2;
    EditText e1,otp0,otp1,otp2,otp3,otp4,otp5;
    CountryCodePicker countryCodepicker_id;
    String country_code,country_selected;
    Boolean countryselected=false;
    private static final int REQ_USER_CONSENT = 200;
    SmsBroadcastReceiver smsBroadcastReceiver;

    private FirebaseAuth mAuth;



    public void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            flag=false;

                            for (int i=0;i<=6;i++){
                                switch (i){
                                    case 0:
                                        otp0.setText(smsget.substring(0,1));
                                        break;

                                    case 1:
                                        otp1.setText(smsget.substring(1,2));
                                        break;


                                    case 2:
                                        otp2.setText(smsget.substring(2,3));
                                        break;


                                    case 3:
                                        otp3.setText(smsget.substring(3,4));
                                        break;


                                    case 4:
                                        otp4.setText(smsget.substring(4,5));
                                        break;


                                    case 5:
                                        otp5.setText(smsget.substring(5));
                                        break;
                                }


                            }


                            // Update UI
                        } else {
//

                        }
                    }
                });
    }

    public void signInWithPhoneAuthCredentialVerify(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent i = new Intent(getApplicationContext(),RegisterPage.class);
                            i.putExtra("mobile_number",mobilenumber);
                            Log.w("",mobilenumber);
                            startActivity(i);

                            // Update UI
                        } else {
                            LayoutInflater li = getLayoutInflater();
                            //Getting the View object as defined in the customtoast.xml file
                            View layout = li.inflate(R.layout.toast_message,(ViewGroup) findViewById(R.id.custom_toast_layout));
                            //Creating the Toast object
                            Toast toast = new Toast(getApplicationContext());
                            toast.setDuration(Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.setView(layout);//setting the view of custom toast layout
                            toast.show();

                        }
                    }
                });
    }


    private void initiateotp(String otpgetnumber){
        String countrycodeget = null;
        if (countryselected){
            countrycodeget=country_selected;
        }else{
            countrycodeget=country_code;
        }

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+"+countrycodeget+otpgetnumber)       // Phone number to verify
                        .setTimeout(0l, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                credential2=phoneAuthCredential;
                               // signInWithPhoneAuthCredential(phoneAuthCredential);
                               // smsget=phoneAuthCredential.getSmsCode();

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                // The SMS verification code has been sent to the provided phone number, we
                                // now need to ask the user to enter the code and then construct a credential
                                // by combining the code with a verification ID.
                                Log.d("yo", "onCodeSent:" + verificationId);
                                // Save verification ID and resending token so we can use them later
                                mVerificationId = verificationId;
                                Log.w("ssssssssss",mVerificationId);
                               mResendToken = token;
                            }



                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);



    }
    class mov extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent i = new Intent(getApplicationContext(),RegisterPage.class);
            i.putExtra("mobile_number",mobilenumber);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_send);
        mAuth = FirebaseAuth.getInstance();
        t1=findViewById(R.id.textview_otpget_id);
        t2=findViewById(R.id.textview_mobilenumber);
        getotpbutton=findViewById(R.id.cirLoginButtoninOtppage);
        linearLayout1=findViewById(R.id.layout_entering_number);
        linearLayout2=findViewById(R.id.layout_entering_otp);
        e1=findViewById(R.id.edittext_entering_number);
        otp0=findViewById(R.id.edittext_entering_otp);


        otp1=findViewById(R.id.edittext_entering_otp1);
        otp2=findViewById(R.id.edittext_entering_otp2);
        otp3=findViewById(R.id.edittext_entering_otp3);
        otp4=findViewById(R.id.edittext_entering_otp4);
        otp5=findViewById(R.id.edittext_entering_otp5);


        otp0.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (otp0.getText().length()==1)
                {
                    // Perform action on Enter key press
                    otp0.clearFocus();
                    otp1.requestFocus();
                    return true;
                }
                return false;
            }
        });


        otp1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (otp1.getText().length()==1)
                {
                    // Perform action on Enter key press
                    otp1.clearFocus();
                    otp2.requestFocus();
                    return true;
                }
                return false;
            }
        });



        otp2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (otp2.getText().length()==1)
                {
                    // Perform action on Enter key press
                    otp2.clearFocus();
                    otp3.requestFocus();
                    return true;
                }
                return false;
            }
        });


        otp3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (otp3.getText().length()==1)
                {
                    // Perform action on Enter key press
                    otp3.clearFocus();
                    otp4.requestFocus();
                    return true;
                }
                return false;
            }
        });

        otp4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (otp4.getText().length()==1)
                {
                    // Perform action on Enter key press
                    otp4.clearFocus();
                    otp5.requestFocus();
                    return true;
                }
                return false;
            }
        });





        countryCodepicker_id=findViewById(R.id.countryCodepicker_id);



        startSmartUserConsent();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }

        countryCodepicker_id.setDefaultCountryUsingNameCode("India");
        country_code=countryCodepicker_id.getDefaultCountryCode();
        countryCodepicker_id.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                countryselected=true;

                country_selected=countryCodepicker_id.getSelectedCountryCode();
                Log.w("ffffffffffff",country_code);

            }
        });




        verifybutton=findViewById(R.id.verifyButton);
        getotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().length()!=10||e1.getText().length()<1 ){
                    Toast.makeText(getApplicationContext(), "Enter your mobile number", Toast.LENGTH_SHORT).show();
                }
                else {
                    getotpbutton.setVisibility(Button.GONE);
                    t1.setText("Enter the otp send to "+e1.getText());
                    mobilenumber=e1.getText().toString();
                    otpgetnumber= String.valueOf(e1.getText());
                    initiateotp(otpgetnumber);
                    t2.setText("Enter your otp");
                    linearLayout1.setVisibility(LinearLayout.GONE);
                     linearLayout2.setVisibility(LinearLayout.VISIBLE  );
                    verifybutton.setVisibility(View.VISIBLE);

                }


            }
        });

        verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!otp0.getText().toString().isEmpty()&&!otp1.getText().toString().isEmpty()&&!otp2.getText().toString().isEmpty()&&!otp3.getText().toString().isEmpty()&&!otp4.getText().toString().isEmpty()&&!otp5.getText().toString().isEmpty()&&flag) {


                    Credential = PhoneAuthProvider.getCredential(mVerificationId, otp0.getText().toString() + otp1.getText().toString() + otp2.getText().toString()
                            + otp3.getText().toString() + otp4.getText().toString() + otp5.getText().toString());


                    signInWithPhoneAuthCredentialVerify(Credential);
                }
              Credential=null;

            }
        });

    }
    private void startSmartUserConsent() {

        SmsRetrieverClient client = SmsRetriever.getClient(this);
        client.startSmsUserConsent(null);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_USER_CONSENT){

            if ((resultCode == RESULT_OK) && (data != null)){

                String message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
                Log.w("messageee",message);
                getOtpFromMessage(message);


            }


        }

    }

    private void getOtpFromMessage(String message) {

        Pattern otpPattern = Pattern.compile("(|^)\\d{6}");
        Matcher matcher = otpPattern.matcher(message);
        if (matcher.find()){
String otpnum;
            otpnum=matcher.group(0);
            for (int i=0;i<=6;i++){
                switch (i){
                    case 0:
                        otp0.setText(otpnum.substring(0,1));
                        break;

                    case 1:
                        otp1.setText(otpnum.substring(1,2));
                        break;


                    case 2:
                        otp2.setText(otpnum.substring(2,3));
                        break;


                    case 3:
                        otp3.setText(otpnum.substring(3,4));
                        break;


                    case 4:
                        otp4.setText(otpnum.substring(4,5));
                        break;


                    case 5:
                        otp5.setText(otpnum.substring(5));
                        break;
                }


            }
//            signInWithPhoneAuthCredentialVerify();
            //etOTP.setText(matcher.group(0));
            Log.w("my otp ",matcher.group(0));

        }


    }

    private void registerBroadcastReceiver(){

        smsBroadcastReceiver = new SmsBroadcastReceiver();

        smsBroadcastReceiver.smsBroadcastReceiverListener = new SmsBroadcastReceiver.SmsBroadcastReceiverListener() {
            @Override
            public void onSuccess(Intent intent) {

                startActivityForResult(intent,REQ_USER_CONSENT);

            }

            @Override
            public void onFailure() {

            }
        };

        IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
        registerReceiver(smsBroadcastReceiver,intentFilter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerBroadcastReceiver();

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(smsBroadcastReceiver);
    }







}