package vagabondvalleyspace.com.mobilestage;

public class ResponseActivity extends AppCompatActivity {

    private TextView result;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SubmitListener.MESSAGE_ADDR);

        result = (TextView) findViewById(R.id.result);
        result.setText(message);

        returnButton = (Button) findViewById(R.id.search);
        returnButton.setOnClickListener(new BackButtonListener(this));
    }

}
