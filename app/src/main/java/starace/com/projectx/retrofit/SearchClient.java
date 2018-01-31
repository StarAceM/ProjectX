package starace.com.projectx.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import starace.com.projectx.models.SearchResult;

/**
 * Created by mstarace on 1/31/18.
 */

public interface SearchClient {

    @GET("customsearch/v1")
    Call<SearchResult>customSearch(@QueryMap Map<String, String> options);

}
