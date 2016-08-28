package com.example.eslam.trisqunumbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNumbers (View view){
        ImageView imgView = (ImageView) findViewById(R.id.img);
        EditText editText = (EditText) findViewById(R.id.num);
        int value = Integer.valueOf(editText.getText().toString());
        isBoth(value,imgView);
        onlySqu(value,imgView);
        onlyTri(value,imgView);
        noThing(value);
    }

    public boolean isTriangular (int value){
        int triValue = 0;
        for (int i = 0; i <= value ; i++) {
            triValue =(i * (i + 1))/2;
            if (value == triValue) {
                return true;
            }
        }
        return false ;
    }

    public boolean isSquare (int value) {
        int squValue = 0;
        for (int i = 0; i <= value ; i++) {
            squValue = i * i;
            if (value == squValue) {
                return   true;
            }
        }
        return false;
    }

    public void isBoth(int value,ImageView view){
        if(isTriangular(value) && isSquare(value)) {
            Toast.makeText(this, "This number is both square and triangular",Toast.LENGTH_SHORT).show();
            view.setImageResource(R.drawable.trisqu);
        }
    }

    public void onlyTri(int value,ImageView view){
        if(isTriangular(value) && isSquare(value)==false) {
            Toast.makeText(this,"This number is triangular not square",Toast.LENGTH_SHORT).show();
            view.setImageResource(R.drawable.trishape);

        }
    }
    public void onlySqu(int value,ImageView view){
        if(isSquare(value) && isTriangular(value)==false) {
            Toast.makeText(this,"This number is square not triangular",Toast.LENGTH_SHORT).show();
            view.setImageResource(R.drawable.squshape);
        }
    }

    public void noThing(int value){
        if(isSquare(value)==false && isTriangular(value)==false) {
            Toast.makeText(this,"This number neither square nor triangular",Toast.LENGTH_SHORT).show();
        }
    }

}
