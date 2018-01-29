package starace.com.projectx.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
        getRandomCharacter(this);
    }

    @Override
    public void randomCharacterCallBack(GhibliCharacter character) {
        randomCharacter = character;
        initViews();
    }

    private void initViews() {

    }
}
