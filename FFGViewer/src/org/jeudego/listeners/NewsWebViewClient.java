package org.jeudego.listeners;

import org.jeudego.ffg.MainActivity;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsWebViewClient extends WebViewClient{
	
	private final String _FFG_URL = "ffg.jeudego.org";
	private MainActivity _main_activity;
	
	public NewsWebViewClient(MainActivity main_activity){
		this._main_activity = main_activity;
	}
	
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
    	
    	//If FFG web site related
        if (Uri.parse(url).getHost().equals(this._FFG_URL)) {
            // Manage news and other stuffs
        	// If main page > show news activity
        	// If tournament schedule > show tournament schedule activity
        	// ...
            return false;
        }else{
	        // Not related with FFG web site
	        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
	        this._main_activity.startActivity(intent);
	        
	        return true;
        }
    }

}
