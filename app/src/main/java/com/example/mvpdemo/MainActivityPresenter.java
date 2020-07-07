package com.example.mvpdemo;

public class MainActivityPresenter implements MainActivityContract.Presenter{

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {
        // email test@live.com
        // password pass@123
        if(email.equals("test@gmail.com") && password.equals("pass123")){
        view.onSuccess("Successful");
        }
        else{
            view.onError("Wrong Email or Password");
        }

    }
}
