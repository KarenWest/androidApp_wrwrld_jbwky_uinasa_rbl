package com.example.wrwrld_jbwky_uinasa_rbl;
//Karen West January 26, 2014, Assignment #2, App#1

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class JabberWockyActivity extends Activity {
	WebView jabberWockyWebView;
	MediaPlayer elpNutRocker;
	String url_jabberwockyWikipedia = "http://en.wikipedia.org/wiki/Jabberwocky";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		Log.e("jabberWocky", "onCreate");

		//Rather than specify in the activity_jabber_wocky.xml file <Button> code,
		//the routine to call here for the "onClick()" property, instead here I
		//did a web search to set up a listener to respond to the button clicks
		//for Jabberywocky Wikipedia page or photo with poem
		
		setContentView(R.layout.activity_jabber_wocky);
        final Button wikipediaButton = (Button) findViewById(R.id.jabberWockyWikipedia);
        wikipediaButton.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		Intent i = new Intent(Intent.ACTION_VIEW);
        		i.setData(Uri.parse(url_jabberwockyWikipedia));
        		startActivity(i);        		
        	}
        });

        final Button photoWithPoemButton = (Button) findViewById(R.id.jabberWockyPicture);
        photoWithPoemButton.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		//onPause();
        		//find JabberWocky Web View ID
        		Log.e("jabberWocky", "display photo-finding jabberwocky web view");
        		setContentView(R.layout.activity_main);
        		jabberWockyWebView = (WebView) findViewById(R.id.webViewMain);
        		jabberWockyWebView.getSettings().setBuiltInZoomControls(true);
        		//open asset jabberwocky poster photo
        		jabberWockyWebView.loadUrl("file:///android_asset/jabberwockywithphoto.html");
        		//setContentView(R.layout.activity_jabber_wocky);
        	}
        });
        //setContentView(R.layout.activity_main);
		//jabberWockyWebView = (WebView) findViewById(R.id.webViewMain);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabber_wocky, menu);
		return true;
	}
	
	//Originally I had an "onClick" property in my activity_jabber_wocky.xml code,
	//and these routines responded to the button clicks, but I decided to try the
	//above listerner approach I found on a search instead this time.
	
	//button was pressed in JabberWocky WebView to display it's Wikipedia page
/*	public void displayJabberWockyWikepedia(View v) {
		Log.e("jabberWocky", "display Wikipedia-finding jabberwocky web view");
		//setContentView(R.layout.activity_main);
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url_jabberwockyWikipedia));
		startActivity(i);
	}
*/	
	//button was pressed in JabberWocky WebView to display a photo of movie poster
/*	public void displayJabberPicture(View v) {
		//find JabberWocky Web View ID
		Log.e("jabberWocky", "display photo-finding jabberwocky web view");
		//setContentView(R.layout.activity_main);
		jabberWockyWebView = (WebView) findViewById(R.id.webViewMain);
		jabberWockyWebView.getSettings().setBuiltInZoomControls(true);
		//open asset jabberwocky poster photo
		//jabberWockyWebView.loadUrl("file:///android_asset/jabberwockyposter.jpg");
		jabberWockyWebView.loadUrl("file:///android_asset/jabberwockywithphoto.html");
	}
*/

	//This plays an MP3 song placed in the raw directory.  For that raw mp3,
	//you must create the mediaPlayer variable in the "onResume" routine, which is 
	//automatically called after "onCreate" is called by the Android OS below.  The 
	//raw mp3 song will play to completion if you let it, and then repeat itself,
	//since "setLooping()" is set to true.
	//The song plays as soon as you select the Jabberwocky icon on the main menu,
	//even before you press either the Wikipedia button or the photo-with-poem button.
	
	//The assignment asked that we find a 30 second clip, and I searched and searched
	//for an appropriate "jabberwocky" associated music clip to match the poem and
	//photo, but I could not find a good one, so I gave up, and instead played an
	//Emerson,Lake and Palmer 30 second music clip I had laying around in my directory.
	//It is called "Nutrocker" and is a good 30 second clip, but has nothing to do
	//with the Jabberwocky!
	
	//Note that clicking the Jabberwocky Wikipedia button automatically calls
	//onPause(), so the music stops when you go to the Wikipedia page, but
	//resumes when you hit the back button.  However, when you click the Jabberwocky
	//photo with poem button, the music does not stop, so in this case, where the
	//html file is stored in the local assets folder, rather than going out to the
	//internet as in the Wikipedia web page case, the onPause() routine is NOT called
	//by the Android OS, and the music keeps playing.  Hitting the back button from
	//the Jabberwocky photo with poem page takes you back to the main menu.
	@Override
	protected void onResume() {
		Log.e("jabberWocky", "onResume!");
		elpNutRocker = MediaPlayer.create(this, R.raw.elp_nutrocker);
		elpNutRocker.setLooping(true);
		elpNutRocker.start();
		super.onResume();
	}
	@Override
	protected void onPause() {
		Log.e("jabberWocky", "onPause!");
		elpNutRocker.stop();
		elpNutRocker.release();
		super.onPause();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//check if key event was back button and if there's history
		if (jabberWockyWebView != null) {
			if ((keyCode == KeyEvent.KEYCODE_BACK) && jabberWockyWebView.canGoBack()) {
				jabberWockyWebView.goBack();
				return true;
			}
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onBackPressed() {
	    if( jabberWockyWebView != null ) {
	        if( jabberWockyWebView.canGoBack() ) {
	            jabberWockyWebView.goBack();
	            return;
	        }
	    }

	    super.onBackPressed();
	}

}
