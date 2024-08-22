package com.example.alertdialogapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        Button btnDisplayAlert = findViewById(R.id.btnCustomAlert);

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_alert_dialog);
                dialog.setCancelable(false);

                Button dismiss = dialog.findViewById(R.id.btnDismissAlert);

                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();



//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        alertDialog.setIcon(R.drawable.ic_launcher_background);
//        alertDialog.setTitle("Term And Condition");
//        alertDialog.setMessage("Have You Read The updated Term And Condition");
//
//        alertDialog.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Loading Content....", Toast.LENGTH_SHORT).show();
//            }
//        })
//                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "Sure to Delete the Item...", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//        alertDialog.show();
    }



    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitbuilder = new AlertDialog.Builder(MainActivity.this);
        exitbuilder.setIcon(R.drawable.ic_launcher_foreground);
        exitbuilder.setTitle("Exit From Application");
        exitbuilder.setMessage("Back Press will be Destroy Main Activity");

        exitbuilder.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Yeah is get clicked....", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Delete is get clicked...", Toast.LENGTH_SHORT).show();
                    }
                });


        exitbuilder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Application get Close Man...", Toast.LENGTH_SHORT).show();
                MainActivity.super.onBackPressed();
            }
        });
        exitbuilder.show();
    }

}