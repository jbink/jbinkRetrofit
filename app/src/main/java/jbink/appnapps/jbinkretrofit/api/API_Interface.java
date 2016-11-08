package jbink.appnapps.jbinkretrofit.api;

import jbink.appnapps.jbinkretrofit.data.DataTest;
import jbink.appnapps.jbinkretrofit.data.QuestionData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by user on 2016-11-08.
 */
public interface API_Interface {
    @FormUrlEncoded
    @POST("duplicate.php")
    Call<DataTest> Duplicate(@Field("id") String id);

    @GET("jbink_idol_question_list.php")
    Call<QuestionData> Question();
}
