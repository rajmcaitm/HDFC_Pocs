/*
package com.hdfc.whatsapp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.Arrays;

public class WhatsAppMessageWithMedia {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+15017122661"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Here's that picture of an owl you requested.")
            .setMediaUrl(
                Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))
            .create();

        System.out.println(message.getSid());
    }
}
*/