package de.ritscherappdeveloper.projekt_codesnippetcollectionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ProgressBarActivity.class.getSimpleName();

    private Button btnProgressBarRound , btn_progressbar_horizontalExample_decrease, btn_progressbar_horizontalExample_increase;
    private TextView tv_progressBar_simpleExample_result, tv_progressBar_horizontalExample_result;
    private ProgressBar progressBarRound, progressBarHorizontal;
    private int progressBarHorizontalResult = 0;
    private int progressBarHorizontalSteps = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        tv_progressBar_simpleExample_result = findViewById(R.id.tv_progressBar_simpleExample_result);
        tv_progressBar_horizontalExample_result = findViewById(R.id.tv_progressBar_horizontalExample_result);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarRound = findViewById(R.id.progressBarRound);
        progressBarRound.setVisibility(View.GONE);


        btnProgressBarRound = findViewById(R.id.btn_progressBar_roundExample);
        btn_progressbar_horizontalExample_decrease = findViewById(R.id.btn_progressbar_horizontalExample_decrease);
        btn_progressbar_horizontalExample_increase= findViewById(R.id.btn_progressbar_horizontalExample_increase);

        btn_progressbar_horizontalExample_decrease.setOnClickListener(this);
        btn_progressbar_horizontalExample_increase.setOnClickListener(this);
        btnProgressBarRound.setOnClickListener(this);

        btnProgressBarRound.setText("start");

        Log.d(TAG, "onCreate: ");


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_progressbar_horizontalExample_decrease:
                decreaseProgressBarHorizontal();
                break;

            case R.id.btn_progressbar_horizontalExample_increase:
                increaseProgressBarHorizontal();
                break;

            case R.id.btn_progressBar_roundExample:
                if(btnProgressBarRound.getText().equals("start") ){
                    btnProgressBarRound.setText("stop");
                    startProgressBarRound();
                }else{
                    btnProgressBarRound.setText("start");
                    stopProgressBarRound();
                }
                break;


        }
    }

    private void decreaseProgressBarHorizontal() {

        if( progressBarHorizontalResult>0 & progressBarHorizontalResult<=100 ){
            progressBarHorizontalResult = progressBarHorizontalResult - progressBarHorizontalSteps;

            Log.d(TAG, "progressBarHorizontalResult: "+progressBarHorizontalResult);
            Log.d(TAG, "progressBarHorizontalSteps: " +progressBarHorizontalSteps);

            progressBarHorizontal.setProgress( progressBarHorizontalResult );
            tv_progressBar_horizontalExample_result.setText("Fortschritt: "+progressBarHorizontalResult+ " / 100 ");
        }
    }

    private void increaseProgressBarHorizontal() {
        if( progressBarHorizontalResult>=0 & progressBarHorizontalResult<100 ){
            progressBarHorizontalResult = progressBarHorizontalResult + progressBarHorizontalSteps;

            Log.d(TAG, "progressBarHorizontalResult: "+progressBarHorizontalResult);
            Log.d(TAG, "progressBarHorizontalSteps: " +progressBarHorizontalSteps);

            progressBarHorizontal.setProgress(progressBarHorizontalResult);
            tv_progressBar_horizontalExample_result.setText("Fortschritt: "+progressBarHorizontalResult+ " / 100 ");

        }
    }

    private void stopProgressBarRound() {
        progressBarRound.setVisibility(View.GONE);
        tv_progressBar_simpleExample_result.setText("progress stopped ");
    }

    private void startProgressBarRound() {
        progressBarRound.setVisibility(View.VISIBLE);
        tv_progressBar_simpleExample_result.setText("in progress");

    }


}
