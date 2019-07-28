package pfrv71721.gmail.pez.ui.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import pfrv71721.gmail.pez.R;
import pfrv71721.gmail.pez.ui.main.table.TableListActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.label_login_user)
    EditText labelLoginUser;
    @BindView(R.id.label_login_login)
    EditText labelLoginLogin;
    @BindView(R.id.label_login_btn_login)
    Button mLoginButton;

    //private SessionManager manager;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.label_login_btn_login)
    public void onViewClicked() {
        startActivity(new Intent(this, TableListActivity.class));
        finish();
        //presenter.attemptLogin(labelLoginUser.getText().toString(), labelLoginLogin.getText().toString(),this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void openMainActivityView() {
        finish();
        //startActivity(new Intent(LoginActivity.this, LoginActivity.class));
    }

    @Override
    public void showToastError(String error) {
        Toasty.error(LoginActivity.this, error).show();
    }

    @Override
    public void enableViews(View... views) {
        for (View view : views) {
            view.setEnabled(true);
        }

        mLoginButton.setEnabled(true);
    }

    @Override
    public void disableViews(View... views) {
        for (View view : views) {
            view.setEnabled(false);
        }

        mLoginButton.setEnabled(false);
    }


}
