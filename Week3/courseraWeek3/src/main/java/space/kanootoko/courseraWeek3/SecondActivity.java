package space.kanootoko.courseraWeek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

	public static String TEXT_KEY = "TEXT_KEY";

	private Button mButton;
	private TextView mText;

	private View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			if (mText.getError() == null) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://google.com/search?q=%s", mText.getText().toString())));
				startActivity(browserIntent);
			} else
				Toast.makeText(SecondActivity.this, "String must not be empty", Toast.LENGTH_LONG).show();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		mButton = findViewById(R.id.second_button);
		mText = findViewById(R.id.second_text);

		Bundle bundle = getIntent().getExtras();

		if (bundle.containsKey(TEXT_KEY) && !bundle.getString(TEXT_KEY).isEmpty())
			mText.setText(bundle.getString(TEXT_KEY));
		else {
			mText.setText("(empty)");
			mText.setError("(empty)");
		}

		mButton.setOnClickListener(buttonOnClickListener);
	}
}
