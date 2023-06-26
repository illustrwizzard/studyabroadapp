package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.axistrial.R;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordInAccountPage0 extends AppCompatActivity {

    EditText edttxt1;
    String getnewmail;
    String url_reset="https://axisoverseascareers.in/api/password/forgotpassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_in_account_page0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        edttxt1=findViewById(R.id.edttxt1);

    }

    public void GotoChangePass(View view) {

        ResetPassword();
        Intent i = new Intent(ChangePasswordInAccountPage0.this,LoginPage.class);
        i.putExtra("toastmessage","Check Your mail");
        startActivity(i);
    }

    private void ResetPassword() {


        StringRequest request=new StringRequest(Request.Method.POST, url_reset, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                if(response.equals("success")){
                    Log.w("GHGHJHGHJ",response);



                }else{
                    Log.w("ioiioooiioi",response);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.w("",error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("New_mail", String.valueOf(edttxt1.getText()));
                return map;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }
}