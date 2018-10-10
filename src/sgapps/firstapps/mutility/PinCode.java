package sgapps.firstapps.mutility;


import java.io.IOException;
import java.util.List;
import sgapps.firstapps.mutility.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PinCode extends FragmentActivity implements OnClickListener {
	GoogleMap map;
	SupportMapFragment frg;
	EditText e1;
	Button b1;
	String content,show,tit;
	Double lat,lon;
	LatLng ltln;
	TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin_code);
		frg=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
		e1=(EditText)findViewById(R.id.editText1);
		t1=(TextView)findViewById(R.id.textView1);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
		try {
			Context context = getBaseContext();
			ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo act=cm.getActiveNetworkInfo();
			if(act.getType()== ConnectivityManager.TYPE_MOBILE)
				Toast.makeText(this,"Mobile Data Enabled",Toast.LENGTH_LONG).show();
			else if(act.getType()== ConnectivityManager.TYPE_WIFI)
				Toast.makeText(this,"Wifi Enabled",Toast.LENGTH_LONG).show();
			
			
		} catch (Exception e) {
				AlertDialog.Builder ab=new AlertDialog.Builder(PinCode.this);
				ab.setTitle("Connection Needed");
				ab.setMessage("Please switch on your datapack or wifi, otherwise this segment will not run");
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
					
						finish();
					}
				});
				ab.show();
				
		
		}
		map=frg.getMap();
		map.setMyLocationEnabled(true);
		t1.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pin_code, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		content=e1.getText().toString();
		StringBuffer buffer=new StringBuffer();
		
		Geocoder coder=new Geocoder(getBaseContext());
		try {
			List<Address> address=coder.getFromLocationName(content,1);
			
			if(address.size()>0)
			{
				Address add=(Address)address.get(0);
				lat=add.getLatitude();
				lon=add.getLongitude();
				ltln=new LatLng(lat, lon);
				buffer.append((tit=add.getAddressLine(0))).append("\n");
				buffer.append(add.getLocality()).append("\n");
				buffer.append(add.getAdminArea()).append("\n");
				if(add.getPhone()!=null)
				buffer.append(add.getPhone()).append("\n");
				if(add.getPostalCode()!=null)
				buffer.append(add.getPostalCode()).append("\n");
				buffer.append(add.getCountryName()).append("\n");
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			AlertDialog.Builder ab=new AlertDialog.Builder(PinCode.this);
			ab.setTitle("Network Problem");
			ab.setMessage("Your internet connection is not working or may be slow");
			ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
				Intent i=new Intent(PinCode.this,Listactivity.class);
				startActivity(i);
				finish();
				}
			});
			ab.show();
		}
		MarkerOptions marker=new MarkerOptions().position(new LatLng(lat,lon)).title(tit);
		map.addMarker(marker);
		map.moveCamera(CameraUpdateFactory.newLatLng(ltln));
		map.animateCamera(CameraUpdateFactory.zoomTo(15));
		show=buffer.toString();
		t1.setText(""+ show);
				
		}
		
}


