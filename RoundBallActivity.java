package com.example.wrwrld_jbwky_uinasa_rbl;
//Karen West January 26, 2014, Assignment #2, App#1

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.util.Log;

public class RoundBallActivity extends Activity {
	WebView roundBallWebView;
	
	//What was different for the round ball game activity, was that you had to
	//enable Javascript and DomStorage to make it work, since the game needs these.
	//The roundball game html and all associated assets are in the local assets folder.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("roundBall", "finding main web view");
		roundBallWebView = (WebView) findViewById(R.id.webViewMain);
		roundBallWebView.getSettings().setBuiltInZoomControls(true);
		roundBallWebView.getSettings().setJavaScriptEnabled(true);
		roundBallWebView.getSettings().setDomStorageEnabled(true);
		//open asset Round Ball web page
		roundBallWebView.loadUrl("file:///android_asset/roundball/roundball.html");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.round_ball, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//check if key event was back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && roundBallWebView.canGoBack()) {
			roundBallWebView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}


}
