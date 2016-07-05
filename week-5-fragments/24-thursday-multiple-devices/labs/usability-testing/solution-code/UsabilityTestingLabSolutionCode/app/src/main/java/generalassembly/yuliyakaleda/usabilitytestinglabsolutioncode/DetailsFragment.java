package generalassembly.yuliyakaleda.usabilitytestinglabsolutioncode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailsFragment extends Fragment {
  private WebView wv;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.details_fragment_layout, container, false);
    wv = (WebView) view.findViewById(R.id.web_view);
    return view;
  }

  public void updateContent(String sign) {
    wv.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + sign + "/");
    wv.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });
  }
}
