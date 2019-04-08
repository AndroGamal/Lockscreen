package com.example.andro.androlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
boolean x;
    Button cl;
static String n;
    @Override
    public void onBackPressed() {
    if(x){
        n+="1";
         }
    else {
        super.onBackPressed();
         }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(x){
        if(keyCode==25)
        {
        n += "6";
        return true;
        }
        else if(keyCode==24)
        {
            n += "5";
            return true;
        }

       else if (keyCode == 82) {
            n += "3";
            return true;
        }
            else {return super.onKeyDown(keyCode, event);}
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        x=false;
        n="";
        cl=findViewById(R.id.button);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!x) {
                    x = true;
                    cl.setText("ready");
                }
                else {
                    x = false;
                    cl.setText("Setting");
                    try {
                        Process p=Runtime.getRuntime().exec("su");
                        p.getOutputStream().write("rm storage/sdcard0/s.txt\n".getBytes());
                        p.getOutputStream().write(("echo "+n+" >>storage/sdcard0/s.txt\n").getBytes());
                        Toast.makeText(Main2Activity.this, n, Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
