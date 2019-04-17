package com.tck.jnidemo.jnicalculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tck.jnidemo.R;

/**
 * <p>description:</p>
 * <p>created on: 2019/4/17 11:12</p>
 *
 * @author tck
 * @version 3.3
 */
public class JniCalculatorActivity extends AppCompatActivity {


    private EditText etNumber1;
    private EditText etNumber2;
    private Button btCalculator;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jni_calculator_activity);
        etNumber1 = (EditText) findViewById(R.id.et_number1);
        etNumber2 = (EditText) findViewById(R.id.et_number2);
        btCalculator = (Button) findViewById(R.id.bt_calculator);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator();
            }
        });
    }

    private void calculator() {
        String number1 = etNumber1.getText().toString().trim();
        String number2 = etNumber2.getText().toString().trim();
        if (TextUtils.isEmpty(number1)) {
            return;
        }
        if (TextUtils.isEmpty(number2)) {
            return;
        }
        int plus = JniCalculatorUtils.plus(Integer.parseInt(number1), Integer.parseInt(number2));
        tvResult.setText(String.valueOf(plus));
    }
}
