package com.skimy.infonavit.data.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.skimy.infonavit.R;
import com.skimy.infonavit.data.models.userjson;
import com.skimy.infonavit.data.models.userClass;
import com.skimy.infonavit.data.network.APIService;
import com.skimy.infonavit.data.network.retrofitClient;
import com.skimy.infonavit.data.models.user;
import com.skimy.infonavit.data.ui.benevits.benevitsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Activity_Splash_Login extends AppCompatActivity {
    private APIService mAPIService;
    private static int TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_login);
        EditText email=(EditText)findViewById(R.id.email_edit);
        EditText password=(EditText)findViewById(R.id.password_edit);
        Button loginBtn=(Button)findViewById(R.id.button_login);
        SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String token = preferences.getString("token","");


        loginBtn.setEnabled(false);
        if (token!=""){
            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Activity_Splash_Login.this, benevitsActivity.class);
                startActivity(i);

            }
        }, TIME_OUT);
        }

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && password.getText().toString().isEmpty()==false){
                    loginBtn.setEnabled(true);
                }
                else{
                    loginBtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && email.getText().toString().isEmpty()==false){
                    loginBtn.setEnabled(true);
                }
                else{
                    loginBtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (i== KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    //Toast.makeText(Activity_Splash_Login.this, password.getText(), Toast.LENGTH_SHORT).show();
                    logintmethod(email.getText().toString(),password.getText().toString());
                    return true;
                }
                return false;
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               logintmethod(email.getText().toString(),password.getText().toString());
            }
        });


}


public void getUserToken(){

}
public void logintmethod(String mailtxt,String passwordtxt) {
    Retrofit retrofit=retrofitClient.getClient();
    APIService api=retrofit.create(APIService.class);
    Call<userClass> call=api.login_infonavit(new userjson(new user(mailtxt,passwordtxt)));
    call.enqueue(new Callback<userClass>() {
        @Override
        public void onResponse(Call<userClass> call, Response<userClass> response) {
            if(response.raw().code()==401)
            {   new AlertDialog.Builder(Activity_Splash_Login.this)
                    .setTitle("Usuario y contraseña incorrectos")
                    .setMessage("Intenta nuevamente")
                    .setPositiveButton(android.R.string.ok, null)
                    .show();            }
            else if (response.isSuccessful()){{
                SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                Log.d("test",response.headers().get("Authorization").toString());
                //preferences.edit().putString("token", response.headers().get("Authorization").toString()).commit();
                preferences.edit().putString("token", response.headers().get("Authorization").toString()).commit();
                Intent i = new Intent(getApplicationContext(),benevitsActivity.class);
                startActivity(i);
                    /*SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();*/
            }
            }
        }



        @Override
        public void onFailure(Call<userClass> call, Throwable t) {
            Log.d("test",t.toString());
        }
    });

}
    @Override
    protected void onResume() {
        super.onResume();
    }
}

