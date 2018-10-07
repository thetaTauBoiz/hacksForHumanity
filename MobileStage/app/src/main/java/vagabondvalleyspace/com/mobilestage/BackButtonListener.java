package vagabondvalleyspace.com.mobilestage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BackButtonListener implements View.OnClickListener {
	private AppCompatActivity activity;
	
	public BackButtonListener(AppCompatActivity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(activity, MainActivity.class);
		activity.startActivity(intent);
	}
}