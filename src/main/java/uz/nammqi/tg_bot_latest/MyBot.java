package uz.nammqi.tg_bot_latest;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyBot extends TelegramLongPollingBot {
    SendMessage sendMessage = null;



    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage()) {
                sendMessage = YesMessage.sendMessageReturnMessage(update);
            }

            if (update.hasCallbackQuery()) {
                sendMessage = YesCallBackData.sendMessageReturnCallBack(update);
            }

            execute(sendMessage); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }


    @Override
    public String getBotUsername() {
        return "usernammqibot";
    }

    @Override
    public String getBotToken() {
        return "6487618795:AAHJkDUJaGgR3x83TBYsyPg5BGNy8qBWds8";
    }

}
