package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android.jokedisplay.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class LoadJokeAsyncTask extends AsyncTask<Context, Void, String> {
  private static MyApi mJokeApiService = null;

  private Context mContext;

  @Override
  protected String doInBackground(Context... contexts) {
    if (mJokeApiService == null) {
      MyApi.Builder builder = new MyApi.Builder(
          AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          // options for running against local devappserver
          // - 10.0.2.2 is localhost's IP address in Android emulator
          // - turn off compression when running against local devappserver
          .setRootUrl("http://192.168.18.5:8080/_ah/api/")
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
              abstractGoogleClientRequest.setDisableGZipContent(true);
            }
          });
      // end options for devappserver

      mJokeApiService = builder.build();
    }

    mContext = contexts[0];
    try {
      return mJokeApiService.getJoke().execute().getData();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override
  protected void onPostExecute(String s) {
    Log.d("RAMIRO", s);
    Intent intent = new Intent(mContext, JokeActivity.class);
    intent.putExtra(Intent.EXTRA_TEXT, s);
    mContext.startActivity(intent);
  }
}
