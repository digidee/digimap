package com.example.digimap;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements LocationListener {

	// private GoogleMap mMap;
	private GoogleMap googleMap;
	private static final String LOG_TAG = "digimap";
	private Marker marker, markerb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		if (googleMap == null) {
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

			if (location != null) {
				onLocationChanged(location);
			}
			locationManager.requestLocationUpdates(provider, 20000, 0,
					(LocationListener) this);

		}
		if (googleMap != null){
			marker = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.90961, 10.727077)).title("Charging Station"));
			
			markerb = googleMap.addMarker(new MarkerOptions().position(
					new LatLng(59.904779,10.788746)).title("Bus Lane"));
			
			marker.setVisible(false);
			markerb.setVisible(false);
		}

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
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

		// Zoom in the Google Map
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

		// Setting latitude and longitude in the TextView tv_location
		// tvLocation.setText("Latitude:" + latitude + ", Longitude:"+ longitude
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


		// googleMap.setMyLocationEnabled(true);
		marker.setVisible(b);
	}

	/**
	 * Added mark of Bus lanes
	 */
	private void setUpBus(boolean b) {


		// googleMap.setMyLocationEnabled(true);
		Log.d(LOG_TAG, "setUpBus - bool: "+b);
		markerb.setVisible(b);

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

		case R.id.toggle_bus:

			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			setUpBus(item.isChecked());
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
