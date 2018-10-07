package vagabondvalleyspace.com.mobilestage;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class data_display extends AppCompatActivity {

    private HashMap<String, Integer> outputMap;
    private Button returnButton;

    public data_display() {
        outputMap = new HashMap<>();

        outputMap.put("searchRadius", R.id.radius);
        outputMap.put("venueName", R.id.venueName);
        outputMap.put("description", R.id.description);
        outputMap.put("address", R.id.address);
        outputMap.put("opName", R.id.opName);
        outputMap.put("phoneNumber", R.id.phoneNumber);
        outputMap.put("email", R.id.email);
        outputMap.put("venueType", R.id.venueType);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        Intent intent = getIntent();

        Database.setupDatabase();

        DataMember dm = getDataBy(intent, "searchRadius");

        if (dm != null) {
            TextView radius = (TextView) findViewById(outputMap.get("searchRadius"));
            TextView venueName = (TextView) findViewById(outputMap.get("venueName"));
            TextView description = (TextView) findViewById(outputMap.get("description"));
            TextView address = (TextView) findViewById(outputMap.get("address"));
            TextView opName = (TextView) findViewById(outputMap.get("opName"));
            TextView phoneNumber = (TextView) findViewById(outputMap.get("phoneNumber"));
            TextView email = (TextView) findViewById(outputMap.get("email"));
            TextView venueType = (TextView) findViewById(outputMap.get("venueType"));

            radius.setText(dm.radius);
            venueName.setText(dm.name);
            description.setText(dm.description);
            address.setText(dm.address);
            opName.setText(dm.operatorName);
            phoneNumber.setText(dm.phoneNumber);
            email.setText(dm.email);
            venueType.setText(dm.venueType);
        }

        returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new BackButtonListener(this));
    }

    private DataMember getDataBy(Intent intent, String field) {
        for (HashMap.Entry<String, Integer> entry : outputMap.entrySet()) {
            String key = entry.getKey();

            if (intent.hasExtra(key)) {
                String message = intent.getStringExtra(key);
                if (message != "") {
                    if (key.equals(field)) {
                        return Database.queryName(message);
                    }
                }
            }
        }

        return null;
    }

    private void alert(String msg) {
		AlertDialog alertDialog = new AlertDialog.Builder(data_display.this).create();
		alertDialog.setTitle("Mobile Stage");
		alertDialog.setMessage(msg);
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		alertDialog.show();
	}
}
