package com.utkarsh.scientific.sarathi.sarathiChatbot.Utils;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;

public interface BotReply {

  void callback(DetectIntentResponse returnResponse);
}
