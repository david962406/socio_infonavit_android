package com.skimy.infonavit.data.ui.benevits;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skimy.infonavit.R;
import com.skimy.infonavit.data.network.APIService;
import com.skimy.infonavit.data.models.BenevitClass;
import com.skimy.infonavit.data.models.LandingResponse;
import com.skimy.infonavit.data.network.retrofitClient;
import com.skimy.infonavit.data.models.walletClass;
import com.skimy.infonavit.data.ui.login.Activity_Splash_Login;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class benevitsActivity extends AppCompatActivity  {
    RecyclerView recycler;
    ArrayList<walletClass> wallets=new ArrayList<>();
    ArrayList<BenevitClass> benevits=new ArrayList<>();
    private  walletViewModel walletvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.navigation_drawer);
        Toolbar toolbar=findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        ImageView menu=(ImageView)findViewById(R.id.menulines);
        TextView logout=(TextView)findViewById(R.id.logout);
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        walletvm= new ViewModelProvider(this).get(walletViewModel.class);
        walletvm.getWallets().observe(this, new Observer<ArrayList<walletClass>>() {
            @Override
            public void onChanged(ArrayList<walletClass> walletClasses) {
                Log.d("jeje",walletClasses.toString());
            }
        });
        View.OnClickListener btnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.open();
                //logout.setOnContextClickListener((View.OnContextClickListener) logoutmethod);
            }
        };


        menu.setOnClickListener(btnClick);
        logout.setOnClickListener(new View.OnClickListener() {  // View.OnClickListener.
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("¿Seguro que quieres cerrar sesión?")
                        .setMessage("Si aceptas deberas ingresar tus datos nuevamente en un futuro")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                logoutmethod();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .show();

                // activityName.this insteade of getApplicationContext.
            }
        });
        recycler=(RecyclerView)findViewById(R.id.recyclerwallet);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        wallets=new ArrayList<walletClass>();
        WalletAdapter adaptador=new WalletAdapter();

        Retrofit retrofit= retrofitClient.getClient();
        APIService api=retrofit.create(APIService.class);
        Call<ArrayList<walletClass>> call=api.getwallets();

        call.enqueue(new Callback<ArrayList<walletClass>>() {

            @Override
            public void onResponse(Call<ArrayList<walletClass>> call, Response<ArrayList<walletClass>> response) {
                Log.d("test","no tas registrao chao");
                wallets.addAll(response.body());
                adaptador.setData(wallets);
                recycler.setAdapter(adaptador);
            }

            @Override
            public void onFailure(Call<ArrayList<walletClass>> call, Throwable t) {
                Log.d("test",t.toString());
            }
        });
        SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);

        Call<LandingResponse> call2=api.getBenevits(preferences.getString("token",""));
        call2.enqueue(new Callback<LandingResponse>() {
            @Override
            public void onResponse(Call<LandingResponse> call, Response<LandingResponse> response) {
                Log.d("test","no tas registrao chao");
                ArrayList<BenevitClass> benevitsAux=new ArrayList<>();
                benevitsAux.addAll(response.body().getLocked());
                for( int i=0; i<benevitsAux.size();i++){

                    benevitsAux.get(i).setLocked(true);
                }
                benevits.addAll(benevitsAux);
                benevitsAux.clear();
                benevitsAux.addAll(response.body().getUnlocked());
                for( int i=0; i<benevitsAux.size();i++){

                    benevitsAux.get(i).setLocked(false);
                }
                benevits.addAll(benevitsAux);
                adaptador.setBenevits(benevits);
            }

            @Override
            public void onFailure(Call<LandingResponse> call, Throwable t) {
                Log.d("test",t.toString());
            }
        });



    }




    public void logoutmethod(){

            SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            Retrofit retrofit= retrofitClient.getClient();
            APIService api=retrofit.create(APIService.class);
            Call<Response<String>> call=api.logout();
            call.enqueue(new Callback<Response<String>>() {
                @Override
                public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {

                }

                @Override
                public void onFailure(Call<Response<String>> call, Throwable t) {

                }
            });
            Intent i = new Intent(getApplicationContext(), Activity_Splash_Login.class);
            startActivity(i);}

}