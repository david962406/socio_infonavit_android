package com.skimy.infonavit.data.ui.benevits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skimy.infonavit.R;
import com.skimy.infonavit.data.models.BenevitClass;
import com.skimy.infonavit.data.models.walletClass;

import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.Adapter {
    ArrayList<walletClass> listDatos = new ArrayList<>();
    ArrayList<BenevitClass> benevits = new ArrayList<>();
    private static final int TYPE_VIEW_DATA = 0;
    private static final int TYPE_VIEW_SKELETON = 1;

    public void setData(ArrayList<walletClass> listDatos) {
        this.listDatos = listDatos;
        notifyDataSetChanged();
    }//metodo para agregar datos wallet

    public void setBenevits(ArrayList<BenevitClass> listBenevits) {
        this.benevits = listBenevits;
        notifyDataSetChanged();
    }//método para agregar datos benevits

    @Override
    public ViewHolderWallet onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_VIEW_DATA) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vertical__wallet, parent, false);
            return new ViewHolderWallet(view);// elegir vista}
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vertical__wallet_skeleton, parent, false);
            return new ViewHolderWallet(view);// elegir vista}
        }
    }//lógica para definir que vista usar en el view holder, si hay información o no

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArrayList<BenevitClass> benevitsAux = new ArrayList<BenevitClass>();

        if (getItemViewType(position) == TYPE_VIEW_DATA) {
            for (int i = 0; i < benevits.size(); i++) {
                if (listDatos.get(position).getId() == benevits.get(i).getWallet().getId()) {
                    benevitsAux.add(benevits.get(i));
                }
            }
            ((ViewHolderWallet) holder).asignardatos(listDatos.get(position).getName(), benevitsAux);
        }
    }//binding de la clase wallet y benevits emparejandolos de acuerdo al tipo de wallet


    @Override
    public int getItemViewType(int position) {
        if (listDatos.isEmpty()) {
            return TYPE_VIEW_SKELETON;
        } else {
            return TYPE_VIEW_DATA;
        }
        // return super.getItemViewType(position);
    }//lógica de si existe data para setear la vista ya sea vacia o con datos

    @Override
    public int getItemCount() {
        if (listDatos.size() == 0) {
            return 5;
        } else {
            return listDatos.size();
        }
    }//determinar si no hay datos agregar 5 espacios vacios o si los hay devolver su tamaño del arreglo

    public class ViewHolderWallet extends RecyclerView.ViewHolder {
        TextView dato;
        RecyclerView recycler;
        BenevitAdapter benevitAdapter;


        public ViewHolderWallet(View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.title);
            recycler = itemView.findViewById(R.id.benevit_recycler);
            benevitAdapter = new BenevitAdapter();
            recycler.setAdapter(benevitAdapter);


        }


        public void asignardatos(String s, ArrayList<BenevitClass> benevits) {
            dato.setText(s);
            benevitAdapter.setdata(benevits);
        }//pasando datos para el header ye el recyclerview
    }//binding del wallet


}
