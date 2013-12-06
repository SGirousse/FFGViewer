package org.jeudego.ffg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * You can access to last news here. If the user try to access another page it will open a browser.
 * 
 * @author simeon
 *
 */
public class ViewNewsActivity extends Activity{

	private final String _ffg_url = "http://ffg.jeudego.org/";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "ViewNewsActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_website_view);
        
        //TODO Create my own WebView in order to have a better management of URLs and navigation
        //TODO Manage articles as basics data
        
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
