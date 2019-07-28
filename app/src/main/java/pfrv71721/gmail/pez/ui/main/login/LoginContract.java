package pfrv71721.gmail.pez.ui.main.login;

import android.content.Context;


public interface LoginContract {

    interface Model {

        void sendServer(OnFinishedListener onFinishedListener, String user, String password, Context context);
        interface OnFinishedListener {
            //  void onFinished(LoginResponse response);

            void openMainActivity();
            void showErrorCredentials();

            void onFailure(Throwable t);
        }
    }


    interface View {

        void showProgress();

        void hideProgress();

        void openMainActivityView();


        void showToastError(String error);

        void enableViews(android.view.View... views);
        void disableViews(android.view.View... views);
    }


    interface Presenter {
        void attemptLogin(String user, String password, Context context);
    }
}
