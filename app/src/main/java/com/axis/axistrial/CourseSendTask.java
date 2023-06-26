package com.axis.axistrial;

import static javax.mail.Transport.send;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CourseSendTask extends AsyncTask<Void,Void,Void> {

    private Context context;
    private Session session;


    //Information to send email
    private String email;
    private String phone_no;
    private String Uname;
    private  String DOB;
    String University_name, Course_name, Intake,
     name, Qualification, mark_obtained, Mark_percentage, IELTS_mark
    , TEOEFL_mark, communication_medium,communication,passport_number, maritial_status, visa_rejected;

    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;

    public CourseSendTask(Context context,  String email, String phone_no, String uname, String DOB, String university_name, String course_name, String intake, String name, String qualification, String mark_obtained, String mark_percentage, String IELTS_mark, String TEOEFL_mark, String communication_medium, String communication, String passport_number, String maritial_status, String visa_rejected) {
        this.context = context;
        this.email = email;
        this.phone_no = phone_no;
        Uname = uname;
        this.DOB = DOB;
        University_name = university_name;
        Course_name = course_name;
        Intake = intake;
        this.name = name;
        Qualification = qualification;
        this.mark_obtained = mark_obtained;
        Mark_percentage = mark_percentage;
        this.IELTS_mark = IELTS_mark;
        this.TEOEFL_mark = TEOEFL_mark;
        this.communication_medium = communication_medium;
        this.communication = communication;
        this.passport_number = passport_number;
        this.maritial_status = maritial_status;
        this.visa_rejected = visa_rejected;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        // progressDialog.dismiss();
        //Showing a success message
        //Toast.makeText(context,"Message Sent",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        GetUserandPass getUserandPass=new GetUserandPass();
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        //Creating a new session
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    GetUserandPass getUserandPass=new GetUserandPass();
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(getUserandPass.getEMAIL(), getUserandPass.getPASSWORD());
                    }
                });

        try {
            //Creating MimeMessage object


            //String s="D:\\pdf.txt";
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(getUserandPass.getEMAIL()));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress("axisoverseas.enq@gmail.com"));
            //Adding subject

            mm.setSubject("New admission details");

            mm.setText("\tNEW REGISTER\n"+"Email : "+email+"\n"+"Phone no :"+phone_no+"\n"+"Name :"+name+
                    "\n"+"DOB :"+DOB+"\n"+"Intake :"+Intake+"\n"+"Course name :"+Course_name+"\n"+"University name :"+University_name+
                    "\n"+"Qualificatio :"+ Qualification+"\n"+"Mark obtained :"+mark_obtained+
                    "\n"+"Mark percecntage :"+Mark_percentage+"\n"+"IELTS Mark :"+IELTS_mark+"\n"+"TEOEFL Mark :"+TEOEFL_mark+"\n"+"Communication medium :"+communication_medium+
                    "\n"+"Communication id :"+communication+"\n"+"passport number :"+passport_number+"\n"+" martial status :"+maritial_status+"\n"+" visa rejected :"+visa_rejected+"\n");
            //mm.setText(subject);

            Log.w("","yyyyyyyyyyyyyyyyyyyy");
            //Sending email
            send(mm);
            Log.w("","yyyyyyyyyyyyyyyyyyyy");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
