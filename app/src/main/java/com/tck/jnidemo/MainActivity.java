package com.tck.jnidemo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

//http://www.jianshu.com/p/ec846519be90
//http://blog.csdn.net/qq_30085577/article/details/50790743
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private String mS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        try {
            //app/dia.jks
            File file = new File("D:/AndroidStudioProjects/JNIDemo/app/dia.jks");
            FileInputStream fis = new FileInputStream(file);
            String str = "qwe123";
            char[] pass = str.toCharArray();
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(fis, pass);

            System.out.println("/***显示别名为aaa的证书**/");
            Certificate c=ks.getCertificate("tck");
            System.out.println(c.toString());

            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];
            mS = sign.toCharsString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    /*<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:background="@color/color_ffffff"
              android:orientation="vertical">

    <ImageView
        android:id="@+id/iv_left_back"
        android:layout_width="44dp"
        android:layout_height="44dp"
        android:scaleType="center"
        android:src="@mipmap/title_bar_return"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginLeft="40dp"
        android:layout_marginRight="40dp"
        android:orientation="vertical">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="16dp"
            android:text="密码找回"
            android:textColor="@color/color_434343"
            android:textSize="22sp"/>

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="2dp"
            android:layout_marginTop="16dp">

            <View
                android:layout_width="match_parent"
                android:layout_height="2dp"
                android:background="@color/divider_color"/>

            <View
                android:layout_width="80dp"
                android:layout_height="2dp"
                android:background="@color/color_2bc8a0"/>
        </FrameLayout>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="30dp"
            android:text="手机号"
            android:textColor="#999999"
            android:textSize="16sp"/>

        <EditText
            android:id="@+id/mobile"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:background="@null"
            android:hint="输入手机号"
            android:inputType="number"
            android:maxLength="11"
            android:singleLine="true"
            android:textColor="@color/color_434343"
            android:textColorHint="#CCCCCC"
            android:textSize="15sp"/>

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="2dp"
            android:background="@color/divider_color"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:text="验证码"
            android:textColor="#999999"
            android:textSize="16sp"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:orientation="horizontal">

            <EditText
                android:id="@+id/captcha"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:layout_weight="1"
                android:background="@null"
                android:gravity="center_vertical"
                android:hint="请输入验证码"
                android:inputType="number"
                android:singleLine="true"
                android:textColor="@color/color_434343"
                android:textColorHint="#CCCCCC"
                android:textSize="15sp"/>

            <!-- android:onClick="getCaptcha"-->
            <Button
                android:id="@+id/get_captcha_button"
                android:layout_width="wrap_content"
                android:layout_height="40dp"
                android:layout_gravity="center_vertical"
                android:background="@drawable/shape_corner_20dp_solid_2bc8a0"
                android:paddingLeft="20dp"
                android:paddingRight="20dp"
                android:text="获取验证码"
                android:textColor="@color/color_ffffff"
                android:textSize="14sp"/>
        </LinearLayout>

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="2dp"
            android:background="@color/divider_color"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:text="密码"
            android:textColor="#999999"
            android:textSize="16sp"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:orientation="horizontal">

            <EditText
                android:id="@+id/password"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_marginTop="15dp"
                android:layout_weight="1"
                android:background="@null"
                android:hint="请输入6到16位密码"
                android:inputType="textPassword"
                android:singleLine="true"
                android:textColor="@color/color_434343"
                android:textColorHint="#CCCCCC"
                android:textSize="15sp"/>

            <ImageView
                android:id="@+id/password_eye"
                android:layout_width="20dp"
                android:layout_height="20dp"
                android:layout_gravity="center_vertical"
                android:clickable="true"
                android:onClick="changePasswordType"
                android:src="@mipmap/icon_password_eye"/>
        </LinearLayout>

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="2dp"
            android:background="@color/divider_color"/>

        <Button
            android:id="@+id/btn_submit"
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:layout_marginTop="50dp"
            android:background="@drawable/general_main_color_bg"
            android:text="确认"
            android:textColor="@color/color_ffffff"
            android:textSize="16sp"/>
    </LinearLayout>
</LinearLayout>*/
}
