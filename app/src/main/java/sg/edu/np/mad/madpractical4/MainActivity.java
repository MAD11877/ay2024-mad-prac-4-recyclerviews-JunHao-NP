package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//Added imports
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        boolean followed = intent.getBooleanExtra("followed", false);

        user = new User(name, description, 1, followed);

        if (name != null && description != null) {
            TextView tvName = findViewById(R.id.helloWorld);
            TextView tvDescription = findViewById(R.id.descriptionTxt);
            Button btnFollow = findViewById(R.id.followBTN);

            tvName.setText(user.name);
            tvDescription.setText(user.description);
            btnFollow.setText(user.followed ? "Followed" : "Follow");


            btnFollow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (user.followed) {
                        btnFollow.setText("UnFollowed");
                        user.followed = false;
                        Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    } else {
                        btnFollow.setText("Followed");
                        user.followed = true;
                        Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }





    }
}
