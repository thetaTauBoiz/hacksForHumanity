package vagabondvalleyspace.com.mobilestage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SubmitListener implements View.OnClickListener {
	public static final String MESSAGE_ADDR = "vagabondvalleyspace.com.mobilestage.MESSAGE";
	
	private AppCompatActivity activity;
	private String data;
	
	public SubmitListener(AppCompatActivity activity, String data) {
		this.activity = activity;
		this.data = data;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(activity, data_display.class);
		intent.putExtra(MESSAGE_ADDR, data); // TODO put actual message
		activity.startActivity(intent);
	}
}