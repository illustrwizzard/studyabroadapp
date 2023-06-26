package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.axistrial.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UploadFilesInGetAdmission extends AppCompatActivity {
    String url="https://app.axisjobs.in/api/student/fetch";
    String encodedimage,u;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,
            img13,img14,img15,img16,img17,img18,img19,img20;
    int btnid;
    private int PICK_PDF_REQUEST = 1;
    Uri filePath;
    ArrayList<String>arrayList1,arrayList2;
    ArrayList<Uri>filepathA;
    ArrayList<Integer>ids;
    ImageView backtoApplication;
    ArrayList<ApplicationDetailsDataClass>arrayList;
    String university_name,intake_month,intake_year,intake_mail,course_name;
    TextView university_getname,course_getname,intake_getid;
    TextView name_in_up,mail_in_uo,mob_in_up,dob_in_up;
    SQLDB sqldb;
    boolean flag=true;
    ArrayList<StudentDetails>arrayListstudent;
    CourseSendTask courseSendTask;
    Button uploadButton;





    public String getStringPdf (Uri filepath){
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream =  getContentResolver().openInputStream(filepath);

            byte[] buffer = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        byte[] pdfByteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(pdfByteArray, Base64.DEFAULT);
    }


    private void showFileChooser(View view) {
        Log.w("","entered showfile");
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PICK_PDF_REQUEST);
        btnid=view.getId();
        ids.add(btnid);





    }


    public void encodeimg(Bitmap bit){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] byteofimages=byteArrayOutputStream.toByteArray();
        encodedimage=android.util.Base64.encodeToString(byteofimages, Base64.DEFAULT);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int ff = btnid;

        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            switch (ff){
                case R.id.appli_img:
                    Drawable res = getResources().getDrawable(R.drawable.check11);
                    img1.setImageDrawable(res);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.passport_img:
                    Drawable res1 = getResources().getDrawable(R.drawable.check11);
                    img2.setImageDrawable(res1);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.ten_img:
                    Drawable res2 = getResources().getDrawable(R.drawable.check11);
                    img3.setImageDrawable(res2);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.eleven_img:
                    Drawable res3 = getResources().getDrawable(R.drawable.check11);
                    img4.setImageDrawable(res3);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.degree_inv_mark_img:
                    Drawable res4 = getResources().getDrawable(R.drawable.check11);
                    img5.setImageDrawable(res4);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.degree_con_mark_img:
                    Drawable res5 = getResources().getDrawable(R.drawable.check11);
                    img6.setImageDrawable(res5);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.degree_certi_pro_certi_img:
                    Drawable res7 = getResources().getDrawable(R.drawable.check11);
                    img7.setImageDrawable(res7);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.refff_letter_img:
                    Drawable res8 = getResources().getDrawable(R.drawable.check11);
                    img8.setImageDrawable(res8);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.refff_letter2_img:
                    Drawable res9 = getResources().getDrawable(R.drawable.check11);
                    img9.setImageDrawable(res9);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.stmt_purpose_img:
                    Drawable res10 = getResources().getDrawable(R.drawable.check11);
                    img10.setImageDrawable(res10);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.ilts_img:
                    Drawable res11 = getResources().getDrawable(R.drawable.check11);
                    img11.setImageDrawable(res11);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.toefl_img:
                    Drawable res12 = getResources().getDrawable(R.drawable.check11);
                    img12.setImageDrawable(res12);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.cv_img:
                    Drawable res13 = getResources().getDrawable(R.drawable.check11);
                    img13.setImageDrawable(res13);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.appli_fee_recept_img:
                    Drawable res14 = getResources().getDrawable(R.drawable.check11);
                    img14.setImageDrawable(res14);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.birth_certificate_img:
                    Drawable res15 = getResources().getDrawable(R.drawable.check11);
                    img15.setImageDrawable(res15);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.other_certi_img:
                    Drawable res16 = getResources().getDrawable(R.drawable.check11);
                    img16.setImageDrawable(res16);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.visa_rejection_img:
                    Drawable res17 = getResources().getDrawable(R.drawable.check11);
                    img17.setImageDrawable(res17);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.ref_letter_img:
                    Drawable res18 = getResources().getDrawable(R.drawable.check11);
                    img18.setImageDrawable(res18);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.fin_avidence_proof_img:
                    Drawable res19 = getResources().getDrawable(R.drawable.check11);
                    img19.setImageDrawable(res19);
                    filepathA.add(filePath = data.getData());
                    break;
                case R.id.experenece_certi_img:
                    Drawable res20 = getResources().getDrawable(R.drawable.check11);
                    img20.setImageDrawable(res20);
                    filepathA.add(filePath = data.getData());
                    break;


            }
            Log.w("yooooooooo","enteredddddd");


        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_files_in_getadmission);



        ids=new ArrayList<>();
        filepathA=new ArrayList<>();
        img1= (ImageView) findViewById(R.id.appli_img);
        img2= (ImageView) findViewById(R.id.passport_img);
        img3= (ImageView) findViewById(R.id.ten_img);
        img4= (ImageView) findViewById(R.id.eleven_img);
        img5= (ImageView) findViewById(R.id.degree_inv_mark_img);
        img6= (ImageView) findViewById(R.id.degree_con_mark_img);
        img7= (ImageView) findViewById(R.id.degree_certi_pro_certi_img);
        img8= (ImageView) findViewById(R.id.refff_letter_img);
        img9= (ImageView) findViewById(R.id.refff_letter2_img);
        img10= (ImageView) findViewById(R.id.stmt_purpose_img);
        img11= (ImageView) findViewById(R.id.ilts_img);
        img12= (ImageView) findViewById(R.id.toefl_img);
        img13= (ImageView) findViewById(R.id.cv_img);
        img14= (ImageView) findViewById(R.id.appli_fee_recept_img);
        img15= (ImageView) findViewById(R.id.birth_certificate_img);
        img16= (ImageView) findViewById(R.id.other_certi_img);
        img17= (ImageView) findViewById(R.id.visa_rejection_img);
        img18= (ImageView) findViewById(R.id.ref_letter_img);
        img19= (ImageView) findViewById(R.id.fin_avidence_proof_img);
        img20= (ImageView) findViewById(R.id.experenece_certi_img);
        name_in_up=findViewById(R.id.name_in_up);
        mail_in_uo=findViewById(R.id.mail_in_up);
        mob_in_up=findViewById(R.id.mob_in_up);
        dob_in_up=findViewById(R.id.dob_in_up);
        arrayList=new ArrayList<>();
        sqldb=new SQLDB(this);
        arrayListstudent=new ArrayList<>();

        arrayListstudent=sqldb.getStudent_details();
        name_in_up.setText(arrayListstudent.get(0).getName());
        mail_in_uo.setText(arrayListstudent.get(0).getEmail());
        mob_in_up.setText(arrayListstudent.get(0).getMob());
        dob_in_up.setText(arrayListstudent.get(0).getDob());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }



        //String university_name,intake_month,intake_year,intake_mail;
        Intent extra=getIntent();
        course_name=extra.getStringExtra("course_name");
        university_name=extra.getStringExtra("university_intake");
        intake_month=extra.getStringExtra("intake_month");
        intake_year=extra.getStringExtra("intake_year");
        intake_mail=extra.getStringExtra("intake_mail");
        arrayList= extra.getParcelableArrayListExtra("arraylist");



        university_getname=findViewById(R.id.university_name_getid);
        course_getname=findViewById(R.id.course_name_getid);
        intake_getid=findViewById(R.id.intakemonth_getid);
        university_getname.setText(university_name);
        course_getname.setText(course_name);
        intake_getid.setText(intake_month);

        uploadButton=findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploaddetailsbutton();
            }
        });



        backtoApplication=findViewById(R.id.backtoApplication);
        backtoApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           finish();
            }
        });

    }

    public void uploaddetailsbutton() {

//        Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                //Toast.makeText(getApplicationContext(),"FileUploaded Successfully", Toast.LENGTH_SHORT).show();



                Log.w("",response);
//                Intent inb=new Intent(UploadFilesInGetAdmission.this,InsideCourseSection.class);
//                startActivity(inb);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                Log.w("",error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();



                for(int i =0;i<ids.size();i++) {
                    switch (ids.get(i)) {
                        case R.id.appli_img:
                            map.put("application", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.passport_img:
                            map.put("passport", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.ten_img:
                            map.put("ten_mark", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.eleven_img:
                            map.put("twelve_mark", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.degree_inv_mark_img:
                            map.put("degree_invi_mark", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.degree_con_mark_img:
                            map.put("degree_con_mark", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.degree_certi_pro_certi_img:
                            map.put("degree_certi_provisional_certi", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.refff_letter_img:
                            map.put("reff_letter1", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.refff_letter2_img:
                            map.put("reff_letter2", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.stmt_purpose_img:
                            map.put("stmnt_of_purpose", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.ilts_img:
                            map.put("ielts", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.toefl_img:
                            map.put("toefl", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.cv_img:
                            map.put("cv", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.appli_fee_recept_img:
                            map.put("appli_fee_recept", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.birth_certificate_img:
                            map.put("birth_certi", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.other_certi_img:
                            map.put("tution_fee", getStringPdf(filepathA.get(i)));
                            break;
                        case R.id.visa_rejection_img:
                            map.put("visa_rejection", getStringPdf(filepathA.get(i)));
                            break;
                        case R.id.ref_letter_img:
                            map.put("reff_letter3", getStringPdf(filepathA.get(i)));
                            break;
                        case R.id.fin_avidence_proof_img:
                            map.put("financial_evd", getStringPdf(filepathA.get(i)));

                            break;
                        case R.id.experenece_certi_img:
                            map.put("experience_certi", getStringPdf(filepathA.get(i)));
                            break;


                    }






                }





                map.put("user_name",arrayListstudent.get(0).getEmail());
                map.put("DOB",arrayListstudent.get(0).getDob());




                return map;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

        //Context context,  String email, String phone_no, String uname, String DOB, String university_name, String course_name, String intake, String name, String qualification, String mark_obtained, String mark_percentage, String IELTS_mark, String TEOEFL_mark, String communication_medium, String communication, String passport_number, String maritial_status, String visa_rejected) {
        courseSendTask=new CourseSendTask(this,arrayListstudent.get(0).getEmail(),arrayListstudent.get(0).getMob(),arrayListstudent.get(0).getEmail(),arrayListstudent.get(0).getDob(),university_name,course_name,intake_month,arrayListstudent.get(0).getName(),arrayList.get(0).getQualification(),arrayList.get(0).getMarkObt(),arrayList.get(0).getMarkPercent(),arrayList.get(0).getIELTSmark(),arrayList.get(0).getTOEFLmark(),arrayList.get(0).getComm_medium(),arrayList.get(0).getComm_id(),arrayList.get(0).getPassportNumber(),arrayList.get(0).getMartialStatus(),arrayList.get(0).getVisaReject());

            courseSendTask.execute();
    }

    public void Upload_Application(View view) {
        showFileChooser(view);


    }

    public void Upload_passportcpy(View view) {
        showFileChooser(view);

    }

    public void Upload_10mark(View view) {
        showFileChooser(view);

    }

    public void Upload_12mark(View view) {
        showFileChooser(view);

    }

    public void Upload_D_individual_mlist(View view) {
        showFileChooser(view);

    }

    public void Upload_d_consolidate_marklist(View view) {
        showFileChooser(view);

    }

    public void Upload_D_certfi_provision_certfi(View view) {
        showFileChooser(view);

    }

    public void Upload_reff_letter(View view) {
        showFileChooser(view);

    }

    public void Upload_reff_letter2(View view) {
        showFileChooser(view);

    }

    public void Upload_stemt_purpose(View view) {
        showFileChooser(view);

    }

    public void Upload_ILTS_score(View view) {
        showFileChooser(view);

    }

    public void Upload_TOEFL_score(View view) {
        showFileChooser(view);


    }

    public void Upload_cv(View view) {
        showFileChooser(view);

    }

    public void Upload_appli_fee_recept(View view) {
        showFileChooser(view);

    }

    public void Upload_birth_certi(View view) {
        showFileChooser(view);

    }

    public void Upload_Other_certi_ifany(View view) {
        showFileChooser(view);

    }

    public void Upload_visa_rejection_letter(View view) {
        showFileChooser(view);

    }

    public void Upload_reff_letter_for_some(View view) {
        showFileChooser(view);

    }

    public void Upload_financial_evidence_proof(View view) {
        showFileChooser(view);

    }

    public void Upload_experience_certificate(View view) {
        showFileChooser(view);

    }



}