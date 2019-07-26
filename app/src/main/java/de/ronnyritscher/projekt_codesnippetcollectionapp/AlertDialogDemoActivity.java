package de.ronnyritscher.projekt_codesnippetcollectionapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlertDialogDemoActivity extends AppCompatActivity {

    private static final String TAG = AlertDialogDemoActivity.class.getSimpleName();

    //MEMBER of SIMPLE-CHOICE
    private Button btn_alertDialog_simpleChoice;
    private TextView tv_alertDialog_simpleChoice_result;

    //MEMBER of SINGLE-CHOICE
    private Button btn_alertDialog_singleChoice;
    private TextView tv_alertDialog_singleChoice_result;


    //MEMBER of MULTI-CHOICE
    private Button btn_alertDialog_multiChoice;
    private TextView tv_alertDialog_multiChoice_result;
    private String[] categoryListItems;
    private boolean[] categoryCheckedItems;
    ArrayList<Integer> mCategoryUserItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);


        //String-Array von res/arrays laden
        categoryListItems = getResources().getStringArray(R.array.multichoiceList);
        // Boolean array für die ausgewählten Items des categoryArrays
        categoryCheckedItems = new boolean[categoryListItems.length] ;


        //Initialisieren:
        tv_alertDialog_simpleChoice_result =  findViewById(R.id.tv_alertDialog_simpleDialog_result);
        tv_alertDialog_singleChoice_result = findViewById(R.id.tv_alertDialog_singleChoice_result);
        tv_alertDialog_multiChoice_result = findViewById(R.id.tv_alertDialog_multiChoice_result);

        btn_alertDialog_simpleChoice = findViewById(R.id.btn_alertDialog_simpleChoice);
        btn_alertDialog_singleChoice = findViewById(R.id.btn_alertDialog_singleChoice);
        btn_alertDialog_multiChoice = findViewById(R.id.btn_alertDialog_multiChoice);


        btn_alertDialog_simpleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlertDialog_simpleChoice();
            }
        });

        //AlertDialog_SingleChoice
        btn_alertDialog_singleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlertDialog_singleChoice();
            }
        });

        //AlertDialog_MultiChoice
        btn_alertDialog_multiChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlertDialog_multiChoice();
            }
        });
    }

    //**********************************************************************************************************
    private void openAlertDialog_simpleChoice() {

        AlertDialog.Builder dialogSimpleChoice = new AlertDialog.Builder(AlertDialogDemoActivity.this);
        dialogSimpleChoice.setTitle("Simple Dialog");
        dialogSimpleChoice.setMessage("Hier kann eine Information zur Kenntnisnahme oder ein Fehlerzustand angegeben werden... Bitte Akzeptieren!");
        dialogSimpleChoice.setPositiveButton("Bestätigen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Hier kann weiterer Code eingebaut werden
                Toast.makeText(AlertDialogDemoActivity.this, "Bestätigt!", Toast.LENGTH_SHORT).show();
                tv_alertDialog_simpleChoice_result.setText("Bestätigt!");
                dialog.dismiss();
            }
        });
        dialogSimpleChoice.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Abbruch des AlertDialogs
                Toast.makeText(AlertDialogDemoActivity.this, "Nicht bestätigt!", Toast.LENGTH_SHORT).show();
                tv_alertDialog_simpleChoice_result.setText("Nicht bestätigt!");
                dialog.dismiss();
            }
        });
        dialogSimpleChoice.setNeutralButton("Abbrechen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //Abbruch des AlertDialogs
                Toast.makeText(AlertDialogDemoActivity.this, "Abbruch!", Toast.LENGTH_SHORT).show();
                tv_alertDialog_simpleChoice_result.setText("Keine Angabe!");
                dialog.dismiss();
            }
        });
        dialogSimpleChoice.create().show();
    }

    //**********************************************************************************************************
    private void openAlertDialog_singleChoice() {

        final CharSequence[] zahlenArray = {"0", "1", "2", "3"};

        //Erstellen eines AlertDialogs über den Builder
        AlertDialog.Builder dialogSingleChoice = new AlertDialog.Builder(AlertDialogDemoActivity.this );

        //Title
        dialogSingleChoice.setTitle("Single Choice!");

        //Message : bei einer SingleChoice ist keine Message-Angabe möglich
        //dialogSingleChoice.setMessage("Das ist die Nachricht, die Angezeigt und dessen Inhalt bestätigt werden soll! Bsp: Wähle eine Zahl aus"); //Nachricht die angezeigt wird

        dialogSingleChoice.setSingleChoiceItems(zahlenArray, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                CharSequence ergebnis = zahlenArray[which];

                Log.d(TAG, "ergebnis: "+ergebnis);

                if(ergebnis != null){
                    tv_alertDialog_singleChoice_result.setText(ergebnis);
                }else{
                    tv_alertDialog_singleChoice_result.setText("Keine Zahl ausgewählt!");
                }
                dialog.dismiss();

            }
        });

        dialogSingleChoice.setNegativeButton("Abbruch", new DialogInterface.OnClickListener() {   //NEGATIVER BUTTON
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogDemoActivity.this, "Nein", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //!! Anzeigen des Dialogs
        dialogSingleChoice.create().show();
    }


    //**********************************************************************************************************
    private void openAlertDialog_multiChoice() {



        AlertDialog.Builder dialogMultiChoice = new AlertDialog.Builder(AlertDialogDemoActivity.this);

        dialogMultiChoice.setTitle("Bsp: Wähle eine oder mehrere Kategorie(n) aus:");
        dialogMultiChoice.setMultiChoiceItems(categoryListItems, categoryCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //teste ob Item ausgewählt wurde ...
                if(isChecked){
                    //teste ob item in dem zu hinterlegenen ArrayList noch nicht vorhanden ist:
                    if(!mCategoryUserItems.contains(which)){
                        //füge dieses ggf hinzu:
                        mCategoryUserItems.add(which);
                    }
                }else if(mCategoryUserItems.contains(which)){
                    mCategoryUserItems.remove((Integer) which);     //entferne Item
                }
            }
        });
        dialogMultiChoice.setCancelable(false);

        //OK-BUTTON
        dialogMultiChoice.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Löschen des vorhandenen TextFeldes
                String categoriyItemText = "";

                //For-Schleife um die Trennung der einzelnen Auswahlen zu optimieren
                for(int i = 0; i< mCategoryUserItems.size() ; i++){
                    Log.d(TAG, "mCategoryUserItems.size: " +mCategoryUserItems.size());
                    //füge das ausgewählte Item dem String hinzu
                    categoriyItemText = categoriyItemText + categoryListItems[mCategoryUserItems.get(i)];

                    //Prüfe ob es das letzte Item ist um die Anzeige/Ausgabe zu optimieren
                    if(i != mCategoryUserItems.size()-1){
                        //Wenn nicht, füge ein "," hinzu
                        categoriyItemText = categoriyItemText + " | ";
                    }
                }
                //Text ausgeben:
                if(mCategoryUserItems.size()>0){
                    tv_alertDialog_multiChoice_result.setText(categoriyItemText);
                }else{
                    tv_alertDialog_multiChoice_result.setText("Keine Kategorie ausgewählt!");
                }
            }
        });

        //ABBRUCH-BUTTON
        dialogMultiChoice.setNegativeButton("Abbruch", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //LÖSCHE ALLES -BUTTON
        dialogMultiChoice.setNeutralButton("Lösche komplette Auswahl", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //lösche alle ausgewählten Items
                for(int i = 0; i< categoryCheckedItems.length ; i++ ){
                    categoryCheckedItems[i] = false;  //Deaktiviert alles
                    mCategoryUserItems.clear(); //Löscht alle infos der Liste
                    tv_alertDialog_multiChoice_result.setText("");        //Löscht die Angezeigten Auswahlen
                }
            }
        });
        dialogMultiChoice.create().show();  //AlertDialog Erstellen und Anzeigen
    }
    //**********************************************************************************************************
}
