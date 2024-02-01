package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "jonesjava_bot";   //t.me/jonesjava_bot.
    public static final String TOKEN = "6293044663:AAGWnjRYs3QCG2b01SugVa-ZVP9SBi_dQqE";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("HACKEAR NEVERA", "step_1_btn")


            );

        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT, Map.of("HACKEAR NEVERA", "step_1_btn",
                    "HACKEAR NEVERA", "step_1_btn","HACKEAR NEVERA", "step_1_btn"
                    )


            );
        }

        //if (getMessageText().contains("mi nombre es")){
            //sendTextMessageAsync("es un placer conocerte, Mi nombre es Michi");
        //}

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            addUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT, Map.of("HACKEAR NEVERA", "step_1_btn",
                            "HACKEAR NEVERA", "step_1_btn","HACKEAR NEVERA", "step_1_btn"
                    )


            );
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}