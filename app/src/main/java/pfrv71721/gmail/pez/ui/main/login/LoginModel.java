package pfrv71721.gmail.pez.ui.main.login;

import android.content.Context;
import android.util.Log;

import pfrv71721.gmail.pez.SessionManager;
import pfrv71721.gmail.pez.network.ApiClient;
import pfrv71721.gmail.pez.network.ApiInterface;
import pfrv71721.gmail.pez.ui.main.login.data.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.Model {

    private SessionManager manager;

    @Override
    public void sendServer(OnFinishedListener onFinishedListener, String user, String password, Context context) {

       // manager = new SessionManager(context);


        ApiInterface apiService = ApiClient.getCliente().create(ApiInterface.class);
        Call<LoginResponse> call = apiService.signInWithEmailAndPassword(user, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (!response.isSuccessful()) {
                    Log.e("code", "code: " + response.code());
                    return;
                }
                LoginResponse log=response.body();
                Log.e("onResponse", log.isError()+"");




                if (!log.isError()){
                    // user successfully logged in
                    // Create login session
                    manager.setLogin(true);

                    // Now store the userId in SharedPreferences
                    manager.setId(log.getIdEmpleado());

                    onFinishedListener.openMainActivity();
                }else {
                    onFinishedListener.showErrorCredentials();
                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
                onFinishedListener.onFailure(t);
            }
        });

    }
}
