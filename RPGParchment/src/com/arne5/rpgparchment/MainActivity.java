package com.arne5.rpgparchment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	MediaPlayer themeSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Thread timer = new Thread() {
			public void run() {

				try {
					sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent mainmenu = new Intent(
							"com.arne5.rpgparchment.MainMenu");
					startActivity(mainmenu);
				}
			}

		};
		timer.start();

	}

	@Override
	protected void onResume() {

		themeSong = MediaPlayer.create(this, R.raw.itcrowdtheme);
		themeSong.start();

		super.onResume();

	}

	@Override
	protected void onPause() {

		themeSong.stop();
		themeSong.release();

		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
