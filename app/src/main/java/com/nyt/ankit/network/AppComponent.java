package com.nyt.ankit.network;



import com.nyt.ankit.activity.MainActivity;
import com.nyt.ankit.fragment.MasterFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {NetWorkModule.class, AppModule.class})
public interface AppComponent {

//    void inject(UploadImageFragment uploadImageFragment);
    void inject(MainActivity mainActivity);
    void inject(MasterFragment masterFragment);
}
