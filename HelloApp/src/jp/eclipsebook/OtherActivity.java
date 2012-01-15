package jp.eclipsebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends Activity {
	private MyData data = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		Intent intent = this.getIntent();
		if (intent.getAction().equals(Intent.ACTION_SEND)){
			data = (MyData)intent.getSerializableExtra("MyData");
			TextView text1 = (TextView)this.findViewById(R.id.otherTextView1);
			text1.setText(data.toString());
		} 
	}
	
	public void doAction(View view){
		Intent returnIntent = new Intent();
		returnIntent.putExtra(Intent.EXTRA_TEXT,"send data: " + 
				data.getName1());
		this.setResult(Activity.RESULT_OK, returnIntent);
		this.finish();
	}
}
