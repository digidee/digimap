package com.example.digimap;

import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;

public class MainActivity extends FragmentActivity implements LocationListener,
		OnMarkerClickListener {

	// private GoogleMap mMap;
	private GoogleMap googleMap;
	private static final String LOG_TAG = "digimap";

	boolean markerClicked;
	PolylineOptions rectOptions;
	Polyline polyline;

	Marker tm1;
	Marker tm2;
	Marker tm3;
	Marker tm4;
	Marker tm5;
	Marker tm6;
	Marker tm7;
	Marker tm8;
	Marker tm9;
	Marker tm10;
	Marker tm11;
	Marker tm12;
	Marker tm13;
	Marker tm14;
	Marker tm15;
	Marker tm16;
	Marker tm17;
	Marker tm18;
	Marker tm19;
	Marker tm20;
	Marker tm21;
	Marker tm22;
	Marker tm23;
	Marker tm24;

	private Location loc2;
	private float totald = 0;
	private float distanceToll = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setUpMapIfNeeded();
	}

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		// if (googleMap == null) {
		// Try to obtain the map from the SupportMapFragment.
		// Getting reference to the SupportMapFragment of activity_main.xml
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		googleMap = fm.getMap();

		// Enabling MyLocation Layer of Google Map
		googleMap.setMyLocationEnabled(true);

		// Getting LocationManager object from System Service
		// LOCATION_SERVICE
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		// Creating a criteria object to retrieve provider
		Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationManager.getBestProvider(criteria, true);

		// Getting Current Location
		Location location = locationManager.getLastKnownLocation(provider);
		loc2 = location;

		// Getting latitude of the current location
		double latitude = location.getLatitude();

		// Getting longitude of the current location
		double longitude = location.getLongitude();

		// Creating a LatLng object for the current location
		LatLng latLng = new LatLng(latitude, longitude);

		// Showing the current location in Google Map
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

		// Zoom in the Google Map
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

		googleMap.setOnMarkerClickListener(this);

		markerClicked = false;

		if (location != null) {
			onLocationChanged(location);
		}
		locationManager.requestLocationUpdates(provider, 20000, 0,
				(LocationListener) this);

		// }
		if (googleMap != null) {
			tm1 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.950111, 10.638628)).title(
					"Griniveien Saved 15NOK"));
			tm2 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.913274, 10.568075)).title(
					"Bærumsveien Saved 15NOK"));
			tm3 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.914764, 10.631139)).title(
					"Pårampe Granfoss fra Fornebu Saved 15NOK"));
			tm4 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.914787, 10.631171)).title(
					"Pårampe Granfoss fra E18 Saved 15NOK"));
			tm5 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.914787, 10.631171)).title(
					"Rampe Fornebu til E18 Saved 15NOK"));
			tm6 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.911535, 10.638285)).title(
					"Strandveien Saved 15NOK"));
			tm7 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.917903, 10.661459)).title(
					"E18 Maritim Saved 30NOK"));
			tm8 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.920678, 10.682530)).title(
					"Karenlyst Allè Saved 30NOK"));
			tm9 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.901508, 10.589104)).title(
					"Drammensveien Saved 30NOK"));
			tm10 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.927818, 10.709524)).title(
					"Middelthunsgate Saved 30NOK"));
			tm11 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.940353, 10.704031)).title(
					"Slemdalsveien Saved 30NOK"));
			tm12 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.941256, 10.717163)).title(
					"Rampe Store ringvei v/Gaustad Saved 30NOK"));
			tm13 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.883769, 10.771408)).title(
					"E18 Mosseveien Saved 30NOK"));
			tm14 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.889626, 10.768833)).title(
					"Kongsveien Saved 30NOK"));
			tm15 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.877740, 10.787201)).title(
					"Ekebergveien Saved 30NOK"));
			tm16 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.885793, 10.794454)).title(
					"Sandstuveien Saved 30NOK"));
			tm17 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.873432, 10.810118)).title(
					"E6 Europaveien Saved 30NOK"));
			tm18 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.873432, 10.810118)).title(
					"Lambertseterveien Saved 30NOK"));
			tm19 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.873518, 10.810032)).title(
					"R190 Ulven Saved 30NOK"));
			tm20 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.879161, 10.822992)).title(
					"E6 Djupdalsveien v/Alna Saved 30NOK"));
			tm21 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.916828, 10.846939)).title(
					"Tvetenveien Saved 30NOK"));
			tm22 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.936741, 10.935044)).title(
					"Stømsveien Saved 30NOK"));
			tm23 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.939966, 10.850029)).title(
					"Østre Aker vei Saved 30NOK"));
			tm24 = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.943921, 10.834408)).title(
					"RV4 Trondheimsveien Saved 30NOK"));

			tm1.setVisible(false);
			tm2.setVisible(false);
			tm3.setVisible(false);
			tm4.setVisible(false);
			tm5.setVisible(false);
			tm6.setVisible(false);
			tm7.setVisible(false);
			tm8.setVisible(false);
			tm9.setVisible(false);
			tm10.setVisible(false);
			tm11.setVisible(false);
			tm12.setVisible(false);
			tm13.setVisible(false);
			tm14.setVisible(false);
			tm15.setVisible(false);
			tm16.setVisible(false);
			tm17.setVisible(false);
			tm18.setVisible(false);
			tm19.setVisible(false);
			tm20.setVisible(false);
			tm21.setVisible(false);
			tm22.setVisible(false);
			tm23.setVisible(false);
			tm24.setVisible(false);

		}

	}

	@Override
	public boolean onMarkerClick(Marker marker) {

		
		// Getting latitude of the current location
		double latitude = marker.getPosition().latitude;

		// Getting longitude of the current location
		double longitude = marker.getPosition().longitude;


		// Creating a LatLng object for the current location
		LatLng latLng = new LatLng(loc2.getLatitude(), loc2.getLongitude());

		Location loc1 = new Location("");
		loc1.setLatitude(latitude);
		loc1.setLongitude(longitude);
		
		distanceToll = loc2.distanceTo(loc1);
		
		
		// Setting latitude and longitude in the TextView tv_location
		TextView tvLocation1 = (TextView) findViewById(R.id.tvLocation1);
		tvLocation1.setText("Distance to tollbooth: "+distanceToll);
		
		
		
		if (markerClicked) {

			if (polyline != null) {
				polyline.remove();
				polyline = null;
			}

			rectOptions.add(latLng);
			rectOptions.color(Color.RED);
			polyline = googleMap.addPolyline(rectOptions);
		} else {
			if (polyline != null) {
				polyline.remove();
				polyline = null;
			}


			
			markerClicked = true;
		}
		
		
		
		rectOptions = new PolylineOptions().add(marker.getPosition());
		
		
	
		
		

		return true;
	}

	@Override
	public void onLocationChanged(Location location) {

		// TextView tvLocation = (TextView) findViewById(R.id.tv_location);

		// Getting latitude of the current location
		double latitude = location.getLatitude();

		// Getting longitude of the current location
		double longitude = location.getLongitude();

		// Creating a LatLng object for the current location
		LatLng latLng = new LatLng(latitude, longitude);

		// Showing the current location in Google Map
		// googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

		// Zoom in the Google Map
		// googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

		float[] dist = new float[1];
		float ld = location.distanceTo(loc2);
		Location.distanceBetween(location.getLatitude(),
				location.getLongitude(), loc2.getLatitude(),
				loc2.getLongitude(), dist);
		totald += ld;
		loc2 = location;

		// Setting latitude and longitude in the TextView tv_location
		TextView tvLocation = (TextView) findViewById(R.id.tvLocation);
		tvLocation.setText("Latitude:" + latitude + ", Longitude:" + longitude
				+ "\n Distance from last point: " + ld
				+ " \nTotal distance traveled: " + totald);
		// );

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	/**
	 * Added mark of Charging stations
	 */
	private void setUpCharge(boolean b) {

	}

	/**
	 * Added mark of Bus lanes
	 */
	private void setUpToll(boolean b) {

		// googleMap.setMyLocationEnabled(true);
		Log.d(LOG_TAG, "setUpToll - bool: " + b);
		tm1.setVisible(b);
		tm2.setVisible(b);
		tm3.setVisible(b);
		tm4.setVisible(b);
		tm5.setVisible(b);
		tm6.setVisible(b);
		tm7.setVisible(b);
		tm8.setVisible(b);
		tm9.setVisible(b);
		tm10.setVisible(b);
		tm11.setVisible(b);
		tm12.setVisible(b);
		tm13.setVisible(b);
		tm14.setVisible(b);
		tm15.setVisible(b);
		tm16.setVisible(b);
		tm17.setVisible(b);
		tm18.setVisible(b);
		tm19.setVisible(b);
		tm20.setVisible(b);
		tm21.setVisible(b);
		tm22.setVisible(b);
		tm23.setVisible(b);
		tm24.setVisible(b);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.toggle_traffic:
			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			googleMap.setTrafficEnabled(item.isChecked());
			return true;

		case R.id.toggle_charging:

			if (item.isChecked())

				item.setChecked(false);
			else
				item.setChecked(true);
			setUpCharge(item.isChecked());
			return true;

		case R.id.toggle_toll:

			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			setUpToll(item.isChecked());
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
