package com.nyt.ankit;

import android.app.Application;

import com.nyt.ankit.network.AppComponent;
import com.nyt.ankit.network.AppModule;
import com.nyt.ankit.network.DaggerAppComponent;
import com.nyt.ankit.network.NetWorkModule;

/**
 * Created by Ankit Khandelwal on 13-03-2018.
 */

public class NewYorkTimesApplication  extends Application {

    private AppComponent appComponent;



    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netWorkModule(new NetWorkModule())
                .build();

    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}