package com.example.wrwrld_jbwky_uinasa_rbl;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;

public class WarOfWorldsActivity extends Activity {
	WebView warOfWorldsWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//find War of Worlds Web View ID
		Log.e("warOfWorlds", "finding main web view");
		warOfWorldsWebView = (WebView) findViewById(R.id.webViewMain);
		warOfWorldsWebView.getSettings().setBuiltInZoomControls(true);
		//open asset of War of Worlds web page
		warOfWorldsWebView.loadUrl("file:///android_asset/waroftheworlds.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.war_of_worlds, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//check if key event was back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && warOfWorldsWebView.canGoBack()) {
			warOfWorldsWebView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}

}
