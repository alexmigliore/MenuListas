package com.profe.menulistas.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.profe.menulistas.R;
import com.profe.menulistas.beans.CamisaBean;
import com.profe.menulistas.fragments.ListCamisasFragment;

public class CamisaActivity extends AppCompatActivity {

    private ImageView imgCamisa;
    private TextView txtDescripcion, txtPrecio, txtCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camisa);

        CamisaBean camisaBean = (CamisaBean) getIntent().getSerializableExtra(ListCamisasFragment.CAMISA_KEY);

        imgCamisa = (ImageView) findViewById(R.id.imgCamisa);

        txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        txtPrecio = (TextView) findViewById(R.id.txtPrecio);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);

        txtCantidad.setText(String.valueOf(camisaBean.getCantidad()));
        txtPrecio.setText(String.valueOf(camisaBean.getPrecio()));
        txtDescripcion.setText(camisaBean.getDescripcion());

        imgCamisa.setImageDrawable(ContextCompat.getDrawable(this,camisaBean.getFoto()));
    }
}
