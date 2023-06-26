package com.axis.axistrial;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.auth.PhoneAuthCredential;

public class Setedt extends Thread{
    EditText otp0,otp1,otp2,otp3,otp4,otp5;
    PhoneAuthCredential credential;
    Context context;
    String smsget;

    public Setedt(EditText otp0, EditText otp1, EditText otp2, EditText otp3, EditText otp4, EditText otp5, PhoneAuthCredential credential, String smsget, Context context) {
        this.otp0 = otp0;
        this.otp1 = otp1;
        this.otp2 = otp2;
        this.otp3 = otp3;
        this.otp4 = otp4;
        this.otp5 = otp5;
        this.credential = credential;
        this.smsget = smsget;
        this.context=context;
    }

    @Override
    public void run() {
        super.run();


        smsget=credential.getSmsCode();
        Log.w("hhhhhhhh",smsget);


        // Sign in success, update UI with the signed-in user's information

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



    }
}
