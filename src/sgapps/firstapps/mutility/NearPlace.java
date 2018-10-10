package sgapps.firstapps.mutility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sgapps.firstapps.mutility.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class NearPlace extends FragmentActivity implements OnItemSelectedListener, OnClickListener {
	GoogleMap map;
	SupportMapFragment frg;
	Spinner spin;
	String ans,s,url,place,type,slat,slon;
	StringBuffer buffer=new StringBuffer();
	StringBuffer nbuffer=new StringBuffer();
	Double lat,lon;
	String name,vicinity;
	EditText e;
	ArrayList<Double>alat=new ArrayList<Double>();
	ArrayList<Double>alon=new ArrayList<Double>();
	ArrayList<String>nam=new ArrayList<String>();
	Button b1,b2;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_near_place);
			frg=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
			spin=(Spinner)findViewById(R.id.spinner1);
			spin.setOnItemSelectedListener(this);
			String arr[]={"airport","atm","bank","bus_station","cafe","church","dentist","department_store","doctor","finance","fire_station","food","gym","hair_care","health","hindu_temple","hospital","lawyer","library","liquor_store","mosque","movie_theater","park","parking","police","post_office","restaurant","school","shopping_mall","stadium","taxi_stand","train_station","university"};
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arr);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			b1=(Button)findViewById(R.id.button1);
			b1.setOnClickListener(this);
			b2=(Button)findViewById(R.id.button2);
			b2.setOnClickListener(this);
			spin.setAdapter(adapter);
			map=frg.getMap();
			map.setMyLocationEnabled(true);
			e=(EditText)findViewById(R.id.editText1);
			
		
	}
		class asy extends AsyncTask<String, Integer, String>
		{

			@Override
			protected String doInBackground(String... arg0) {
				DefaultHttpClient client= new DefaultHttpClient();
				HttpGet get=new HttpGet(url);
				try {
					HttpResponse response=client.execute(get);
					BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					while((s=br.readLine())!=null)
					{
						buffer.append(s);
					}
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s=buffer.toString();
				try {
					JSONObject objct=new JSONObject(s);
					JSONArray res=objct.getJSONArray("results");
					for(int i=0;i<res.length();i++)
					{
						JSONObject ob=res.getJSONObject(i);
						lat=Double.parseDouble(ob.getJSONObject("geometry").getJSONObject("location").getString("lat"));
						lon=Double.parseDouble(ob.getJSONObject("geometry").getJSONObject("location").getString("lng"));
						name=ob.getString("name");
						alat.add(lat);
						alon.add(lon);
						nam.add(name);
						//vicinity=ob.getString("vicinity");
						
						
					}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				/*t=(TextView)findViewById(R.id.textView1);
				t.setText(ans);*/
				double lat1=0,lon1=0;
				String nm="";
				CameraPosition cam= new CameraPosition.Builder().target(new LatLng(lat,lon)).zoom(15).build();
				map.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
				for(int j=0;j<nam.size();j++)
				{
					lat1=alat.get(j);
					lon1=alon.get(j);
					nm=nam.get(j);
					MarkerOptions marker=new MarkerOptions().position(new LatLng(lat1, lon1)).title(nm);
					map.addMarker(marker);
				}
				
				int r=buffer.length();
				buffer.delete(0,r);
				//t2.setText("ooooplace:"+place+" dd "+type);
				alat.clear();
				alon.clear();
				nam.clear();
				super.onPostExecute(result);
			}
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.near_place, menu);
		return true;
	}
	@Override
	public void onItemSelected(AdapterView<?> par, View v, int pos,
			long arg3) {
		type=par.getItemAtPosition(pos).toString();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1)
			{place=e.getText().toString();
		Geocoder coder=new Geocoder(getBaseContext());
		try {
			List<Address> address=coder.getFromLocationName(place,1);
			
			if(address.size()>0)
			{
				Address add=(Address)address.get(0);
				lat=add.getLatitude();
				lon=add.getLongitude();
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lon+"&radius=5000&types="+type+"&sensor=true&key=AIzaSyCWWRO2tgh-HRPnkAbkeutUjQMFMF7AqYY";
		new asy().execute();
		
	}
		if(v.getId()==R.id.button2)
		{
			map.clear();
		}
	}
}
