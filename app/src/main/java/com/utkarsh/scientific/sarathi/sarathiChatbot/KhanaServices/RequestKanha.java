package com.utkarsh.scientific.sarathi.sarathiChatbot.KhanaServices;

import static android.content.ContentValues.TAG;

import android.os.AsyncTask;
import android.util.Log;

import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.utkarsh.scientific.sarathi.sarathiChatbot.Utils.BotReply;

public class RequestKanha extends AsyncTask<Void, Void, DetectIntentResponse> {

    private final BotReply mInterface;
    private final SessionName session;
    private final SessionsClient sessionsClient;
    private final QueryInput queryInput;

    public RequestKanha(BotReply mInterface, SessionName session, SessionsClient sessionsClient,
                        QueryInput queryInput) {
        this.mInterface = mInterface;
        this.session = session;
        this.sessionsClient = sessionsClient;
        this.queryInput = queryInput;
    }

    @Override
    protected DetectIntentResponse doInBackground(Void... voids) {
        try {
            DetectIntentRequest detectIntentRequest =
                    DetectIntentRequest.newBuilder()
                            .setSession(session.toString())
                            .setQueryInput(queryInput)
                            .build();
            return sessionsClient.detectIntent(detectIntentRequest);
        } catch (Exception e) {
            Log.d(TAG, "doInBackground: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(DetectIntentResponse response) {
        mInterface.callback(response);
    }
}