package vagabondvalleyspace.com.mobilestage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
	
	private final String ALERT_MSG = "Mobile Stage";
	private Button submit;
    private SearchView searchRadius;
	
	private void alert(String msg) {
	AlertDialog alertDialog = new AlertDialog.Builder(InputActivity.this).create();
	alertDialog.setTitle(ALERT_MSG);
	alertDialog.setMessage(msg);
	alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
	alertDialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		submit = (Button) findViewById(R.id.search);
		searchRadius = (SearchView) findViewById(R.id.radius);
		
		submit.setOnClickListener(new SubmitListener(this, "ABC"));
		
		alert("Test");
		alert(String.valueOf(searchRadius.getQuery()));
    }


}
