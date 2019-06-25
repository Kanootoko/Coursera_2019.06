package space.kanootoko.courseraWeek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mText;

    private View.OnClickListener mButtonOnClickListener  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = (mText.getText().toString());
            if (!text.isEmpty())
                Toast.makeText(LaunchActivity.this, text, Toast.LENGTH_LONG).show();

            Intent secondActivityIntent = new Intent(LaunchActivity.this, SecondActivity.class);
            secondActivityIntent.putExtra(SecondActivity.TEXT_KEY, mText.getText().toString());
            startActivity(secondActivityIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mButton = findViewById(R.id.centerButton);
        mText = findViewById(R.id.inputText);
        mButton.setOnClickListener(mButtonOnClickListener);
    }
}
