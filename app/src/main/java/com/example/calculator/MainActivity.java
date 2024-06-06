package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView hienthi;
    String sa, sb;
    char op = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        hienthi = (TextView) findViewById(R.id.manhinh);
        sa = sb = "";

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void del(View view) {
        sa = "";
        hienthi.setText("");
    }

    public void so(View view) {
        Button tam  = (Button) view;
        sa += tam.getText();
        hienthi.setText(sa);
    }

    public void pheptinh(View view) {
        sb = sa;
        sa = "";
        Button tinh = (Button) view;
        String tam2 = tinh.getText().toString();
        op = tam2.charAt(0);
    }

    public void addDecimal(View view) {
        if (!sa.contains(".")) {
            sa += ".";
            hienthi.setText(sa);
        }
    }
    public void ketqua(View view) {
        double a = 0, b = 0, kq = 0;
        a = Double.valueOf(sb);
        b = Double.valueOf(sa);
        sa = sb = "";
        switch (op) {
            case '+':
                kq = a + b;
                break;
            case '-':
                kq = a - b;
                break;
            case 'x':
                kq = a * b;
                break;
            case '/':
                kq = a / b;
                break;
            default: kq = 0;
        }
        hienthi.setText(String.valueOf(kq));
    }
}