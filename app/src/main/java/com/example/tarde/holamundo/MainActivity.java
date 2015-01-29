package com.example.tarde.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_CON_RESULTADO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //A partir de este punto se infla el XML y podemos invocar el handler
        View boton = findViewById(R.id.button);

        //Todos los botones son View. Todos los objetos View tienen onclick
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                intent.putExtra("dato","Mi nombre es Toño!");
                startActivity(intent);
            }
        });

        View botonConResultado = findViewById(R.id.btConResultado);

        //Todos los botones son View. Todos los objetos View tienen onclick
        botonConResultado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ConResultadoActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CON_RESULTADO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_CON_RESULTADO){
            if(resultCode == Activity.RESULT_OK){
                String resultado = data.getStringExtra("resultado");
                Toast.makeText(this,"El resultado es: " + resultado, Toast.LENGTH_LONG).show();
            }else{
                Log.i(MainActivity.class.getName(),"El resultado de la peticion no ha sido correcto: "+resultCode);
            }
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
