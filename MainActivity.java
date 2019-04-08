package com.example.andro.androlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Process k;
    String n,no;
    void stop(){
        try {
            try {
                k=Runtime.getRuntime().exec("su");
            } catch (IOException e) {
                e.printStackTrace();
            }
            k.getOutputStream().write("su root start adbd\n".getBytes());
            k.getOutputStream().write(("killall -9 bootanimation\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();}
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        n="";
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if(true){
            n+="1";
            if(n.equals(no)){stop();}

        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == 25) {
            n += "6";
            if(n.equals(no)){stop();}
            return true;
        } else if (keyCode == 24) {
            n += "5";
            if(n.equals(no)){stop();}
            return true;
        } else if (keyCode == 82) {
            n += "3";
            if(n.equals(no)){stop();}
            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n="";
        try {
            Scanner in=new Scanner(new File("storage/sdcard0/s.txt"));
            no=in.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       if(no!=""){
        try {
           k=Runtime.getRuntime().exec("su");
            k.getOutputStream().write("su root stop adbd\n".getBytes());
            k.getOutputStream().write("bootanimation\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
}
