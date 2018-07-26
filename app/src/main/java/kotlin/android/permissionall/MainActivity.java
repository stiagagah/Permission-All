package kotlin.android.permissionall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int PERMISSION_ALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] PERMISSIONS = {
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.GET_ACCOUNTS,
                android.Manifest.permission.RECEIVE_SMS,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_PHONE_STATE,
                android.Manifest.permission.CAMERA
        };

        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int permission2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.GET_ACCOUNTS);
        int permission3 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_SMS);
        int permission4 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        int permission5 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permission6 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE);
        int permission7 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);


        if (permission == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Access Fine Location Aktif",Toast.LENGTH_LONG).show();
        }
        if (permission2 == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Get Account Aktif",Toast.LENGTH_LONG).show();
        }
        if (permission3 == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Receive Sms Aktif",Toast.LENGTH_LONG).show();
        }
        if (permission4 == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Read External Storage Aktif",Toast.LENGTH_LONG).show();
        }
        if (permission5 == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Write External Storage Aktif",Toast.LENGTH_LONG).show();
        }
        if (permission6 == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Read Phone State Aktif",Toast.LENGTH_LONG).show();
        }
        if (permission7 == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Camera Aktif",Toast.LENGTH_LONG).show();
        }

        if(!hasPermissions(this, PERMISSIONS)){
            Toast.makeText(this,"Permintaan Permission",Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
