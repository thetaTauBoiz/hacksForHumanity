package vagabondvalleyspace.com.mobilestage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
	
	private Button submit;
    private SearchView searchRadius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		submit = (Button) findViewById(R.id.search);
		searchRadius = (SearchView) findViewById(R.id.radius);
		
		submit.setOnClickListener(new SubmitListener(this, String.valueOf(searchRadius.getQuery())));
    }


}
