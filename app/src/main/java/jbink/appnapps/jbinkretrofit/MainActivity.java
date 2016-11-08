package jbink.appnapps.jbinkretrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import jbink.appnapps.jbinkretrofit.api.API_Adapter;
import jbink.appnapps.jbinkretrofit.data.DataTest;
import jbink.appnapps.jbinkretrofit.data.QuestionData;
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
            return null;
        }
    }

}
