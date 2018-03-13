package com.nyt.ankit.network;

import com.nyt.ankit.model.Response;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by Ankit Khandelwal on 09-05-2017.
 */

public interface NetworkService {


    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=aea8b7c7a56e4bdd994a1325a61869ec")
    Observable<Response> getBaseURL();
}
