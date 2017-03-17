package femxa.cam.edu.ahorcado;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    private Context ct;

    //final EditText editText = (EditText) findViewById(R.id.letra1);


    private void actualizarPanel(String cadena, char letra)
    {

    }

    public void escribirNumero(View boton)
    {
        // declaramos variables y hacemos el casteo del boton para usarle
        Button btnPulsado = (Button) boton;
        String pulsado=  btnPulsado.getText().toString();//cogemos el texto del boton pulsado
        String palabra="ISABEL";//nos creamos un string que le pasaremos al metodo

        //nos creamos una variable boleana que nos dara si es falso o verdadero con lo que salga del metodo
        // haremos una condicion if en la que nos dira si la encuentra que cambie el texto del boton y lo ponga del color verde
        //sino que la ponga de color rojo y no deje pulsarla otra vez la deshabilita
        boolean encontrada=buscarLetra(pulsado, palabra);
        if(encontrada)
        {

            //btnPulsado.setTextColor(Color.rgb(34, 153, 84));
        }
        else {
            //btnPulsado.setTextColor(Color.RED);
            //btnPulsado.setEnabled(false);
        }
    }

    public void identificarEditText(ViewGroup rowLugarInflado1, ViewGroup rowLugarInflado2, ViewGroup rowLugarInflado3, ViewGroup rowLugarInflado4)
    {
        int cont_aux = 0;

        try {


            for (int i = 0; i < rowLugarInflado1.getChildCount(); i++) {
                ViewGroup linear = (ViewGroup) rowLugarInflado1.getChildAt(i);
                EditText et = (EditText) linear.getChildAt(0);
                et.setId(i);
                Log.d("MENSAJE", "editado EditText n: " + i);
                Log.d("MENSAJE", "Id de EditText: " + et.getId());
                cont_aux++;
            }

            Log.d("MENSAJE", rowLugarInflado2.toString());
            if (rowLugarInflado2 != null) {

                for (int i = 0; i < (rowLugarInflado2.getChildCount()); i++) {

                    ViewGroup linear = (ViewGroup) rowLugarInflado2.getChildAt(i);
                    EditText et = (EditText) linear.getChildAt(0);
                    Log.d("MENSAJE", et.toString());
                    et.setId(cont_aux);
                    Log.d("MENSAJE", "editado EditText n: " + cont_aux);
                    Log.d("MENSAJE", "Id de EditText: " + et.getId());
                    cont_aux++;
                }
            } else {
                Log.d("MENSAJE", "no hay segunda fila");
            }

            if (rowLugarInflado3 != null) {
                int cont_aux2 = 0;
                cont_aux2 = cont_aux;
                for (int i = 0; i < (rowLugarInflado2.getChildCount()); i++) {
                    ViewGroup linear = (ViewGroup) rowLugarInflado3.getChildAt(i);
                    EditText et = (EditText) linear.getChildAt(0);
                    et.setId(cont_aux);
                    Log.d("MENSAJE", "editado EditText n: " + cont_aux);
                    Log.d("MENSAJE", "Id de EditText: " + et.getId());
                    cont_aux++;
                }
            } else {
                Log.d("MENSAJE", "no hay tercera fila");
            }

            if (rowLugarInflado4 != null) {
                int cont_aux2 = 0;
                cont_aux2 = cont_aux;
                for (int i = 0; i < (rowLugarInflado2.getChildCount()); i++) {
                    ViewGroup linear = (ViewGroup) rowLugarInflado4.getChildAt(i);
                    EditText et = (EditText) linear.getChildAt(0);
                    et.setId(cont_aux);
                    Log.d("MENSAJE", "editado EditText n: " + cont_aux);
                    Log.d("MENSAJE", "Id de EditText: " + et.getId());
                    cont_aux++;
                }
            } else {
                Log.d("MENSAJE", "no hay cuarta fila");
            }
        } catch (Throwable t)
        {
            Log.e("MENSAJE" , "ERROR", t);
        }
    }


    public boolean  buscarLetra(String letra, String palabra)
    {
        boolean encontrado = false;
        char letrita = letra.charAt(0);
        for (int i = 0; i < palabra.length(); i++)
        {
            if (letrita == palabra.charAt(i))
            {
                encontrado = true;
            }
        }

        return encontrado;
    }

    public void mostrarLetra(String letra, String palabra)
    {

        char letrita = letra.charAt(0);
        for (int i = 0; i < palabra.length(); i++)
        {
            if (letrita == palabra.charAt(i))
            {
                EditText et = (EditText)findViewById(i);
                et.setText(letrita+"");
                Log.d("MENSAJE", "HA ENCONTRADO LA LETRA " + letrita);

            }
        }
    }

    public void ocultarEspacios(String palabra)
    {

        char letrita = ' ';
        for (int i = 0; i < palabra.length(); i++)
        {
            if (letrita == palabra.charAt(i))
            {
                EditText et = (EditText)findViewById(i);
                et.setVisibility(View.INVISIBLE);
                Log.d("MENSAJE", "HA ENCONTRADO LA LETRA " + letrita);

            }
        }
    }

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
        dibujarPanel("La vida es bella");
        TableRow fila1 = (TableRow)findViewById(R.id.lugar_inflado);
        TableRow fila2 = (TableRow)findViewById(R.id.lugar_inflado2);
        TableRow fila3 = (TableRow)findViewById(R.id.lugar_inflado3);
        TableRow fila4 = (TableRow)findViewById(R.id.lugar_inflado4);

        fila1 = (fila1.getChildCount() == 0) ? null : fila1;
        fila2 = (fila2.getChildCount() == 0) ? null : fila2;
        fila3 = (fila3.getChildCount() == 0) ? null : fila3;
        fila4 = (fila4.getChildCount() == 0) ? null : fila4;

        identificarEditText(fila1, fila2, fila3, fila4);
        mostrarLetra("a", "La vida es bella");
        mostrarLetra("e", "La vida es bella");
        ocultarEspacios("La vida es bella");


    }
}
