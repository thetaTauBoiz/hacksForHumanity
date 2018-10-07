package vagabondvalleyspace.com.mobilestage;

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
		Intent intent = new Intent(activity, DataDisplay.class);
		intent.putExtra(MESSAGE_ADDR, data); // TODO put actual message
		startActivity(intent);
	}
}