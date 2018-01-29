package starace.com.projectx.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import starace.com.projectx.ConnectionHelper;
import starace.com.projectx.R;
import starace.com.projectx.models.GhibliCharacter;
import starace.com.projectx.retrofit.RetrofitHelper;

import static starace.com.projectx.retrofit.RetrofitHelper.getRandomCharacter;


public class SplashActivity extends AppCompatActivity implements RetrofitHelper.RetrofitCallBack{

    private GhibliCharacter randomCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(ConnectionHelper.checkForConnection(getApplicationContext())) {
            getRandomCharacter(this);
        } else {
            //todo handle non-connected device
        }
    }

    @Override
    public void randomCharacterCallBack(GhibliCharacter character) {
        randomCharacter = character;
        initViews();
    }

    private void initViews() {
        if(randomCharacter != null) {
            if(!randomCharacter.getName().isEmpty()) {
                TextView nameText = findViewById(R.id.splash_name_text);
                nameText.setText(randomCharacter.getName());
            } else {
                //todo handle empty name
            }
        }

        Button enterButton = findViewById(R.id.splash_enter_button);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo go to film activity
            }
        });
    }
}
