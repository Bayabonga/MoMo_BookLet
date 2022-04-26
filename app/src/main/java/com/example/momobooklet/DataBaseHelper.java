package com.example.momobooklet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.database.sqlite.SQLiteDatabase;
//import net.sqlcipher.database.SQLiteDatabase;
//import net.sqlcipher.database.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.sql.Blob;
import java.sql.SQLException;

class DataBaseHelper extends SQLiteOpenHelper {


   public static final String RECORD_SHEET = "RECORD_SHEET";
   public static final String TRANSACTION_ID = "TRANSACTION_ID";
   public static final String DATE = "DATE";
   public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
   public static final String CUSTOMER_ID = "CUSTOMER_ID";
   public static final String CUSTOMER_PHONE = "CUSTOMER_PHONE";
   public static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
   public static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
   public static final String SIGNATURE = "SIGNATURE";
   public static final String AGENT_PHONE = "AGENT_PHONE";
   public static final String ACCOUNT_ID = "ACCOUNT_ID";
   public static final String PASSWORD = "PASSWORD";
   public static final String MOMO_NAME = "MOMO_NAME";
   private static final String PASSPHRASE=
           "hard-coding passphrases is only for sample code;"+
                   "nobody does this in production";



   public DataBaseHelper(Context context) {
      super(context, "MoMo_db", null, 1);

    //  SQLiteDatabase.loadLibs(context);


   }

   @Override
   public void onCreate(SQLiteDatabase db) {


      String createMomoAgentInfo= "CREATE TABLE ACCOUNTS (" + ACCOUNT_ID + " INTEGER PRIMARY KEY ," + PASSWORD + " TEXT, " + MOMO_NAME + " TEXT )";
      db.execSQL(createMomoAgentInfo);
      String createTableStatement = "CREATE TABLE " + RECORD_SHEET + "(" + TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " TEXT NOT NULL," + CUSTOMER_NAME + " TEXT NOT NULL," + CUSTOMER_ID + " INTEGER NOT NULL," + CUSTOMER_PHONE + " INTEGER," + TRANSACTION_TYPE + " TEXT NOT NULL," + TRANSACTION_AMOUNT + " INTEGER NOT NULL," + SIGNATURE + " BLOB NOT NULL ," + AGENT_PHONE + ",FOREIGN KEY(" +AGENT_PHONE + ") REFERENCES ACCOUNTS(" + ACCOUNT_ID + ") )";
      db.execSQL(createTableStatement);

   //
      //


   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

   }
/*
   SQLiteDatabase getReadableDatabase() {
      return(super.getReadableDatabase(PASSPHRASE));
   }
   SQLiteDatabase getWritableDatabase() {
      return(super.getWritableDatabase(PASSPHRASE));
   }
*/

   @RequiresApi(api = Build.VERSION_CODES.O)
   public boolean addOne(transaction_record transaction_record) throws SQLException {
 int agent_momo_number = accountcheck();
SQLiteDatabase db=this.getWritableDatabase();

Blob blob = null;
   //   assert blob != null;
      blob.setBytes(1,transaction_record.getSignature());
      String queryString ="INSERT INTO" +RECORD_SHEET+"("+DATE+","+CUSTOMER_NAME+","+CUSTOMER_ID+","+CUSTOMER_PHONE+","+TRANSACTION_TYPE+","+TRANSACTION_AMOUNT+","+SIGNATURE+","+AGENT_PHONE+ ")"+"VALUES"+"("+transaction_record.getDate()+ ","+transaction_record.getName()+","+transaction_record.getCustomer_id()+","+transaction_record.getPhone_number()+","+transaction_record.getTransaction_type()+","+transaction_record.getAmount()+","+blob
              +","+agent_momo_number+ ")" ;


final Cursor cursor= db.rawQuery(queryString,null);
if(cursor.moveToFirst()){
   db.close();
   return true;

}else{
   db.close();
   return false;

}




   }



   //To produce user account(Momo phone number ya agent )
   public int accountcheck(){
      return 76911464;

   }
}
