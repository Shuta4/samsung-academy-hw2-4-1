package ru.samsung.itschool.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void run(View view) {
        final EditText fieldA = (EditText) findViewById(R.id.a);
        final EditText fieldB = (EditText) findViewById(R.id.b);
        final EditText fieldC = (EditText) findViewById(R.id.c);
        final TextView result = (TextView) findViewById(R.id.res);

        double a, b, c;
        try {
            a = Double.parseDouble(fieldA.getText().toString());
            b = Double.parseDouble(fieldB.getText().toString());
            c = Double.parseDouble(fieldC.getText().toString());
        } catch (Exception e) {
            result.setText(R.string.enter_numbers);
            return;
        }

        if (a == 0) {
            if (b == 0) {
                result.setText(c == 0 ? R.string.any_x : R.string.no_answers);
            } else {
                double x = -c / b;
                result.setText(String.format(Locale.getDefault(), "%.1f", x));
            }

        } else if (b == 0) {
            double x = 0;
            if (c == 0) {
                result.setText(String.format(Locale.getDefault(), "%.1f", x));
            } else {
                double div = -c / a;
                if (div < 0) {
                    result.setText(R.string.no_answers);
                } else {
                    x = Math.sqrt(div);
                    result.setText(String.format(Locale.getDefault(), "%.1f %.1f", x, -x));
                }
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                result.setText(R.string.no_answers);

            } else if (d == 0) {
                double x = -b / (2 * a);
                result.setText(String.format(Locale.getDefault(), "%.1f", x));

            } else {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                result.setText(String.format(Locale.getDefault(), "%.1f %.1f", x1, x2));

            }
        }

    }
}
