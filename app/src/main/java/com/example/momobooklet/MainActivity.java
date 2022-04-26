package com.example.momobooklet;

import static java.util.Objects.*;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.momobooklet.databinding.ActivityMainBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Class.forName("dalvik.system.CloseGuard")
                    .getMethod("setEnabled", boolean.class)
                    .invoke(null, true);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(requireNonNull(binding.appBarMain).toolbar);
     /*   binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id =item.getItemId();

        if(id==R.id.action_settings){


            Intent i = new Intent(getApplicationContext(), SignaturePad1.class);
            startActivity(i);
 return true ;
        }
      else
          return false;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void try1(View v) {
        com.google.android.material.switchmaterial.SwitchMaterial tobeused = (SwitchMaterial) v;

        boolean test = tobeused.isChecked();
        if (test == false) {
            tobeused.setText("Buy Momo");


        } else if (test == true) {

            tobeused.setText("Sell Momo");

        }


    }

    public void store_action(View v) {
        EditText phonenumber;
        EditText name;
        EditText id;
        EditText amount;
        Switch switch1;
        //transaction_record transaction_record=new transaction_record()
        phonenumber = findViewById(R.id.customerPhone);
        String phoneText = phonenumber.getText().toString();
        if (!TextUtils.isEmpty(phoneText)) {
            DataBaseHelper DB=new DataBaseHelper((getApplicationContext()));
            Intent i = new Intent(getApplicationContext(), SignaturePad1.class);
           startActivity(i);


        }else{

            Toast.makeText(getApplicationContext(),"Set Phone number first ",Toast.LENGTH_SHORT).show();

        }
    }
    public void settings_action (View v){


        Intent i = new Intent(getApplicationContext(), SignaturePad1.class);
        startActivity(i);



    }
}