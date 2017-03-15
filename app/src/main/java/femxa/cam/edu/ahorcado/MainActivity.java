package femxa.cam.edu.ahorcado;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context ct;

    private void dibujarPanel (String palabra)
    {

        ViewGroup lugar_inflado = (ViewGroup)MainActivity.this.findViewById(R.id.lugar_inflado);

        /*int longi_palabra = palabra.length();

        for (int i = 0; i<longi_palabra; i++)*/
        //{
            LayoutInflater layoutInflater = MainActivity.this.getLayoutInflater(); //o LayoutInflater.from(a)
            View v1 = layoutInflater.inflate(R.layout.panel,lugar_inflado, false);

            View v2 = layoutInflater.inflate(R.layout.panel,lugar_inflado, false);
            /*layoutInflater.inflate(R.layout.panel,lugar_inflado, true);
            layoutInflater.inflate(R.layout.panel,lugar_inflado, true);
*/
        View[] array = {
        lugar_inflado.addView(v1),
        lugar_inflado.addView(v2)}


        lugar_inflado.addChildrenForAccessibility();
        mostrarLayout(findViewById(R.id.activity_main));
        //}

    }


    private void mostrarLayout(View vista)
    {
        Log.d(getClass().getCanonicalName(), vista.getClass().getCanonicalName());

        if (vista instanceof ViewGroup)
        {
            ViewGroup viewGroup = (ViewGroup) vista;

            for (int i = 0; i<viewGroup.getChildCount(); i++)
            {
                View vistahija = viewGroup.getChildAt(i);
                mostrarLayout(vistahija);

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dibujarPanel("Hola");


    }
}
