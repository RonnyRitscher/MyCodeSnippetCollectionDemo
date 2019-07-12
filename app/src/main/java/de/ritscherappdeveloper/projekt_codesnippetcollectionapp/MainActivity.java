package de.ritscherappdeveloper.projekt_codesnippetcollectionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * TODO - Liste (klickbar) mit den vorhandenen CS anzeigen und auf die Activitys weiterleiten. Tmp erstmal über Buttons realisiert!
 * <p>
 * <p>
 * Inhaltsverzeichnis der CodeSnippets:
 * #BorderWithLable
 * #AlertDialogs
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_main_alertDialog, btn_main_borderWithLable, btn_main_datePicker, btn_main_progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        btn_main_alertDialog = findViewById(R.id.btn_main_alertDialog);
        btn_main_borderWithLable = findViewById(R.id.btn_main_borderWithLable);
        btn_main_datePicker = findViewById(R.id.btn_main_datePicker);
        btn_main_progressBar = findViewById(R.id.btn_main_progressBar);

        //OnClickListener
        btn_main_alertDialog.setOnClickListener(this);
        btn_main_borderWithLable.setOnClickListener(this);
        btn_main_datePicker.setOnClickListener(this);
        btn_main_progressBar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn_main_borderWithLable:
                intent = new Intent(this, BorderWithLableActivity.class);
                break;

            case R.id.btn_main_alertDialog:
                intent = new Intent(this, AlertDialogActivity.class);
                break;

            case R.id.btn_main_datePicker:
                intent = new Intent(this, DatePickerActivity.class);
                break;

            case R.id.btn_main_progressBar:
                intent = new Intent(this, ProgressBarActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
