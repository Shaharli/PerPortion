package com.avigezerit.perportion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private double mNumOfSlice;
    private double mGrams;
    private double mCalsPer100;
    public double mRslt;
    private EditText mtNumOfSlice;
    private EditText mtGrams;
    private EditText mtCalsPer100;
    private Button mCalc;
    private boolean allValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mtNumOfSlice = (EditText) findViewById(R.id.slice_amount);
        mtGrams = (EditText) findViewById(R.id.grams);
        mtCalsPer100 = (EditText) findViewById(R.id.cls_per_100);

        mCalc = (Button) findViewById(R.id.calc_btn);

        mtNumOfSlice.addTextChangedListener(new TextValidator(mtNumOfSlice) {
            @Override
            public void validate(TextView textView) {
                validateThis(mtNumOfSlice);

            }
        });

        mtGrams.addTextChangedListener(new TextValidator(mtGrams) {
            @Override
            public void validate(TextView textView) {
                validateThis(mtGrams);

            }
        });

        mtCalsPer100.addTextChangedListener(new TextValidator(mtCalsPer100) {
            @Override
            public void validate(TextView textView) {
                validateThis(mtCalsPer100);

            }
        });

    }

    public void isAllValid(Boolean s, Boolean g, Boolean c) {

        if (s == false || g == false || c == false) {
            setAllValid(false);
        }
        setAllValid(true);
    }


    public double calcSlice(Double mNumOfSlice, Double mGrams, Double mCalsPer100) {

        double rslt = ((mGrams / mNumOfSlice) * mCalsPer100) / 100;
        return rslt;
    }

    public double getmRslt() {
        return mRslt;
    }

    public void setmRslt(double mRslt) {
        this.mRslt = mRslt;
    }

    public double getmNumOfSlice() {
        return mNumOfSlice;
    }

    public void setmNumOfSlice(EditText e) {

        this.mNumOfSlice = Integer.valueOf((e.getText().toString()));
    }

    public boolean getAllValid() {
        return allValid;
    }

    public void setAllValid(boolean allValid) {
        this.allValid = allValid;
    }


    public double getmGrams() {
        return mGrams;
    }

    public void setmGrams(EditText e) {
        this.mGrams = Integer.valueOf(e.getText().toString());
    }

    public double getmCalsPer100() {
        return mCalsPer100;
    }

    public void setmCalsPer100(EditText e) {
        this.mCalsPer100 = Integer.valueOf(e.getText().toString());
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

    public boolean validateThis(TextView e) {

        if (e.getText().toString().length() == 0 ||
                e.getText().toString() == null ||
                Integer.parseInt(e.getText().toString()) == 0) {
            Log.d(TAG, "text is 0");
            e.setError("Check number");
        }
        return false;
    }

    public void onSendRslt(View view) {


        if (mtNumOfSlice.length() == 0 || Integer.valueOf((mtNumOfSlice.getText().toString())) == 0  || mtGrams.length() == 0 || Integer.valueOf((mtGrams.getText().toString())) == 0 ||  mtCalsPer100.length() == 0 || Integer.valueOf((mtCalsPer100.getText().toString())) == 0) {
            Log.d(TAG, "String is empty or null!");
            Toast toast = Toast.makeText(getApplicationContext(), "Make sure all fields are vaild", Toast.LENGTH_SHORT);
            toast.show();
        }

         else  {

            setmNumOfSlice(mtNumOfSlice);
            setmGrams(mtGrams);
            setmCalsPer100(mtCalsPer100);

            setmRslt(calcSlice(mNumOfSlice, mGrams, mCalsPer100));

            Intent getRsltScreenIntent = new Intent(this, RsltScreen.class);

            int actualrslt = (int) getmRslt();

            getRsltScreenIntent.putExtra("actualRslt", actualrslt);

            Log.d(TAG, "rslt is +" + getmRslt());

            startActivity(getRsltScreenIntent);
        }


    }

    @Override
    public void onBackPressed() {
        Intent backToMain = new Intent(this, CategoriesActivity.class);
        startActivity(backToMain);
    }
}
