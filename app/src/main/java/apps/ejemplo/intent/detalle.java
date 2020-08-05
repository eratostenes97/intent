package apps.ejemplo.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class detalle extends AppCompatActivity {
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);

        String nombre = getIntent().getStringExtra("dato");
        tv2.setText(nombre);
        String fecha = getIntent().getStringExtra("fecha");
        tv3.setText("fecha de nacimiento: " + fecha);
        String telefono = getIntent().getStringExtra("telefono");
        tv4.setText(telefono);
        String correo = getIntent().getStringExtra("correo");
        tv5.setText(correo);

        String descripcion = getIntent().getStringExtra("descripcion");
        tv6.setText(descripcion);


    }
    public void regresar(View vista){

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("nombre", tv2.getText().toString());
        i.putExtra("fecha", tv3.getText().toString());
        i.putExtra("telefono", tv4.getText().toString());
        i.putExtra("correo", tv5.getText().toString());
        i.putExtra("descripcion", tv6.getText().toString());
        startActivity(i);

    }
}
