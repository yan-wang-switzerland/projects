package com.yan.wang.app.scoreboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class StartGameActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_game);
		
		Bundle bundle = getIntent().getExtras();
		int size = bundle.size();
		String extraKeyName = "player";
		int nb = 0;
		while (nb < size) {
			Toast.makeText(this, bundle.getString(extraKeyName+nb), Toast.LENGTH_SHORT).show();
			nb++;
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
