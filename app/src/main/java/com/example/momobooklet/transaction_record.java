package com.example.momobooklet;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
@RequiresApi(api = Build.VERSION_CODES.O)
class transaction_record {


   private LocalDate Date ;
  private byte[] signature;
  private String name;
   private String  customer_id;
   private String phone_number;
   private String transaction_type;
    private int amount;
    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {

        Date = date;
    }
   public transaction_record(byte[] signature, String name, String customer_id, String phone_number, String transaction_type, int amount) {
      this.signature = signature;
      this.name = name;
      this.customer_id = customer_id;
      this.phone_number = phone_number;
      this.transaction_type = transaction_type;
      this.amount = amount;
   }

    public transaction_record(LocalDate date, byte[] signature, String name, String customer_id, String phone_number, String transaction_type, int amount) {
        Date = date;
        this.signature = signature;
        this.name = name;
        this.customer_id = customer_id;
        this.phone_number = phone_number;
        this.transaction_type = transaction_type;
        this.amount = amount;
    }

    public transaction_record(String name, String customer_id, String phone_number, String transaction_type, int amount) {
      this.name = name;
      this.customer_id = customer_id;
      this.phone_number = phone_number;
      this.transaction_type = transaction_type;
      this.amount = amount;
   }

   public byte[] getSignature() {
      return signature;
   }

   public void setSignature(byte[] signature) {
      this.signature = signature;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCustomer_id() {
      return customer_id;
   }

   public void setCustomer_id(String  customer_id) {
      this.customer_id = customer_id;
   }

   public String getPhone_number() {
      return phone_number;
   }

   public void setPhone_number(String phone_number) {
      this.phone_number = phone_number;
   }

   public String getTransaction_type() {
      return transaction_type;
   }

   public void setTransaction_type(String transaction_type) {
      this.transaction_type = transaction_type;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }



}
