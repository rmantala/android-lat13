package id.ac.poliban.mi.latihan13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {
    /*
        JIka intent ditentukan target komponen nya maka dinamakan explicit intent
        Jika intent tidak ditentukan target appnya, maka dinamakan implicit intent

        contohnya ketika user membuka sebuah kontak, yang berisi data
        nama, phone, email, akun twitter, akun facebook. ketika user mencoba mengklik
        salah satu item data diatas, maka android akan menjalankan app yang sesuai dan
        telah terpasang pada smartphone pengguna (walaupun pengguna telah menginstall dan
        menguninstall default app-nya). sebuah komponen tidak perlu tau detail app apa yang
        harus digunakan untuk membuka sebuah alamat email, alamat website atau pun nomor handphone.
        Untuk itulah kegunaan implicit intent

        alurnya :

        1. buat intent
        2. tentukan action apa yang akan dijalankan, misalnya Intent.ACTION_VIEW
        3. tentukan data apa, jika ada
        4. Launching Activity
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvPhone = findViewById(R.id.tvPhone);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvGithub = findViewById(R.id.tvGithub);
        TextView tvMap = findViewById(R.id.tvMap);

        tvPhone.setOnClickListener(view -> {
            Intent intent = new Intent();
            Uri uri = Uri.parse("tel:" + tvPhone.getText().toString());
            intent.setAction(ACTION_DIAL);
            intent.setData(uri);
            startActivity(intent);
        });

        tvEmail.setOnClickListener(view -> {
            Uri uri = Uri.parse("mailto:" + tvEmail.getText().toString());
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        });

        tvGithub.setOnClickListener(view -> {
            Uri uri = Uri.parse(tvGithub.getText().toString());
            Intent intent = new Intent(ACTION_VIEW, uri);
            startActivity(intent);
        });

        tvMap.setOnClickListener(view -> startActivity(new Intent(ACTION_VIEW, Uri.parse("geo:" + tvMap.getText().toString()))));


    }
}
