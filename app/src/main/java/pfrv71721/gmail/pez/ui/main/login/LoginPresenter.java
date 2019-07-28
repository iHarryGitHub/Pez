package pfrv71721.gmail.pez.ui.main.login;

import android.content.Context;

public class LoginPresenter implements LoginContract.Presenter,LoginContract.Model.OnFinishedListener {

    private LoginContract.Model model;
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view){
        this.view=view;
        model = new LoginModel();
    }


    @Override
    public void attemptLogin(String user, String password, Context context) {

        if (view!= null){
            view.showProgress();
            view.disableViews();
        }
        model.sendServer(this, user, password,context);

    }



    @Override
    public void openMainActivity() {
        view.openMainActivityView();

        if (view!=null){
         //   view.hideProgress();
        }
    }

    @Override
    public void showErrorCredentials() {
        if (view!=null){
            view.hideProgress();
            view.enableViews();
        }
        view.showToastError("Credenciales invalidas");
    }

    @Override
    public void onFailure(Throwable t) {
        view.showToastError(t.getMessage());

    }
}
