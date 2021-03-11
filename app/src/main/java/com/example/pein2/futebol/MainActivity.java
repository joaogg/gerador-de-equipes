package com.example.pein2.futebol;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView xd;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) this.findViewById(R.id.textView);
        xd = (TextView) this.findViewById(R.id.xd);
        spinner = (Spinner) this.findViewById(R.id.spinner);

        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView statusview;
                statusview = (TextView) findViewById(R.id.statusView);

                if(xd.getText().toString().length() > 0) {
                    String stringDeNomes = xd.getText().toString();
                    int inteiroTimes = Integer.parseInt(spinner.getSelectedItem().toString());
                    String[] arrayDeNomes = stringDeNomes.split(",");

                    List lista = Arrays.asList(arrayDeNomes);

                    Collections.shuffle(lista);

                    String zika = "";

                    int n = 0;
                    for (int i = 0; i < lista.size(); ++i) {

                        if (i % inteiroTimes == 0) {
                            ++n;
                            zika += "\n" + n + "º EQUIPE: \n";
                        }
                        zika += lista.get(i) + " \n";

                    }

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Equipes Formadas");
                    alertDialog.setMessage(zika);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Voltar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    //statusview.setText(zika + "");

                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Aviso");
                    alertDialog.setMessage("Preencha o campo jogadores!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Confirmar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
}
