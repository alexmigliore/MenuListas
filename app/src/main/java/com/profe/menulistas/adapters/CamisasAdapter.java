package com.profe.menulistas.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.profe.menulistas.R;
import com.profe.menulistas.beans.CamisaBean;

import java.util.List;

public class CamisasAdapter extends ArrayAdapter<CamisaBean>{
    private Context context;
    private int resource;
    private List<CamisaBean> objects;

    public CamisasAdapter(Context context, int resource, List<CamisaBean> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.objects=objects;
    }

    class ViewHolder{
        TextView txtDescripcion, txtPrecio;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if(view==null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource,null);
            viewHolder.txtDescripcion = (TextView) view.findViewById(R.id.txtDescripcion);
            viewHolder.txtPrecio = (TextView) view.findViewById(R.id.txtPrecio);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        CamisaBean camisaBean = objects.get(position);

        viewHolder.txtDescripcion.setText(camisaBean.getDescripcion());
        viewHolder.txtPrecio.setText(String.valueOf(camisaBean.getPrecio()));
        return view;
    }
}
