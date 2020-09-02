package com.skimy.infonavit.data.ui.benevits;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.skimy.infonavit.R;
import com.skimy.infonavit.data.models.BenevitClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BenevitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<BenevitClass> listDatos;
    private static final int TYPE_VIEW_DATA_LOCKED = 0;
    private static final int TYPE_VIEW_DATA_UNLOCKED = 1;
    private static final int TYPE_VIEW_SKELETON = 2;// 3 vistas para cada caso, lockes, unlocked, sin datos

    public void setdata(ArrayList<BenevitClass> listDatos) {
        this.listDatos = listDatos;
        notifyDataSetChanged();
    }//settear información para ell adaptador

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_VIEW_DATA_UNLOCKED) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_benevit_unlocked, parent, false);
            return new beneVitUnlockedViewHolder(view);
        } else if (viewType == TYPE_VIEW_DATA_LOCKED) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_benevit_locked, parent, false);
            return new beneVitLockedViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_benevit_skeleton, parent, false);
            return new beneVitSkeletonViewHolder(view);
        }

    }//viewholder de donde heredaran los adapters

    public class beneVitUnlockedViewHolder extends RecyclerView.ViewHolder {
        TextView dato;
        TextView region;
        TextView vence;
        ImageView logo;
        ImageView fondo;

        public beneVitUnlockedViewHolder(@NonNull View itemView) {

            super(itemView);
            dato = itemView.findViewById(R.id.description);
            region = itemView.findViewById(R.id.region);
            vence = itemView.findViewById(R.id.expire_date);
            fondo = itemView.findViewById(R.id.image_bkg);
            logo = itemView.findViewById(R.id.logo_benevit);
        }

        public void asignardatos(String descripción, String territorio, String expirationdate, String color, String Imagen) throws ParseException {
            dato.setText(descripción);
            region.setText(territorio);
            vence.setText("Vence en: " + convertirDate(expirationdate) + " días");
            fondo.invalidate();
            fondo.setBackgroundColor(Color.parseColor(color));
            Glide.with(itemView.getContext())
                    .load(Imagen)
                    .into(logo);

        }

        public String convertirDate(String Date) throws ParseException {
            java.util.Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = df.parse(Date);
            String TodayDate = df.format(c);
            long diff = (date.getTime() - c.getTime()) / (1000 * 60 * 60 * 24);
            String exirationDate = df.format(c);

            return (String.valueOf(diff));

        }
    }//adapter debenevit unlocked

    public class beneVitLockedViewHolder extends RecyclerView.ViewHolder {
        ImageView promo;

        public beneVitLockedViewHolder(@NonNull View itemView) {
            super(itemView);
            promo = itemView.findViewById(R.id.image_promo);
        }

        public void asignardatos(String imagen) {
            Glide.with(itemView.getContext())
                    .load(imagen)
                    .into(promo);
        }

    }//adapter de benevit locked

    public class beneVitSkeletonViewHolder extends RecyclerView.ViewHolder {
        ImageView promo;

        public beneVitSkeletonViewHolder(@NonNull View itemView) {
            super(itemView);

        }


    }//adapter de benevit vacio sin información

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (listDatos.isEmpty()) {

        } else {
            if (getItemViewType(position) == TYPE_VIEW_DATA_UNLOCKED) {
                beneVitUnlockedViewHolder holder1 = (beneVitUnlockedViewHolder) holder;
                try {
                    holder1.asignardatos(listDatos.get(position).getTitle()
                            , listDatos.get(position).getTerritories().get(0).getName(),
                            listDatos.get(position).getExpirationDate(),
                            listDatos.get(position).getPrimaryColor(), listDatos.get(position).getAlly().getMiniLogoFullPath());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                beneVitLockedViewHolder holder1 = (beneVitLockedViewHolder) holder;
                holder1.asignardatos(listDatos.get(position).getVectorFullPath());
            }
        }

        //getItemViewType(position);
    }//lógica de acuerdo al tipo view holder a usar en cada vista

    @Override
    public int getItemViewType(int position) {
        if (listDatos.isEmpty()) {
            return TYPE_VIEW_SKELETON;
        } else {
            if (listDatos.get(position).getLocked()) {
                return TYPE_VIEW_DATA_LOCKED;
            } else {
                return TYPE_VIEW_DATA_UNLOCKED;
            }
        }

    }//lógica para settear las vistas de acuerdo al caso

    @Override
    public int getItemCount() {
        if (listDatos.size() == 0) {
            return 5;
        } else {
            return listDatos.size();
        }
    }//si no existe infromación crear 5 objetos vacios para el skeleton, de lo contrario devolver tamaño del array
}
