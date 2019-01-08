package app.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.ver.update.VerUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VerUtil verUtil = new VerUtil(this);
        verUtil.verCheck("25","fc_duyinghaodai_android");
    }
}
