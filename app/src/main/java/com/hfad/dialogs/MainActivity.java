package com.hfad.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btnAlert;
    private AppCompatButton btnDialogSingleItems;
    private AppCompatButton btnDialogMultiItems;
    private AlertDialog alertDialog;
    private AlertDialog dialogSingleItems;
    private AlertDialog dialogMultiItems;
    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(this/*, R.style.AlertDialog*/);
        builder.setTitle("Deseja excluir?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Sim", Toast.LENGTH_LONG).show();
            }

        });


        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_LONG).show();
            }

        });

        alertDialog = builder.create();

        btnAlert = findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertDialog.show();
            }

        });

        AlertDialog.Builder builderDialogSingleItems = new AlertDialog.Builder(this);
        builderDialogSingleItems.setTitle("Selecione a opção desejada:");
        builderDialogSingleItems.setPositiveButton("OK", null);
        builderDialogSingleItems.setNegativeButton("CANCELAR", null);
        builderDialogSingleItems.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_LONG).show();
            }

        });

        dialogSingleItems = builderDialogSingleItems.create();

        btnDialogSingleItems = findViewById(R.id.btnDialogSingleItems);
        btnDialogSingleItems.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialogSingleItems.show();
            }

        });

        AlertDialog.Builder builderDialogMultiItems = new AlertDialog.Builder(this);
        builderDialogMultiItems.setTitle("Selecione a opção desejada:");
        builderDialogMultiItems.setPositiveButton("OK", null);
        builderDialogMultiItems.setNegativeButton("CANCELAR", null);
        builderDialogMultiItems.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(), items[which] + " : " + isChecked, Toast.LENGTH_LONG).show();
            }

        });

        dialogMultiItems = builderDialogMultiItems.create();

        btnDialogMultiItems = findViewById(R.id.btnDialogMultiItems);
        btnDialogMultiItems.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialogMultiItems.show();
            }

        });
    }
}
