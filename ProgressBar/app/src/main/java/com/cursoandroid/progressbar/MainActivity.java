package com.cursoandroid.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar progressBarCarregando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBarCarregando = findViewById(R.id.progressBarCarregando);


        progressBarCarregando.setVisibility(View.GONE);
    }

    public void carregarProgressBar(View view) {

        progressBarCarregando.setVisibility(View.VISIBLE);
        /*this.progresso+= 10;
        progressBar.setProgress(this.progresso);*/


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++){
                    final int progresso = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progresso);

                            if (progresso == 100){
                                progressBarCarregando.setVisibility(View.GONE);
                            }
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
