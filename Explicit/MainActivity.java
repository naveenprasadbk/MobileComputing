package com.example.explicitintentslab;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button btnOpenUrl, btnOpenMap, btnDialNumber, btnSendSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        btnOpenMap = findViewById(R.id.btnOpenMap);
        btnDialNumber = findViewById(R.id.btnDialNumber);
        btnSendSms = findViewById(R.id.btnSendSms);
// Open URL
        btnOpenUrl.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });
// Open Location in Google Maps
        btnOpenMap.setOnClickListener(v -> {
            Uri mapUri = Uri.parse("geo:0,0?q=India+Gate,Delhi");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);

            }
        });

// Open Dial Pad
        btnDialNumber.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:1234567890"));
            startActivity(dialIntent);
        });
// Send SMS
        btnSendSms.setOnClickListener(v -> {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("smsto:1234567890"));
            smsIntent.putExtra("sms_body", "Hello! This is a test message.");
            startActivity(smsIntent);
        });
    }
}
