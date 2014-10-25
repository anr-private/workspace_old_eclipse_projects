package com.maranr.anr_internal_intents_22;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyBrowserActivity extends Activity {

	/** Called when activity is first created */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		
		Uri url = getIntent().getData();
		WebView webView = (WebView) findViewById(R.id.WebView01);
		webView.setWebViewClient(new Callback());
		webView.loadUrl(url.toString());
	}
	
	private class Callback extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return false;
		}
	}

}
