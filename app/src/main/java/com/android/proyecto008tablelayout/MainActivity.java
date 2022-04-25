package com.android.proyecto008tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    //Variable inicial
    private String jugador = "x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Inicialización de los botones
        btn1 = findViewById(R.id.id_btn1);
        btn2 = findViewById(R.id.id_btn2);
        btn3 = findViewById(R.id.id_btn3);
        btn4 = findViewById(R.id.id_btn4);
        btn5 = findViewById(R.id.id_btn5);
        btn6 = findViewById(R.id.id_btn6);
        btn7 = findViewById(R.id.id_btn7);
        btn8 = findViewById(R.id.id_btn8);
        btn9 = findViewById(R.id.id_btn9);
    }

    //Evento para los botones
    public void onClickPresion(View view) {
        //Boton
        Button b = (Button)view;


        //Validamos que no cambien el simbolo del boton con un click
        if(b.getText().toString().equals("")){
            //Se le emvía la letra "x" al botón
            b.setText(jugador);

            //Verificar si el jugador ganó
            verificarGano(jugador);
            //Llamamos al método que valida que sea "x" u "o"
            cambiarJugador();
        }
    }

    //Como su nombre lo dice, lo usamos para ver si gano
    private void verificarGano(String turno) {
        //Convertimos el dato recibido deel boton y los pasamos a texto
        String casilla1 = btn1.getText().toString();
        String casilla2 = btn2.getText().toString();
        String casilla3 = btn3.getText().toString();
        String casilla4 = btn4.getText().toString();
        String casilla5 = btn5.getText().toString();
        String casilla6 = btn6.getText().toString();
        String casilla7 = btn7.getText().toString();
        String casilla8 = btn8.getText().toString();
        String casilla9 = btn9.getText().toString();

        //Verificamos que en las filas, columnas y diagonales estén llenas con el mismo símbolo

        //Hacemos refencia al btn1 con la casilla1 y verficamos que sea el jugador1 con el parámetro turno
        //Y así sucesivamente con todos los botones y turnos
        if (casilla1.equals(turno)&& casilla2.equals(turno) && casilla3.equals(turno))
            gano(turno);
        if (casilla4.equals(turno)&& casilla5.equals(turno) && casilla6.equals(turno))
            gano(turno);
        if (casilla7.equals(turno)&& casilla8.equals(turno) && casilla9.equals(turno))
            gano(turno);

        if (casilla1.equals(turno)&& casilla4.equals(turno) && casilla7.equals(turno))
            gano(turno);
        if (casilla2.equals(turno)&& casilla5.equals(turno) && casilla8.equals(turno))
            gano(turno);
        if (casilla3.equals(turno)&& casilla6.equals(turno) && casilla9.equals(turno))
            gano(turno);
    }

    //En caso que el jugador halla ganao procedecmos con éste método
    public void gano(String jugador) {
        //Mensaje para el jugador que ganó
        Toast.makeText(this, "Ganó el jugador" + jugador, Toast.LENGTH_LONG).show();

        //En está parte procedemos a deshabilitar los botonoes para que los jugaores no puedan hacer nada más
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    //Método para colocar en los botones "x" u "o"
    private void cambiarJugador() {
        if (jugador.equals("x")){
            jugador="o";
        }else{
            jugador="x";
        }
    }

    //Método para salir de la aplicación
    public void onClickSalir(View view) {
        finish();
    }
}