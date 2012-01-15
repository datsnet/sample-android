package jp.eclipsebook;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class HelloAppActivity extends Activity {
	static final int ACTIVITY_CODE = 0;
	static final int NOTIFY_ID = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void doAction(View view){
		EditText edit1 = (EditText)this.findViewById(R.id.editText1);
		Editable s = edit1.getText();
		Intent intent = new Intent(this,jp.eclipsebook.HelloAppActivity.class);
		PendingIntent pending = PendingIntent.getActivity(this, ACTIVITY_CODE, 
				intent, PendingIntent.FLAG_CANCEL_CURRENT);
		Notification notify = new Notification();
		notify.flags = Notification.FLAG_AUTO_CANCEL;
		notify.icon = R.drawable.ic_launcher;
		notify.tickerText = "HelloApp notification!!";
		notify.setLatestEventInfo(this, "HelloApp Info", 
				"message: " + s, pending);
		NotificationManager manager = (NotificationManager)this.
				getSystemService(Activity.NOTIFICATION_SERVICE);
		manager.notify(NOTIFY_ID, notify);
	}
}
