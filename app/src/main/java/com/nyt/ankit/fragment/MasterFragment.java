package com.nyt.ankit.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nyt.ankit.NewYorkTimesApplication;
import com.nyt.ankit.R;
import com.nyt.ankit.activity.MainActivity;
import com.nyt.ankit.adapter.MyAdapter;
import com.nyt.ankit.model.Response;
import com.nyt.ankit.network.NetworkError;
import com.nyt.ankit.network.Service;
import com.nyt.ankit.utils.Constant;
import com.nyt.ankit.utils.FragmentHelper;
import com.nyt.ankit.utils.NewYorkTimesProgressDialog;

import javax.inject.Inject;

/**
 * Created by Ankit Khandelwal on 13-03-2018.
 */

public class MasterFragment extends Fragment{

    @Inject
    Service service;
    private NewYorkTimesProgressDialog newYorkTimesProgressDialog;
    private NewYorkTimesApplication newYorkTimesApplication;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         /* injecting dependency */
        newYorkTimesApplication = (NewYorkTimesApplication)getActivity().getApplication();
        (newYorkTimesApplication).getAppComponent().inject(this);




    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_master,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        newYorkTimesProgressDialog = new NewYorkTimesProgressDialog(getActivity());
        newYorkTimesProgressDialog.showDialog();

        service.getBaseURL(new Service.ResponseCallback<Response>() {
            @Override
            public void onSuccess(Response response) {

                Log.e("Response ","" + response);


                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);

                mAdapter = new MyAdapter(response,(MainActivity) getActivity(),getFragmentManager());
                recyclerView.setAdapter(mAdapter);
                newYorkTimesProgressDialog.dismissDialog();
            }

            @Override
            public void onError(NetworkError networkError) {
                newYorkTimesProgressDialog.dismiss();
                Toast.makeText(getActivity()," Error Occured",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
