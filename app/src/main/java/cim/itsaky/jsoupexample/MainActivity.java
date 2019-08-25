package cim.itsaky.jsoupexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.AsyncTask;
import java.util.concurrent.ExecutionException;
import android.view.View.OnClickListener;
import android.view.View;

public class MainActivity extends AppCompatActivity 
{
	private Button btn;
	private EditText et;
	private TextView tv;
	
	String version = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.activitymainButton1);
		et = (EditText) findViewById(R.id.activitymainEditText1);
		tv = (TextView) findViewById(R.id.activitymainTextView1);
		
		btn.setOnClickListener (new OnClickListener (){

				@Override
				public void onClick(View p1)
				{
					GetVersionName getVersionName = new GetVersionName();
					try
					{
						version = getVersionName.execute (et.getText().toString()).get ();
					}
					catch (InterruptedException e)
					{}
					catch (ExecutionException e)
					{}
					tv.setText(version);
				}
			});
    }
	
}
