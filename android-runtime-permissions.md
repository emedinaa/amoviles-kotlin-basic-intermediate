## Runtime permissions

Agregar permisos al Manifest

```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.example.snazzyapp">

    <uses-permission android:name="android.permission.INTERNET"/>
    <!-- other permissions go here -->

    <application ...>
        ...
    </application>
</manifest>
```
A partir de Android 6 (API Level 23), adicional a agregar permisos en el Manifest , es requerido solicitar estos permisos en tiempo de ejecución.

Verificar permisos

```
if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.WRITE_CALENDAR)
        != PackageManager.PERMISSION_GRANTED) {
    // Permission is not granted
}
```

Solicitar permisos

```
// Here, thisActivity is the current activity
if (ContextCompat.checkSelfPermission(thisActivity,
        Manifest.permission.READ_CONTACTS)
        != PackageManager.PERMISSION_GRANTED) {

    // Permission is not granted
    // Should we show an explanation?
    if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
            Manifest.permission.READ_CONTACTS)) {
        // Show an explanation to the user *asynchronously* -- don't block
        // this thread waiting for the user's response! After the user
        // sees the explanation, try again to request the permission.
    } else {
        // No explanation needed, we can request the permission.
        ActivityCompat.requestPermissions(thisActivity,
                arrayOf(Manifest.permission.READ_CONTACTS),
                MY_PERMISSIONS_REQUEST_READ_CONTACTS)

        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
        // app-defined int constant. The callback method gets the
        // result of the request.
    }
} else {
    // Permission has already been granted
}
```

Capturar la acción cuando el usuario acepta o rechaza los permisos

```
override fun onRequestPermissionsResult(requestCode: Int,
        permissions: Array<String>, grantResults: IntArray) {
    when (requestCode) {
        MY_PERMISSIONS_REQUEST_READ_CONTACTS -> {
            // If request is cancelled, the result arrays are empty.
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
            } else {
                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
            return
        }

        // Add other 'when' lines to check for other
        // permissions this app might request.
        else -> {
            // Ignore all other requests.
        }
    }
}
```


## Referencias

- Request App Permissions https://developer.android.com/training/permissions/requesting.html

- Permissions Overview https://developer.android.com/guide/topics/permissions/overview.html

- Request permissions at runtime appropriately https://developer.android.com/distribute/best-practices/develop/runtime-permissions.html

- App Permissions https://developer.android.com/guide/topics/permissions/overview.html

- App Permissions Best Practices https://developer.android.com/training/permissions/usage-notes.html
