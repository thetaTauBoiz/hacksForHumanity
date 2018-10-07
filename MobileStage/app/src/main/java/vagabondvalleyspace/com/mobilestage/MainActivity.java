package vagabondvalleyspace.com.mobilestage;

public class MainActivity extends AppCompatActivity {
	
	private Button submit;
	//TODO add text field instances

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		submit = (Button) findViewById(R.id.search);
		
		submit.setOnClickListener(new SubmitListener(this, "REPLACE THIS WITH INPUT DATA"));
    }
}
