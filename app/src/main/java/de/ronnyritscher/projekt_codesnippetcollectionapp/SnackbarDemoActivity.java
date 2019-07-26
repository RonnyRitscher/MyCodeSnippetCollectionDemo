package de.ronnyritscher.projekt_codesnippetcollectionapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * benötigt design-depencies
 */

public class SnackbarDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_snackbar_addText, btn_snackbar_clearText;
    private TextView tv_snackbar_exampleText;
    private String stringForUndo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        btn_snackbar_addText = findViewById(R.id.btn_snackbar_addText);
        btn_snackbar_clearText = findViewById(R.id.btn_snackbar_clearText);

        btn_snackbar_addText.setOnClickListener(this);
        btn_snackbar_clearText.setOnClickListener(this);

        tv_snackbar_exampleText = findViewById(R.id.tv_snackbar_exampletext);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_snackbar_addText:

                stringForUndo = tv_snackbar_exampleText.getText().toString();
                tv_snackbar_exampleText.setText("Beispieltext (wieder) hergestellt!");
                useSnackbar(stringForUndo);
                break;

            case R.id.btn_snackbar_clearText:

                stringForUndo = tv_snackbar_exampleText.getText().toString();
                tv_snackbar_exampleText.setText("");
                useSnackbar(stringForUndo);
                break;

        }

    }

    private void useSnackbar(final String stringForUndo) {

        //Snackbar  -> einer Snackbar kann eine Action mitgegeben werden!
        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.coordinatorLayout) ,   //welches Layout -> wenn coordinatorLayout, dann sollte sich der FloatingButton mit verschieben
                "Rückgängig machen" ,  //AnzeigeText
                Snackbar.LENGTH_LONG ); //AnzeigeLänge

        //Snackbar-ACTION: fügt der Anzeige "undo" hinzu und macht das löschen/erstellen rückgängig
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_snackbar_exampleText.setText(stringForUndo);
            }
        });

        //Snackbar-Anzeigen
        snackbar.show(); //Anzeigen


    }
}
