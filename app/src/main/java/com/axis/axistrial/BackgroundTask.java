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


public class BackgroundTask extends AsyncTask<Void,Void,Void> {

    private Context context;
    private Session session;


    //Information to send email
    private String email;
    private String phone_no;
    private String Uname;
    private  String DOB;

    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;

    public BackgroundTask(Context context, String email, String phone_no,String Uname,String DOB) {
        this.context=context;
        this.email=email;
        this.phone_no=phone_no;
        this.Uname=Uname;
        this.DOB=DOB;
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



            mm.setText("\tNEW REGISTER\n"+"Email : "+email+"\n"+"Phone no :"+phone_no+"\n"+"Name :"+Uname+"\n"+"DOB :"+DOB);
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
