package sgapps.firstapps.mutility;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button proceed,exit,credit;
	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		proceed=(Button)findViewById(R.id.button1);
		exit=(Button)findViewById(R.id.button2);
		credit=(Button)findViewById(R.id.button3);
		proceed.setOnClickListener(this);
		exit.setOnClickListener(this);
		credit.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1)
		{
			i=new Intent(MainActivity.this,Listactivity.class);
			startActivity(i);
			finish();
			
		}
		if(v.getId()==R.id.button2)
		{
		finish();
		}
		if(v.getId()==R.id.button3)
		{
			i=new Intent(MainActivity.this,Credits.class);
			startActivity(i);
			
		}
		
	}

}

