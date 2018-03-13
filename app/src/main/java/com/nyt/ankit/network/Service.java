package com.nyt.ankit.network;

import android.util.Log;

import com.nyt.ankit.model.Response;

import java.util.List;

import okhttp3.MultipartBody;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ankit Khandelwal on 09-05-2017.
 */

public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }



    public Subscription getBaseURL(final ResponseCallback<Response> responseCallback)
    {
        return networkService.getBaseURL()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        Log.e("Subscription ","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(Response response) {
                        responseCallback.onSuccess(response);
                    }
                });
    }


    //<editor-fold desc="GENERIC CALLBACK">
    public abstract interface ResponseCallback<T> {
        void onSuccess(T response);

        void onError(NetworkError networkError);
    }
    //</editor-fold>

}
