package com.aaron.jcpennyprepassignment.data.WebData;

import android.os.AsyncTask;
import android.util.Log;

import com.aaron.jcpennyprepassignment.Events.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;
import static com.aaron.jcpennyprepassignment.data.Constants.LogConstants.RANDOM_ME_ASYNC_BACK;
import static com.aaron.jcpennyprepassignment.data.Constants.URLConstants.RANDOM_ME_BASE_URL;


/**
 * Created by aaron on 10/10/17.
 */

public class GetRandomPeopleService extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;
        String jsonString = "";
        try {
            URL url = new URL(RANDOM_ME_BASE_URL);
            urlConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()){
                jsonString = jsonString + scanner.nextLine();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }

        return jsonString;
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        EventBus.getDefault().post(new MessageEvent(jsonString));

    }
}
