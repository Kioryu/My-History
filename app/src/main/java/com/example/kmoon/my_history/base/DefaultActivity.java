package com.example.kmoon.my_history.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kmoon.my_history.R;
import com.example.kmoon.my_history.utils.Dialog;
import com.example.kmoon.my_history.utils.Json;
import com.example.kmoon.my_history.utils.OnBackPressedHandler;
import com.example.kmoon.my_history.utils.SharedDB;

import org.json.JSONObject;


public class DefaultActivity extends AppCompatActivity {

    protected SharedDB myInfoSp;
    protected Json myinfoJson = new Json();

    protected Dialog dl;

    private OnBackPressedHandler obp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.bind();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        this.obp.onBackPressed();
    }

    public void startActivityIntent(Class<?> cls) {
        startActivity(new Intent(this, cls));
        this.finish();
    }

    private void bind() {
        this.myInfoSp = new SharedDB(this, getString(R.string.default_myInfo), getString(R.string.default_empty));

        this.dl = new Dialog(this);

        this.obp = new OnBackPressedHandler(this);

        this.myinfoJson.init(new JSONObject());
    }
}
