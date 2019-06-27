package com.lazday.sharedpreferences;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    EditText etValue1, etValue2, etValue3, etValue4;
    Button btnSimpan1, btnSimpan2, btnSimpan3, btnSimpan4;
    RadioGroup rgBoolean;
    RadioButton rbTrue, rbFalse;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();

        btnSimpan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.prefsManager.putString(PrefsManager.SESS_TEKS_1,
                        etValue1.getText().toString());
                setMessage(etValue1.getText().toString());
            }
        });
        btnSimpan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.prefsManager.putString(PrefsManager.SESS_TEKS_2,
                        etValue2.getText().toString());
                setMessage(etValue2.getText().toString());
            }
        });
        btnSimpan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.prefsManager.putString(PrefsManager.SESS_TEKS_3,
                        etValue3.getText().toString());
                setMessage(etValue3.getText().toString());
            }
        });
        btnSimpan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.prefsManager.putInt(PrefsManager.SESS_NO_4,
                        Integer.valueOf(etValue4.getText().toString()) );
                setMessage(etValue4.getText().toString());
            }
        });
        rgBoolean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbTrue:
                        App.prefsManager.putBoolean(PrefsManager.SESS_BOOL_5, true);
                        break;
                    case R.id.rbFalse:
                        App.prefsManager.putBoolean(PrefsManager.SESS_BOOL_5, false);
                        break;
                }
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etValue1.setText(
                        App.prefsManager.getString(PrefsManager.SESS_TEKS_1)
                );
                etValue2.setText(
                        App.prefsManager.getString(PrefsManager.SESS_TEKS_2)
                );
                etValue3.setText(
                        App.prefsManager.getString(PrefsManager.SESS_TEKS_3)
                );
                etValue4.setText(
                        String.valueOf( App.prefsManager.getInt(PrefsManager.SESS_NO_4) )
                );

                if (App.prefsManager.getBoolean(PrefsManager.SESS_BOOL_5)){
                    rbTrue.setChecked(true);
                } else {
                    rbFalse.setChecked(true);
                }
            }
        });
    }

    private void initActivity(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etValue1    = findViewById(R.id.etValue1);
        etValue2    = findViewById(R.id.etValue2);
        etValue3    = findViewById(R.id.etValue3);
        etValue4    = findViewById(R.id.etValue4);

        btnSimpan1  = findViewById(R.id.btnSimpan1);
        btnSimpan2  = findViewById(R.id.btnSimpan2);
        btnSimpan3  = findViewById(R.id.btnSimpan3);
        btnSimpan4  = findViewById(R.id.btnSimpan4);

        rgBoolean   = findViewById(R.id.rgBoolean);
        rbTrue      = findViewById(R.id.rbTrue);
        rbFalse     = findViewById(R.id.rbFalse);

        fab         = findViewById(R.id.fab);
    }

    private void setMessage(String string){
        Snackbar.make(fab, string + " disimpan!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            App.prefsManager.clear();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
