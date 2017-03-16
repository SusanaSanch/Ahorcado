package femxa.cam.edu.ahorcado;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context ct;

    private void dibujarPanel (String cadena)
    {

        ViewGroup lugar_inflado = (ViewGroup)MainActivity.this.findViewById(R.id.lugar_inflado);
        ViewGroup lugar_inflado2 = (ViewGroup)MainActivity.this.findViewById(R.id.lugar_inflado2);
        ViewGroup lugar_inflado3 = (ViewGroup)MainActivity.this.findViewById(R.id.lugar_inflado3);
        ViewGroup lugar_inflado4 = (ViewGroup)MainActivity.this.findViewById(R.id.lugar_inflado4);

        int longi_palabra = cadena.length();
        LayoutInflater layoutInflater = MainActivity.this.getLayoutInflater(); //o LayoutInflater.from(a)

        String[] lista_palabra = cadena.split(" ");
        int pos_palabra = 0;
        int n_linea = 1;
        int caracteres_linea_actual = 0;

        for (int i = 0; i<longi_palabra; i++)
        {
            /*
            //FUNCIONALIDAD EJEMPLO SIN CONTAR PALABRAS
            if(i<=10)
            {
                View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado, true);
            }
            else if(i<=20)
            {
                View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado2, true);
            }
            else if(i<=30)
             {
            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado3, true);
             }
             else if(i<=40)
             {
            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado4, true);
            }*/
           // if(i<=10)

            /*
            //CONTANDO LÍNEAS CON if
            {
             /*
                if(cadena.charAt(i)==' ')
                {
                    pos_palabra++;
                }
                if((lista_palabra[pos_palabra].length() + i) < 10) {
                    View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado, true);
                    caracteres_linea_actual++;
                }
                else
                {
                    caracteres_linea_actual = 0;

                }

                if((lista_palabra[pos_palabra].length() + i) < 20)
            {
                View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado2, true);
            }
            else if(i<=30)
            {
                View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado3, true);
            }
            else if(i<=40)
            {
                View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado4, true);
            }*/


            // CONTAR LÍNEAS CON SWITCH
            switch (n_linea)
            {
                case 1:
                    if(cadena.charAt(i)==' ')
                    {
                        pos_palabra++;
                        if (lista_palabra[pos_palabra].length() + caracteres_linea_actual < 10)
                        {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado, true);
                            caracteres_linea_actual++;
                            Log.d("MENSAJE", "if Case 1: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        } else
                            {
                                View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado2, true);
                                caracteres_linea_actual = 1;
                                n_linea = 2;
                                Log.d("MENSAJE", "Else Case 1: letra " + cadena.charAt(i) + ", linea " + n_linea);
                            }
                    }
                    else
                    {
                        View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado, true);
                        caracteres_linea_actual++;
                        Log.d("MENSAJE", "Case 1: letra " + cadena.charAt(i) + ", linea " + n_linea);
                    }

                    break;

                case 2:
                    if(cadena.charAt(i)==' ')
                    {
                        pos_palabra++;
                        if (lista_palabra[pos_palabra].length() + caracteres_linea_actual < 10) {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado2, true);
                            caracteres_linea_actual++;
                            Log.d("MENSAJE", "Case 2: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        } else {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado3, true);
                            caracteres_linea_actual = 1;
                            n_linea = 3;
                            Log.d("MENSAJE", "Else Case 2: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        }
                    }
                        else
                        {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado2, true);
                            caracteres_linea_actual++;
                            Log.d("MENSAJE","Case 2: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        }



                    break;
                case 3:
                    if(cadena.charAt(i)==' ')
                    {
                        pos_palabra++;

                        if(lista_palabra[pos_palabra].length()+caracteres_linea_actual<10)
                        {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado3, true);
                            caracteres_linea_actual++;
                            Log.d("MENSAJE", "Case 3: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        }
                        else
                        {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado4, true);
                            caracteres_linea_actual = 1;
                            n_linea = 4;
                            Log.d("MENSAJE", "Else Case 3: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        }
                    }
                    else
                    {
                        View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado3, true);
                        caracteres_linea_actual++;
                        Log.d("MENSAJE", "Case 3: letra " + cadena.charAt(i) + ", linea " + n_linea);
                    }


                    break;

                case 4:
                    if(cadena.charAt(i)==' ')
                    {
                        pos_palabra++;

                        if(lista_palabra[pos_palabra].length()+caracteres_linea_actual<10)
                        {
                            View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado4, true);
                            caracteres_linea_actual++;
                            Log.d("MENSAJE", "Case 4: letra " + cadena.charAt(i) + ", linea " + n_linea);
                        }
                        else
                        {
                            Log.d("MENSAJE", "La cadena tiene más extensión de la permitida");
                        }
                    }
                    else
                    {
                        View v1 = layoutInflater.inflate(R.layout.panel, lugar_inflado4, true);
                        caracteres_linea_actual++;
                        Log.d("MENSAJE", "Case 4: letra " + cadena.charAt(i) + ", linea " + n_linea);
                    }


                    break;

                default:

                    break;

            }



            //mostrarLayout(findViewById(R.id.activity_main));
        }

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

        //dibujarPanel("star wars el despertar de la fuerza");
        dibujarPanel("Lavidaesbella");


    }
}
