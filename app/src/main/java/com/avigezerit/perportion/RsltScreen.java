package com.avigezerit.perportion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Shaharli on 16/06/2016.
 */
public class RsltScreen extends Activity {

    private static final String TAG = RsltScreen.class.getSimpleName();

//    private TextView mShowRslt;
    public DisplayMetrics dm = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rslt_layout);

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int) (w*.8), (int) (h*.6));

        Intent receiveRsltIntent = getIntent();

        int actualRslt = receiveRsltIntent.getIntExtra("actualRslt", 0);

        TextView mShowRslt = (TextView) findViewById(R.id.rslt_value);

        Log.d(TAG, "result is: " + actualRslt);

        mShowRslt.setText((Integer.toString(actualRslt)));

        mShowRslt.setText((Integer.toString(actualRslt)));


    }

    public void onReset(View view){

        Intent backandReset = new Intent(this, MainActivity.class);

        startActivity(backandReset);

    }


}
