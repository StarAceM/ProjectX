package starace.com.projectx.retrofit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import starace.com.projectx.models.GhibliCharacter;

/**
 * Created by mstarace on 1/29/18.
 */

public class RetrofitHelper {

    public static void getRandomCharacter(RetrofitCallBack callBack) {
        getCharacterList(callBack);
    }

    //selects character and passes it to call back
    private static void selectCharacter(List<GhibliCharacter> characterList, RetrofitCallBack callBack) {
        Random random = new Random();
        callBack.randomCharacterCallBack(characterList.get(random.nextInt(characterList.size())));
    }

    //gets all the characters and calls selectCharacter from onResponse
    public static void getCharacterList(final RetrofitCallBack callBack) {

        GhibliClient ghibliClient = RetrofitClient.getClient().create(GhibliClient.class);
        Call<List<GhibliCharacter>> call = ghibliClient.getCharacters();
        call.enqueue(new Callback<List<GhibliCharacter>>() {
            @Override
            public void onResponse(Call<List<GhibliCharacter>> call, Response<List<GhibliCharacter>> response) {
                selectCharacter(response.body(), callBack);
            }

            @Override
            public void onFailure(Call<List<GhibliCharacter>> call, Throwable t) {
                //todo handle error
            }
        });
    }

    //gets all the characters from a film
    public static List<GhibliCharacter> getCharacterList(String filmTitle) {
        //todo complete this method
        return new ArrayList<GhibliCharacter>();
    }

    public interface RetrofitCallBack {
        void randomCharacterCallBack(GhibliCharacter character);
    }
}
