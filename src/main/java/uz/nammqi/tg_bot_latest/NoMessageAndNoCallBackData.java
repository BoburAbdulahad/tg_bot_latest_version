package uz.nammqi.tg_bot_latest;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class NoMessageAndNoCallBackData {

    private static String sendText = "";

    public static SendMessage sendMessageNoCallNoMessage(Update update){
        SendMessage sendMessage;
        Long chatId = update.getMessage().getChatId();
        sendText = "Jinsingizni tanlang:";
        //todo
        sendMessage = getSendMessage(chatId, sendText);
        InlineKeyboardMarkup inlineKeyboardMarkup = getJinsInlineKeyboardMarkup();
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);




        return sendMessage;
    }
    private static SendMessage getSendMessage(Long chatId, String sendText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(sendText);
        return sendMessage;
    }


    private static InlineKeyboardMarkup getJinsInlineKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton("Erkak");
        inlineKeyboardButton1.setCallbackData("e");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton("Ayol");
        inlineKeyboardButton2.setCallbackData("a");
        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        inlineKeyboardMarkup.setKeyboard(list);
        return inlineKeyboardMarkup;
    }
}
