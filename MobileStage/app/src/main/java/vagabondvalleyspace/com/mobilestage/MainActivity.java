package vagabondvalleyspace.com.mobilestage;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
	

	private Button submit;
    private SearchView searchRadius;
    private SearchView venueName;
    private SearchView description;
    private SearchView address;
    private SearchView opName;
    private SearchView phoneNumber;
    private SearchView email;
    private SearchView venueType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		submit = (Button) findViewById(R.id.search);
		searchRadius = (SearchView) findViewById(R.id.radius);
        venueName = (SearchView) findViewById(R.id.venueName);
        description = (SearchView) findViewById(R.id.description);
        address = (SearchView) findViewById(R.id.address);
        opName = (SearchView) findViewById(R.id.opName);
        phoneNumber = (SearchView) findViewById(R.id.phoneNumber);
        email = (SearchView) findViewById(R.id.email);
        venueType = (SearchView) findViewById(R.id.venueType);

        SubmitListener subListener = new SubmitListener(this);
        subListener.addDataField("searchRadius", searchRadius);
        subListener.addDataField("address", address);
        subListener.addDataField("description", description);
        subListener.addDataField("venueName", venueName);
        subListener.addDataField("opName", opName);
        subListener.addDataField("phoneNumber", phoneNumber);
        subListener.addDataField("email", email);
        subListener.addDataField("venueType", venueType);

		submit.setOnClickListener(subListener);
    }
}
