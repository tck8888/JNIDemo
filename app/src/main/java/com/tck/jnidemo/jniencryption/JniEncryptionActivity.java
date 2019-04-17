package com.tck.jnidemo.jniencryption;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tck.jnidemo.R;

/**
 * <p>description:</p>
 * <p>created on: 2019/4/17 10:50</p>
 *
 * @author tck
 * @version 3.3
 */
public class JniEncryptionActivity extends AppCompatActivity {


    private EditText etEncryptionContent;
    private Button btnJniEncryption;
    private TextView tvJavaEncryptionResult;
    private Button btnJavaEncryption;
    private TextView tvJniEncryptionResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jni_encryption_activity);

        findViewById(R.id.ib_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etEncryptionContent = (EditText) findViewById(R.id.et_encryption_content);
        btnJniEncryption = (Button) findViewById(R.id.btn_jni_encryption);
        tvJavaEncryptionResult = (TextView) findViewById(R.id.tv_java_encryption_result);
        btnJavaEncryption = (Button) findViewById(R.id.btn_java_encryption);
        tvJniEncryptionResult = (TextView) findViewById(R.id.tv_jni_encryption_result);

    }
}
