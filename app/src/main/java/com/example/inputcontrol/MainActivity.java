package com.example.inputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox chocolate, sprinkles, crushed_nuts, cherries, orio;
    private Button show_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton(){

        chocolate = (CheckBox)findViewById(R.id.chocolate_syrup);
        sprinkles = (CheckBox)findViewById(R.id.sprinkles);
        crushed_nuts = (CheckBox)findViewById(R.id.crushed_nuts);
        cherries = (CheckBox)findViewById(R.id.cherries);
        orio = (CheckBox)findViewById(R.id.orio);
        show_toast = (Button)findViewById(R.id.button_show);

        show_toast.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view){
                        StringBuffer toppings = new StringBuffer().append(getString(R.string.show_text));

                        if(chocolate.isChecked())
                            toppings.append(" "+getString(R.string.chocolate_syrup));
                        if(sprinkles.isChecked())
                            toppings.append(" "+getString(R.string.sprinkles));
                        if(crushed_nuts.isChecked())
                            toppings.append(" "+getString(R.string.crushed_nuts));
                        if(cherries.isChecked())
                            toppings.append(" "+getString(R.string.cherries));
                        if(orio.isChecked())
                            toppings.append(" "+getString(R.string.orio_cookie_crumbles));
                        if(!(chocolate.isChecked()||sprinkles.isChecked()||crushed_nuts.isChecked()
                                ||cherries.isChecked()||orio.isChecked()))  //if all is not checked
                            toppings.append(" None");

                        Toast.makeText(MainActivity.this,toppings.toString(),Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }
}