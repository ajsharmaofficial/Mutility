package sgapps.firstapps.mutility;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import sgapps.firstapps.mutility.R;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;

public class Locate_me extends FragmentActivity implements LocationListener {
	GoogleMap map;
	SupportMapFragment frg;
	Double lat,lon;
	TextView t1,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locate_me);
		frg=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1);
		map=frg.getMap();
		t1=(TextView)findViewById(R.id.textView3);
		t2=(TextView)findViewById(R.id.textView4);
		t1.setText("Searching");
		t2.setText("Searching");
		map.setMyLocationEnabled(true);
		LocationManager manager=(LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria c =new Criteria();
		String provider=manager.getBestProvider(c, true);
		Location l=manager.getLastKnownLocation(provider);
		if(l!=null)
		{
			onLocationChanged(l);
		}
		manager.requestLocationUpdates(provider, 2000, 0, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.locate_me, menu);
		return true;
	}
	public void onLocationChanged(Location l) {
		lat=l.getLatitude();
		lon=l.getLongitude();
		map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat,lon)));
		map.animateCamera(CameraUpdateFactory.zoomTo(15));
		t1.setText(""+lat);
		t2.setText(""+lon);
		}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
