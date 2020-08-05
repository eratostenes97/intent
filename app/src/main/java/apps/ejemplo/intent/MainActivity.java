package apps.ejemplo.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {

    private Button mdatepicker;

    private TextView tv8;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatepicker = (Button)findViewById(R.id.datapicker_btn);
        tv8 = (TextView)findViewById(R.id.tv8);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);


        String nombre = getIntent().getStringExtra("nombre");
        et1.setText(nombre);
        String fecha = getIntent().getStringExtra("fecha");
        tv8.setText(fecha);
        String telefono = getIntent().getStringExtra("telefono");
        et2.setText(telefono);
        String correo = getIntent().getStringExtra("correo");
        et4.setText(correo);

        String descripcion = getIntent().getStringExtra("descripcion");
        et3.setText(descripcion);

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText("SELECCIONE UNA FECHA");
        final MaterialDatePicker materialDatePicker = builder.build();

        mdatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                tv8.setText(materialDatePicker.getHeaderText());

            }
        });




    }
    public void pasardatos(View vista){

        Intent i = new Intent(this, detalle.class);
        i.putExtra("dato", et1.getText().toString());
        i.putExtra("fecha", tv8.getText().toString());
        i.putExtra("telefono", et2.getText().toString());
        i.putExtra("correo", et4.getText().toString());
        i.putExtra("descripcion", et3.getText().toString());
        startActivity(i);


    }



}
