package com.example.wrwrld_jbwky_uinasa_rbl;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.util.Log;

public class UInasaActivity extends Activity {
	WebView UI_NASA_WebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("UofINASA", "finding main web view");
		UI_NASA_WebView = (WebView) findViewById(R.id.webViewMain);
		UI_NASA_WebView.getSettings().setBuiltInZoomControls(true);
		//open asset Univ. Of Illinois web page
		UI_NASA_WebView.loadUrl("file:///android_asset/uofi_at_nasa.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uinasa, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//check if key event was back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && UI_NASA_WebView.canGoBack()) {
			UI_NASA_WebView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}

}
