package pfrv71721.gmail.pez;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pfrv71721.gmail.pez.ui.ProfileActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginBtn(View view) {
        startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
        finish();
    }
}
