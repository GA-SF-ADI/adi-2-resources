package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DetailsFragment extends Fragment{
  private WebView webview;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    //TODO: Inflate the view and change the return type;
    View view = inflater.inflate(R.layout.details_fragment_layout, container, false);
    webview = (WebView)view.findViewById(R.id.web_view);
    return null;
  }

  public void updateContent(String sign) {
    // TODO: Finish the method which will open a webview and redirect the user to the website
    // TODO: to read about the sign that was clicked in the ListView
    webview.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
    webview.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });
  }

}
