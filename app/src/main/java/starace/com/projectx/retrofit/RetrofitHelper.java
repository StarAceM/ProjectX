package starace.com.projectx.retrofit;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import starace.com.projectx.models.GhibliCharacter;
import starace.com.projectx.models.SearchResult;

/**
 * Created by mstarace on 1/29/18.
 */

public class RetrofitHelper {

    private static final String key = "AIzaSyAOGEfwB-lbS2x695gKpWNrTWyAEozf1go";
    private static final String cx = "006196028964560055520:_4n9klgynqm";

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

    public static void getSearchResults(String searchQuery) {
        SearchClient searchClient = RetrofitSearchClient.getClient().create(SearchClient.class);

        Call<SearchResult>call = searchClient.customSearch(getQueryMap(searchQuery));
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult searchResult = response.body();

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.d("THIS IS AN ERROR", t.toString());
            }
        });
    }

    private static Map<String, String> getQueryMap(String searchQuery) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("key", key);
        queryMap.put("cx", cx);
        queryMap.put("q", searchQuery);
        queryMap.put("searchType", "image");



        return queryMap;
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
