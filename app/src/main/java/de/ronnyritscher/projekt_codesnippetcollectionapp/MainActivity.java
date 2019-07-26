package de.ronnyritscher.projekt_codesnippetcollectionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO - Liste (klickbar) mit den vorhandenen CS anzeigen und auf die Activitys weiterleiten. Tmp erstmal über Buttons realisiert!
 * <p>
 * <p>
 * Inhaltsverzeichnis der CodeSnippets:
 * #BorderWithLable
 * #AlertDialogs
 */

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();

    static ArrayList<MainRecyclerViewObject_DemoCode> demoArrayList;

    //Member der RecyclerView
    private RecyclerView mainRecyclerView;
    private RecyclerView.Adapter mainRecyclerViewAdapter;
    private RecyclerView.LayoutManager mainRecyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
//        btn_main_alertDialog = findViewById(R.id.btn_main_alertDialog);
//        btn_main_borderWithLable = findViewById(R.id.btn_main_borderWithLable);
//        btn_main_datePicker = findViewById(R.id.btn_main_datePicker);
//        btn_main_progressBar = findViewById(R.id.btn_main_progressBar);
//        btn_main_snackbar = findViewById(R.id.btn_main_snackbar);
//        btn_main_recyclerView = findViewById(R.id.btn_main_recyclerView);

        //OnClickListener
//        btn_main_alertDialog.setOnClickListener(this);
//        btn_main_borderWithLable.setOnClickListener(this);
//        btn_main_datePicker.setOnClickListener(this);
//        btn_main_progressBar.setOnClickListener(this);
//        btn_main_snackbar.setOnClickListener(this);
//        btn_main_recyclerView.setOnClickListener(this);

        //RecyclerView
        mainRecyclerView = findViewById(R.id.rv_main_recyclerview);

        //RecyclerViewLayoutManager:
        mainRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(mainRecyclerViewLayoutManager);       //Übergeben von RecyclerViewLayoutManager an RecyclerView

        //RecyclerViewAdapter: Adapter wird initialisiert/gebaut
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter();
        mainRecyclerView.setAdapter(mainRecyclerViewAdapter);                 //Übergeben von RecyclerViewAdapter an RecyclerView




        //RecyclerView Arraylist der Items:
        Log.d(TAG, "RecyclerView Arraylist erstellt ");
        demoArrayList = new ArrayList<>();
        demoArrayList.addAll(Arrays.asList(
                //Hier werden die neuen Demos in der RV hinzugefügt:
                //new MainRecyclerViewObject_DemoCode("name", "description", "className")

                new MainRecyclerViewObject_DemoCode(
                        "Border with Lable",
                        "Anzeigen eines EditText mir einem Border (runde Ecken, LableText des Borders)",
                        "BorderWithLableDemoActivity"),

                new MainRecyclerViewObject_DemoCode(
                        "AlertDialogs",
                        "Beispiele für simple-Dialog,  singleChoice-Dialog und  multiChoice-Dialog",
                        "AlertDialogDemoActivity"),

                new MainRecyclerViewObject_DemoCode(
                        "DatePicker",
                        "Angabe eines Datums zb: als Geburtstag",
                        "DatePickerDemoActivity"),

                new MainRecyclerViewObject_DemoCode(
                        "Progressbar",
                        "Beispiele für simple-Dialog,  singleChoice-Dialog und  multiChoice-Dialog",
                        "ProgressBarDemoActivity"),

                new MainRecyclerViewObject_DemoCode(
                        "RecyclerView",
                        "BeispielCode für RecyclerView",
                        "RecyclerViewDemoActivity"),

                new MainRecyclerViewObject_DemoCode(
                        "AddNewFieldsPerButton",
                        "BeispielCode für das erstellen weiterer Elemente über einen anderes Element",
                        "AddNewFieldsPerButton"),

                new MainRecyclerViewObject_DemoCode(
                        "Snackbar",
                        "Snackbar-Demo zB: für das Rückgangigmachen von Aktionen",
                        "SnackbarDemoActivity")

                ));





        //Sortieren der Liste ermöglichen:
        //demoArrayList.sort(Comparator.comparing(  ));

    }
}
