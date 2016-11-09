package jbink.appnapps.jbinkretrofit.api;

import jbink.appnapps.jbinkretrofit.data.DataTest;
import jbink.appnapps.jbinkretrofit.data.QuestionData;
import jbink.appnapps.jbinkretrofit.data.ResponseData;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by user on 2016-11-08.
 */
public interface API_Interface {
    @FormUrlEncoded
    @POST("duplicate.php")
    Call<DataTest> Duplicate(@Field("id") String id);

    @GET("jbink_idol_question_list.php")
    Call<QuestionData> Question();

//    @Multipart
//    @POST("image_upload.php")//이미지업로드
//    Call<ResponseData> uploadImage(@Part MultipartBody.Part filePart);

    @Multipart
    @POST("image_upload.php")//이미지업로드
    //다른 파라미터가 있을때는 @Part로 같이 첨부
    Call<ResponseData> uploadImage (@Part MultipartBody.Part filePart , @Part("tmp_name") RequestBody tmp_name);
}
