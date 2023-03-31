package com.utkarsh.scientific.sarathi.sarathiChatbot.helpers;

import android.os.AsyncTask;
import android.util.Log;

import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.utkarsh.scientific.sarathi.sarathiChatbot.interfaces.BotReply;

public class SendMessageInBg extends AsyncTask<Void, Void, DetectIntentResponse> {


    private final SessionName session;
    private final SessionsClient sessionsClient;
    private final QueryInput queryInput;
    private final String TAG = "async";
    private final BotReply botReply;

    public SendMessageInBg(BotReply botReply, SessionName session, SessionsClient sessionsClient,
                           QueryInput queryInput) {
        this.botReply = botReply;
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
        //handle return response here
        botReply.callback(response);
    }
}