package sg.edu.rp.webservices.sa_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        iv = findViewById(R.id.iv);
        String imageUrl = "https://codelab.myapplicationdev.com/img/about.jpg";
        Picasso.with(this).load(imageUrl).into(iv);
    }
}
