package com.i054114.citips;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.i054114.citips.Helper.SqliteHelper;
import com.i054114.citips.Utilities.Constans;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextConfirmPassword;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = (EditText) findViewById(R.id.username_edtext);
        editTextPassword = (EditText) findViewById(R.id.passwd_edtext);
        editTextConfirmPassword = (EditText) findViewById(R.id.cnfpasswd_edtext);

        sqliteHelper = new SqliteHelper(this, "db_citips", null, 1);
    }

    public void registrar(View view){


        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constans.TABLE_FIELD_USER_USERNAME, editTextUsername.getText().toString());
        values.put(Constans.TABLE_FIELD_USER_PASSWORD, editTextPassword.getText().toString());
        values.put(Constans.TABLE_FIELD_USER_CONFIRMPASSWORD, editTextConfirmPassword.getText().toString());

        Long idResult = db.insert(Constans.TABLE_NAME_USERS, Constans.TABLE_FIELD_USER_ID, values);

        editTextUsername.setText("");
        editTextPassword.setText("");
        editTextConfirmPassword.setText("");

        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
