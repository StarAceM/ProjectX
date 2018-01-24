package starace.com.projectx.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import starace.com.projectx.R;
import starace.com.projectx.models.GhibliCharacter;
import starace.com.projectx.retrofit.GhibliClient;
import starace.com.projectx.retrofit.RetrofitClient;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getRandomCharacter();
    }

    private static void getRandomCharacter(){
        GhibliClient ghibliClient = RetrofitClient.getClient().create(GhibliClient.class);
        Call<List<GhibliCharacter>> call = ghibliClient.getCharacters();
        call.enqueue(new Callback<List<GhibliCharacter>>() {
            @Override
            public void onResponse(Call<List<GhibliCharacter>> call, Response<List<GhibliCharacter>> response) {

            }

            @Override
            public void onFailure(Call<List<GhibliCharacter>> call, Throwable t) {

            }
        });
    }
}
