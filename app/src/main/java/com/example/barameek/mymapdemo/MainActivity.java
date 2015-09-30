package com.example.barameek.mymapdemo;

import android.app.ProgressDialog;
import android.location.Address;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String mCurrentLocStr;
    List<Address> addressList = null;
    static ProgressDialog progDialog = null;
    private TextView mLocTextView;
    private EditText mAddressEditText;
    private ImageView mGeoCodingBtn;
    private GoogleMap mMapView;
    private static final long UPDATE_INTERVAL = 5000;
    private static final long FASTEST_INTERVAL = 1000;
    private List<LatLng> listOfLatLng = new ArrayList<>();
    private LocationRequest mRequest;
    public static int REQ_GEO_CODING_SEARCH = 1;
    private GoogleApiClient mApiClient;
    private Polygon polygon;
    private MarkerOptions mapMarker;
    int currentPt;
    int mAnimationZoom = 15;
    private TextView mAnimationBtn;
    int mPinDrawables[] = new int[]{R.drawable.pin_01,
            R.drawable.pin_02,
            R.drawable.pin_03,
            R.drawable.pin_04,
            R.drawable.pin_05,
            R.drawable.pin_06,
            R.drawable.pin_07};
    private int pinCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();
        setWidgetEventListener();

    }

    private void setWidgetEventListener() {
        mGeoCodingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void bindWidget() {
        SupportMapFragment mySupportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mMapView);
        mMapView = mySupportMapFragment.getMap();
        mLocTextView = (TextView) findViewById(R.id.mLocationTextView);
        mGeoCodingBtn = (ImageView) findViewById(R.id.mGeoCodingBtn);
        mAnimationBtn = (TextView) findViewById(R.id.mAnimationBtn);
        mAddressEditText = (EditText) findViewById(R.id.mAddressEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
