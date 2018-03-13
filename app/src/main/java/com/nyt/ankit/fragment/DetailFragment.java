package com.nyt.ankit.fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nyt.ankit.R;
import com.nyt.ankit.utils.Constant;
import com.nyt.ankit.utils.NewYorkTimesProgressDialog;

/**
 * Created by Ankit Khandelwal on 13-03-2018.
 */

public class DetailFragment  extends Fragment {

    private View view;
    private WebView mWebview;
    private String mUrl;
    private NewYorkTimesProgressDialog newYorkTimesProgressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_detail, null);
        newYorkTimesProgressDialog = new NewYorkTimesProgressDialog(getActivity());

        mUrl = getArguments().getString(Constant.BUNDLE_ARTICLE_URL);

        initView(view);
        return view;
    }

    //initialize view objects.
    private void initView(View view) {
        mWebview = view.findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript
        mWebview.setWebViewClient(new WebViewController());
        mWebview.loadUrl(mUrl);
    }

    public class WebViewController extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            newYorkTimesProgressDialog.showDialog();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            newYorkTimesProgressDialog.dismissDialog();
            super.onPageFinished(view, url);

        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }
}
