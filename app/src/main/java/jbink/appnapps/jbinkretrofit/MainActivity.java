package jbink.appnapps.jbinkretrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

import jbink.appnapps.jbinkretrofit.api.API_Adapter;
import jbink.appnapps.jbinkretrofit.data.DataTest;
import jbink.appnapps.jbinkretrofit.data.QuestionData;
import jbink.appnapps.jbinkretrofit.data.ResponseData;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ApiAsyncTask().execute();

    }


    private class ApiAsyncTask extends AsyncTask<Void, Void, Void> {

        public ApiAsyncTask(){

        }

        @Override
        protected Void doInBackground(Void... params) {
            //GET
            Call<QuestionData> question = API_Adapter.getInstance().Question();
            question.enqueue(new Callback<QuestionData>() {
                @Override
                public void onResponse(Call<QuestionData> call, Response<QuestionData> response) {

                }

                @Override
                public void onFailure(Call<QuestionData> call, Throwable t) {

                }
            });

            //POST
            Call<DataTest> data = API_Adapter.getInstance().Duplicate("ID");
            data.enqueue(new Callback<DataTest>() {
                @Override
                public void onResponse(Call<DataTest> call, Response<DataTest> response) {

                }

                @Override
                public void onFailure(Call<DataTest> call, Throwable t) {

                }
            });

            //FILE UPLOAD
            String dir = Environment.getExternalStorageDirectory().toString()+"/ISNTIT/profile_pic.png";
            File file = new File(dir);// initialize file here
//            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
//            Call<ResponseData> upload = API_Adapter.getInstance().uploadImage(filePart, "retrofit_upload");

            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("upfile", file.getName(), reqFile);
            RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "retrofit_upload");
            Call<ResponseData> upload = API_Adapter.getInstance().uploadImage(body, name);

            upload.enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                    Log.d("where", response.message());
                    Log.d("where", response.toString());
                    Log.d("where", response.body().toString());
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    Log.d("where", "fail : " + t.toString());
                }
            });
           return null;
        }
    }

}
