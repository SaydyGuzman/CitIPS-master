package com.i054114.citips;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.i054114.citips.Helper.SqliteHelper;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextPass;
    Button buttonLogin;
    TextView textViewRegister;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRegister = (TextView) findViewById(R.id.btn_registrar);
        editTextName = (EditText) findViewById(R.id.ed_user);
        editTextPass = (EditText) findViewById(R.id.ed_pass);
        buttonLogin = (Button) findViewById(R.id.btn_ingresar);

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    public void Login(View view) {
        SqliteHelper sqliteHelper = new SqliteHelper(this, "db_citips", null, 1);
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String user = editTextName.getText().toString();
        String pass = editTextPass.getText().toString();
        Cursor cursor = db.rawQuery("SELECT username,password from users WHERE username='" + user + "'and password='" + pass + "'", null);
        if (cursor.moveToFirst()) {
            String usuario = cursor.getString(0);
            String contra = cursor.getString(1);
            if (user.equals(usuario) && pass.equals(contra)) {
                final AlertDialog.Builder Alerta = new AlertDialog.Builder(this);
                Alerta.setTitle("Ingreso Exitoso");
                Alerta.setMessage("Bienvenido Sr(a): " + user);
                Alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, PricipalActivity.class);
                        MainActivity.this.startActivity(intent);
                        onBackPressed();
                    }

                });
                Alerta.setIcon(R.drawable.icons8_applause_50);
                Alerta.create();
                Alerta.show();

            }
        } else {
            final AlertDialog.Builder Alerta = new AlertDialog.Builder(this);
            Alerta.setTitle("Error!");
            Alerta.setMessage("Usuario o Contraseña Incorrecto");
            Alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editTextName.setText("");
                    editTextPass.setText("");
                }
            });
            Alerta.setIcon(R.drawable.icons8_warning_shield_50);
            Alerta.create();
            Alerta.show();

        }
    }


}
