package com.profe.menulistas.test;

import com.profe.menulistas.R;
        import com.profe.menulistas.beans.CamisaBean;

        import java.util.ArrayList;


public class Modelo {

    public static ArrayList<CamisaBean> getCamisas(){

        ArrayList<CamisaBean> camisas = new ArrayList<>();

        camisas.add(new CamisaBean(500, "Camisa blanca", R.drawable.camisa1, 20));
        camisas.add(new CamisaBean(90, "Camisa roja", R.drawable.camisa1, 50));
        camisas.add(new CamisaBean(690, "Camisa azul", R.drawable.camisa1, 30));
        camisas.add(new CamisaBean(300, "Camisa verde", R.drawable.camisa1, 15));

        return camisas;

    }
}
