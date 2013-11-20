package org.jeudego.ffg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewWebsiteActivity extends Activity{

	private final String _ffg_url = "http://ffg.jeudego.org/";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_view);
        
        WebView webViewFFG = (WebView) findViewById(R.id.webviewffg);
        webViewFFG.setWebViewClient(new WebViewClient());
		WebSettings webSettingsFFG = webViewFFG.getSettings();
        webSettingsFFG.setJavaScriptEnabled(true);
        webViewFFG.loadUrl(this._ffg_url);
     
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
