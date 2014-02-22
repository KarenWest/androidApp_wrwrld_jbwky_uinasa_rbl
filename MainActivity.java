package com.example.wrwrld_jbwky_uinasa_rbl;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
//import android.webkit.WebView;

public class MainActivity extends Activity {
	//WebView mainWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//find Main Web View ID
		Log.e("MainActivity", "onCreate");
		//mainWebView = (WebView) findViewById(R.id.webViewMain);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
