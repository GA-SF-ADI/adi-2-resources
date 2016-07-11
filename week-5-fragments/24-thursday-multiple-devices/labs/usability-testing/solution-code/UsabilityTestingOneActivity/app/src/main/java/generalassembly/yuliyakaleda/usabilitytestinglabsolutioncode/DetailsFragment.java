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
  // Define Webview object
  private WebView webView;
  private String updatedSign;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    // Inflate our Details Fragment Layout, and store it into variable view of type View
    View view = inflater.inflate(R.layout.details_fragment_layout, container, false);

    // Find our webView from view ( which is inflated top layout of Details Fragment )
    webView = (WebView) view.findViewById(R.id.web_view);

    // Make sure to update the url with whatever was passed in after the fragment was created
    updateUrl();

    // Return our top layout view of the fragment
    return view;
  }

  /**
   * This method will update what url the webview is displaying
   * @param sign
     */
  public void updateContent(String sign) {
    // update the sign in a local variable
    updatedSign = sign;

    if (webView == null){
      return;
    }
    updateUrl();
  }

  private void updateUrl(){
    webView.loadUrl("http://www.horoscopedates.com/zodiac-signs/" + updatedSign + "/");
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });
  }
}
