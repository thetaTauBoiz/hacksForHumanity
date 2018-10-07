package vagabondvalleyspace.com.mobilestage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SearchView;

import java.util.HashMap;

public class SubmitListener implements View.OnClickListener {
	private AppCompatActivity activity;
	private HashMap<String, SearchView> dataFieldMap;
	
	public SubmitListener(AppCompatActivity activity) {
		this.activity = activity;
		this.dataFieldMap = new HashMap<>();
	}

	public void addDataField(String id, SearchView field) {
		dataFieldMap.put(id, field);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(activity, data_display.class);

		/* Insert Data */
		for (HashMap.Entry<String, SearchView> entry : dataFieldMap.entrySet()) {
			intent.putExtra(entry.getKey(), entry.getValue().getQuery().toString());
		}

		activity.startActivity(intent);
	}
}
