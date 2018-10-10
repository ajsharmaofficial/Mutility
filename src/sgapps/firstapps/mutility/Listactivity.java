package sgapps.firstapps.mutility;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import sgapps.firstapps.mutility.R;

public class Listactivity extends Activity implements OnClickListener {
	ImageView v1,v2,v3,v4,v5,v6,v7;
	TextView t1,t2,t3,t4,t5,t6,t7,t8;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listactivity);
		t1=(TextView)findViewById(R.id.textView1);
		t1.setTextColor(Color.RED);
		t2=(TextView)findViewById(R.id.textView2);
		t2.setTextColor(Color.RED);
		t3=(TextView)findViewById(R.id.textView3);
		t3.setTextColor(Color.RED);
		t4=(TextView)findViewById(R.id.textView4);
		t4.setTextColor(Color.RED);
		t5=(TextView)findViewById(R.id.textView5);
		t5.setTextColor(Color.RED);
		t6=(TextView)findViewById(R.id.textView6);
		t6.setTextColor(Color.RED);
		t8=(TextView)findViewById(R.id.textView8);
		t8.setTextColor(Color.RED);
		t7=(TextView)findViewById(R.id.textView7);
		t7.setTextColor(Color.BLUE);
		v1=(ImageView)findViewById(R.id.imageView1);
		v2=(ImageView)findViewById(R.id.imageView2);
		v3=(ImageView)findViewById(R.id.imageView3);
		v4=(ImageView)findViewById(R.id.imageView4);
		v5=(ImageView)findViewById(R.id.imageView5);
		v6=(ImageView)findViewById(R.id.imageView6);
		v7=(ImageView)findViewById(R.id.imageView7);
		v1.setOnClickListener(this);
		v2.setOnClickListener(this);
		v3.setOnClickListener(this);
		v4.setOnClickListener(this);
		v5.setOnClickListener(this);
		v6.setOnClickListener(this);
		v7.setOnClickListener(this);
		try {
			Context context = getBaseContext();
			ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo act=cm.getActiveNetworkInfo();
			if(act.getType()== ConnectivityManager.TYPE_MOBILE)
				Toast.makeText(this,"Mobile Data Enabled",Toast.LENGTH_LONG).show();
			else if(act.getType()== ConnectivityManager.TYPE_WIFI)
				Toast.makeText(this,"Wifi Enabled",Toast.LENGTH_LONG).show();
			
			
		} catch (Exception e) {
				AlertDialog.Builder ab=new AlertDialog.Builder(Listactivity.this);
				ab.setTitle("Connection Needed");
				ab.setMessage("Some Feature of this application needs an active data connection.Do you want to on it now?");
				ab.setCancelable(true);
				ab.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
						
					}
				});
				ab.setNegativeButton("Not Now",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					
						
					}
				});
				ab.show();
				
		
		}
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listactivity, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView1:i=new Intent(Listactivity.this,Key_Store.class);startActivity(i);break;
		case R.id.imageView2:i=new Intent(Listactivity.this,Locate_me.class);startActivity(i);break;
		case R.id.imageView3:i=new Intent(Listactivity.this,PinCode.class);startActivity(i);break;
		case R.id.imageView4:i=new Intent(Listactivity.this,NearPlace.class);startActivity(i);break;
		case R.id.imageView5:i=new Intent(Listactivity.this,TicTacToe_s.class);startActivity(i);break;
		case R.id.imageView6:i=new Intent(Listactivity.this,Browser.class);startActivity(i);break;
		case R.id.imageView7:i=new Intent(Listactivity.this,MoodyMind.class);startActivity(i);break;
		default:
			break;
		}
		
	}

}
