package com.pixel.dizainier;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, Switch.OnCheckedChangeListener {

    FitWindowsLinearLayout unites;
    FitWindowsLinearLayout disaines;
    Button seg0[] = new Button[10];
    Button seg1[] = new Button[10];
    Button moins;
    Button plus;
    SwitchCompat sw;
    SeekBar sb;
    TextView val;
    Button raz;
    ColorDrawable buttonColor;

    boolean hexa = false;
    int d = 0;
    int u = 0;
    int r = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unites = findViewById(R.id.seg0);
        disaines = findViewById(R.id.seg1);

        for(int i=0;i<unites.getChildCount();i++){
            seg0[i] = (Button) unites.getChildAt(i);
            seg0[i].setOnClickListener(this);
            seg0[i].setBackgroundResource(android.R.drawable.btn_default);
            seg1[i] = (Button) disaines.getChildAt(i);
            seg1[i].setOnClickListener(this);
            seg1[i].setBackgroundResource(android.R.drawable.btn_default);
        }

        raz = findViewById(R.id.raz);
        raz.setBackgroundResource(android.R.drawable.btn_default);
        raz.setOnClickListener(this);

        seg0[0].setPressed(true);
        seg1[0].setPressed(true);

        val = findViewById(R.id.val);
        sb = findViewById(R.id.mySeeker);
        sb.setOnSeekBarChangeListener(this);

        sw = findViewById(R.id.mySwitch);
        sw.setOnCheckedChangeListener(this);

        moins = findViewById(R.id.moins);
        moins.setBackgroundResource(android.R.drawable.btn_default);
        moins.setOnClickListener(this);
        plus = findViewById(R.id.plus);
        plus.setBackgroundResource(android.R.drawable.btn_default);
        plus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view instanceof Button) {
            Button b = (Button) view;
            seg0[u].setPressed(false);
            seg1[d].setPressed(false);
            switch (b.getId()) {
                case R.id.b10:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b11:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b12:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b13:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b14:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b15:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b16:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b17:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b18:
                    d = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b19:
                    d = Integer.parseInt(b.getText().toString());
                    break;

                case R.id.b00:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b01:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b02:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b03:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b04:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b05:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b06:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b07:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b08:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.b09:
                    u = Integer.parseInt(b.getText().toString());
                    break;
                case R.id.moins:
                    u--;
                    if (u < 0) {
                        if (d == 0) {
                            u = 0;
                        } else {
                            u = 9;
                            d--;
                        }
                    }
                    break;
                case R.id.plus:
                    u++;
                    if (u > 9) {
                        if (d == 9) {
                            u = 9;
                        } else {
                            u = 0;
                            d++;
                        }
                    }
                    break;
                case R.id.raz:
                    d = 0;
                    u = 0;
                    sb.setProgress(0);
                default:
                    break;
            }
            b.setPressed(true);
            r = d * 10 + u;
            seg0[u].setPressed(true);
            seg1[d].setPressed(true);
            sb.setProgress(r);
            val.setText("" + (hexa ? Integer.toHexString(r) : r));
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        hexa = b;
        if(b){
            val.setText(Integer.toHexString(r));
        }else{
            val.setText(""+r);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        r = i;
        seg0[u].setPressed(false);
        seg1[d].setPressed(false);
        d = r/10;
        u = r%10;
        val.setText(""+r);
        seg0[u].setPressed(true);
        seg1[d].setPressed(true);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
