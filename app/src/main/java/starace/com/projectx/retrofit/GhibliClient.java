package starace.com.projectx.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import starace.com.projectx.models.GhibliCharacter;

/**
 * Created by mstarace on 1/24/18.
 */

public interface GhibliClient {

    @GET("people/")
    Call<List<GhibliCharacter>> getCharacters();

}
