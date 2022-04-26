package com.example.momobooklet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;


import java.io.ByteArrayOutputStream;
import java.util.Date;

public class SignaturePad1 extends AppCompatActivity {
    private boolean test =false ;
    DataBaseHelper db= new DataBaseHelper(SignaturePad1.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature_pad1);

    }

    public void clear(View v){
        SignaturePad signaturePad=findViewById(R.id.SignId);
        signaturePad.clear();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void capture(View v)  {
        SignaturePad signaturePad=findViewById(R.id.SignId);
        Bitmap sigmature =signaturePad.getSignatureBitmap();



        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
                test= true;

            }

            @Override
            public void onSigned() {
                test= true;

            }

            @Override
            public void onClear() {
               test = false;
                }

        });


        if(!test){
            Toast.makeText(getApplicationContext(),"please sign",Toast.LENGTH_SHORT).show();


        }else{


            LocalDate currentTime=LocalDate.now() ;

            ImageView image= findViewById(R.id.image);
            Bitmap signature=signaturePad.getSignatureBitmap();
           ByteArrayOutputStream stream = new ByteArrayOutputStream();
            signature.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            transaction_record transaction_record=new transaction_record(currentTime,byteArray,"Simphiwe","9809146100529","76911464","Buy",9000);

      /*   try{
            /// }catch(Exception e) {

   transaction_record.setSignature(byteArray);







             image.setImageBitmap(bitmap);
             signaturePad.clear();

             Toast.makeText(SignaturePad1.this, "SUCCESS" + transaction_record.getTransaction_type(), Toast.LENGTH_SHORT).show();
         }catch(Exception e){

  Bitmap bitmap = BitmapFactory.decodeByteArray(transaction_record.getSignature(), 0, byteArray.length);

             Toast.makeText(SignaturePad1.this, "Failed to capture transaction", Toast.LENGTH_SHORT).show();
         }


             transaction_record transaction_record=new transaction_record(currentTime,byteArray,"Simphiwe","9809146100529","76911464","Buy",9000);

          */




           try{    db.addOne(transaction_record);

         }catch(Exception d){



             Toast.makeText(SignaturePad1.this, "failed in database addition", Toast.LENGTH_SHORT).show();

         }


            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


            image.setImageBitmap(bitmap);
            signaturePad.clear();
           //image.setImageBitmap(signature);

        }




    }


}