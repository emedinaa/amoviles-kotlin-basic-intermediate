## Google Maps

Maps sdk for Android https://developers.google.com/maps/documentation/android-sdk/intro

1. Crear proyecto en la google API console.
2. Activar Librería Google Maps for Android.
3. Crear un nuevo proyecto y agregar dependencias de google maps y location api.
4. Crear key para aplicación Android.
5. Agregar mapa a tu proyecto.

Integrar Maps a un proyecto Android https://cloud.google.com/maps-platform/maps/

```java
public class MapPane extends Activity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
    }
}

```

Agregar un Marker

```java
public class MapPane extends Activity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }
}
```

Mover la cámara o área del mapa a un punto(lat,lng) en espécifico :

```java
 @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }
```

Custom markers

```java
   @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(41.889, -87.622), 16));

        // You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house_flag))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(41.889, -87.622)));
    }

```

Animar Cámara

```java
  @Override
    public void onMapReady(GoogleMap map) {
        LatLng mapCenter = new LatLng(41.889, -87.622);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter, 13));

        // Flat markers will rotate when the map is rotated,
        // and change perspective when the map is tilted.
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.direction_arrow))
                .position(mapCenter)
                .flat(true)
                .rotation(245));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(mapCenter)
                .zoom(13)
                .bearing(90)
                .build();

        // Animate the change in camera view over 2 seconds
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                2000, null);
    }

```

Polylines

```java
@Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-18.142, 178.431), 2));

        // Polylines are useful for marking paths and routes on the map.
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-33.866, 151.195))  // Sydney
                .add(new LatLng(-18.142, 178.431))  // Fiji
                .add(new LatLng(21.291, -157.821))  // Hawaii
                .add(new LatLng(37.423, -122.091))  // Mountain View
        );
    }

```

- Location API

User Location https://developer.android.com/training/location/

Obtener la última ubicación conocida (Last known location)

Se requiere el siguiente permiso :
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.google.android.gms.location.sample.basiclocationsample" >

  <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
</manifest>
```
Inicializar el cliente 'FusedLocationProviderClient' :
```java
private FusedLocationProviderClient mFusedLocationClient;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // ...

    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
}
```

Para obtener la última ubicación conocida del usuario invocamos el método "getLastLocation()"

```java
mFusedLocationClient.getLastLocation()
        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                // Got last known location. In some rare situations this can be null.
                if (location != null) {
                    // Logic to handle location object
                }
            }
        });
```

Solicitar actualizaciones de ubicación del usuario

Se requiere el siguiente permiso

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.google.android.gms.location.sample.locationupdates" >

  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
</manifest>
```
Iniciar solicitud

```java
@Override
protected void onResume() {
    super.onResume();
    if (mRequestingLocationUpdates) {
        startLocationUpdates();
    }
}

private void startLocationUpdates() {
    mFusedLocationClient.requestLocationUpdates(mLocationRequest,
            mLocationCallback,
            null /* Looper */);
}
```
Recibir ubicaciones

```java
private LocationCallback mLocationCallback;

// ...

@Override
protected void onCreate(Bundle savedInstanceState) {
    // ...

    mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult == null) {
                return;
            }
            for (Location location : locationResult.getLocations()) {
                // Update UI with location data
                // ...
            }
        };
    };
}
```

Detener actualizaciones

```java
@Override
protected void onPause() {
    super.onPause();
    stopLocationUpdates();
}

private void stopLocationUpdates() {
    mFusedLocationClient.removeLocationUpdates(mLocationCallback);
}
```

Detectar cuando un usuario inicia o finaliza un recorrido https://developer.android.com/guide/topics/location/transitions

Crear y monitorear Geofences , esto te permite saber si un usuario en movimiento ingresa o sale de un área (circular)

https://developer.android.com/training/location/geofencing

## Referencias

- Create and monitor geofences https://developer.android.com/training/location/geofencing

- Maps SDK for Android https://developers.google.com/maps/documentation/android-sdk/intro

- Maps SDK for Android samples https://developers.google.com/maps/documentation/android-sdk/code-samples

- User location https://developer.android.com/training/location/

- Location and Maps https://developer.android.com/guide/topics/location/

- Location strategies https://developer.android.com/guide/topics/location/strategies

- Places SDK for Android https://developers.google.com/places/android-sdk/intro

- Google Codelabs (Android) https://codelabs.developers.google.com/?cat=Android

- Background Locations updates https://codelabs.developers.google.com/codelabs/background-location-updates-android-o/index.html?index=..%2F..%2Findex#0

- MyMaps http://google.com/mymaps

- Google API console https://console.developers.google.com/

- Mobile SDk Here https://developer.here.com/develop/mobile-sdks

- Mapbox https://www.mapbox.com/
