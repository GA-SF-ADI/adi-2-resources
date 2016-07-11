package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DetailsFragment extends Fragment {


    WebView webView;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //TODO: Inflate the view and change the return type;
        //done.  see below
        View view = inflater.inflate(R.layout.details_fragment_layout, container, false);
        webView = (WebView) view.findViewById(R.id.web_view);

        return view;
    }

    public void updateContent(String sign) {
        
        webView.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
