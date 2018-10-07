package vagabondvalleyspace.com.mobilestage;

private class BackButtonListener implements View.OnClickListener {
	private AppCompatActivity activity;
	
	public BackButtonListener(AppCompatActivity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(THIS, MainActivity.class);
		startActivity(intent);
	}
}