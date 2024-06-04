package uz.nammqi.tg_bot_latest;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.nammqi.tg_bot_latest.service.DBConnect;

@Component
public class MyBot extends TelegramLongPollingBot {
    SendMessage sendMessage = null;

    public  static boolean isStartEdit=false;
    public  static boolean isEditText=false;


    @Override
    public void onUpdateReceived(Update update) {

        try {
            if (update.hasMessage()) {
                sendMessage = YesMessage.sendMessageReturnMessage(update);
            }

            if (update.hasCallbackQuery() && update.getCallbackQuery().getData().length()!=1) {
                sendMessage = YesCallBackData.sendMessageReturnCallBack(update);
            }

            if (isStartEdit) {//6-A ni davomi
                String chatIdStr = sendMessage.getChatId();
                Long chatId = Long.valueOf(chatIdStr);
                Integer messageId = execute(sendMessage).getMessageId();// Sending our message object to user
                DBConnect dbConnect=new DBConnect();
                dbConnect.insertMessageId(chatId, messageId);
                isStartEdit=false;
               //  break bolishi kk sababi 2 ta excute bajarilyapdi
            } else if (update.hasCallbackQuery() && update.getCallbackQuery().getData().length() == 1) {
                EditMessageText editMessageText = YesCallBackData.getEditMessageText(update);
                execute(editMessageText);
            } else execute(sendMessage);

//            if (isEditText && update.hasCallbackQuery()){
//                EditMessageText editMessageText = YesCallBackData.getEditMessageText(update);
//                execute(editMessageText);
//            }
             // Sending our message object to user
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
