package ops.dev.en.hms.enabledeveloperoptions;

import android.annotation.TargetApi;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Process rootProcess = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            rootProcess = Runtime.getRuntime().exec("su");
            Toast.makeText(this,"root",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this,"can't root",Toast.LENGTH_LONG).show();
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void enableDeveloperOptions(View but){
        try {
            //rootProcess = Runtime.getRuntime().exec("su");
            Settings.Global.putInt(getContentResolver(), Settings.Global.ADB_ENABLED, 1);
        } catch (Exception e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
