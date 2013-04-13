package com.yan.wang.app.scoreboard;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewGameActivity extends Activity {
	
	private ListView listView;
	private List<String> playerNameList = new ArrayList<String>();
	private ArrayAdapter<String> arrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);
		
		listView = (ListView) findViewById(R.id.listView1);
		arrayAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, playerNameList);
		listView.setAdapter(arrayAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClickAddPlayer(View view) {
		Intent i = new Intent("com.yan.wang.app.scoreboard.AddPlayerActivity");            
		startActivityForResult(i, 10);
	}
	
	public void onClickStartGame(View view) {
		Intent i = new Intent("com.yan.wang.app.scoreboard.StartGameActivity");  
		String extraKeyName = "player";
		int nb = 0;
		for (String playerName: playerNameList) {
			i.putExtra(extraKeyName+nb, playerName);
			nb++;
		}
		
		startActivityForResult(i, 20);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == 10) {
			if (data.hasExtra("playerName")) {
				playerNameList.add(data.getExtras().getString("playerName"));
				Toast.makeText(this, data.getExtras().getString("playerName") + " created!", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
