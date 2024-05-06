package uz.nammqi.tg_bot_latest;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.nammqi.tg_bot_latest.service.DBConnect;

import java.util.ArrayList;
import java.util.List;

public class YesMessage {


    private static String sendText = "";


    public static SendMessage sendMessageReturnMessage(Update update) {

        DBConnect dbConnect = new DBConnect();


        SendMessage sendMessage = new SendMessage();
        Message message = update.getMessage();

        String getUserText = message.getText();
        String firstName = message.getFrom().getFirstName();
        Long chatId = update.getMessage().getChatId();


        if (YesCallBackData.isArea && YesCallBackData.isPerson) {//todo tHE LAST STEP
            dbConnect.insertMurojaatMatni(chatId,getUserText);
            sendText = "Murojaatingiz uchun Tashakkur!!!";
            sendMessage = getSendMessage(chatId, sendText);
            //todo davomm ettirish kk!!!!!!!!!!!!!!!!!!!


            YesCallBackData.isArea = false;
            YesCallBackData.ismFam = false;
            YesCallBackData.isPerson = false;

        } else if (getUserText == null) {//TODO STEP 5 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            String phoneNumber = message.getContact().getPhoneNumber();
            dbConnect.insertPhone(chatId,phoneNumber);
            sendText = "Jinsingizni tanlang:";
            sendMessage = getSendMessage(chatId, sendText);
            InlineKeyboardMarkup inlineKeyboardMarkup = getJinsInlineKeyboardMarkup();
            sendMessage.setReplyMarkup(inlineKeyboardMarkup);


        } else {
            switch (getUserText) {  //TODO STEP 1-A
                case "/start":

                    try {
                        String userName = message.getFrom().getUserName();
                        if (userName == null)
                            userName = "no_username";
                        dbConnect.insertUser(chatId, userName);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    sendText = "Assalomu alaykum " + firstName + "\n" + "Sizga Namangan Muhndislik Qurilish Instituti rektoriga bevosita " +
                            "elektron tarzda murojaatlarni yuborish imkoniyati taqdim etilmoqda." +
                            " Shu bilan birga, Sizning yuborayotgan murojaatingiz rasmiy maqomga ega ekanligini ham eslatib qo'ymoqchimiz." +
                            "Shu sababli, Sizdan ommaviy oferta bilan tanishib chiqishni unutmasligingizni so'raymiz!!!";
                    sendMessage = getSendMessageByReplyKeyboard(chatId, sendText);


                    break;
                case "Ommaviy oferta":
                    sendText = "1)Murojaat yo`llayotganingizda familiyangiz (ismingiz, otangizning ismi), yashash joyingiz to'g'risidagi ma'lumotlar ko'rsatilgan va murojaatingiz mohiyati bayon etilgan bo'lishi shart.\n" +
                            "2)Alohida e'tibor bering! Tuhmat, haqorat so'zlar ishlatilgan va yolg'on xabar beruvchi murojaatlarni taqdim etish mumkin emas.\n" +
                            "3)Shuningdek, quyidagi holatlarda murojaatlaringiz rad etilishi mumkinligini eslatib o'tmoqchimiz:\n" +
                            "odobsizlik mazmunidagi murojaatlar (uyatsiz yoxud haqoratli iboralar, tahdidlar, mantiq va ma'nosi bo'lmagan takliflar va shunga o'xshash murojaatlar);\n" +
                            "murojaat matnida tushunarsiz qisqartirishlar yoki reklama materiallari mavjud bo'lgan, tarkibida aniq arizalar, shikoyatlar yoki takliflar bo'lmagan murojaatlar\n" +
                            "4)Shuningdek, foydalanuvchining bir necha bor bitta masala bo'yicha javob berilgan murojaatini qayta yuborilganda agar unda yangi vajlar yoki holatlar keltirilmagan bo'lsa, ko'rib chiqilmaydi.\n" +
                            "Mazkur shartlarning barchasi O'zbekiston Respublikasining amaldagi qonunchiligidan kelib chiqqan holda belgilangan.";
                    sendMessage = getSendMessageByReplyKeyboard(chatId, sendText);
                    break;
                case "Rahbariyatning qabul vaqtlari":
                    sendText = "Namangan Muhndislik Qurilish Instituti rahbarlarining jismoniy va yuridik shaxslarni qabul qilish vaqtlari:\n" +
                            "Rektor\n" +
                            "Qabul vaqti xar kuni* soat (800 - 1000)\n" +
                            "Shermuhammadov Bahodirjon Shermuhammadovich\n" +
                            "Tel: 0 (373) 244-44-02\n" +
                            "Faks: 0 (373) 244-44-93\n" +
                            "E-mail: [email protected]\n" +
                            "Yoshlar masalalari va ma'naviy-ma'rifiy ishlar bo'yicha birinchi prorektor\n" +
                            "Qabul vaqti haftaning har dushanba kuni soat (1500 - 1700)\n" +
                            "RAHIMOV ZOKIR AZIMOVICH\n" +
                            "Tel: 0 (373) 244-44-86\n" +
                            "Faks: 0 (373) 244-44-91\n" +
                            "E-mail: [email protected]\n" +
                            "O`quv ishlari bo`yicha prorektor\n" +
                            "Qabul vaqti haftaning har seshanba kuni soat (1500 - 1700)\n" +
                            "SHUKUROV RAHMATILLO MIRZATILLAYEVICH\n" +
                            "Tel: 0 (373) 244-44-80\n" +
                            "Faks: 0 (373) 244-44-91\n" +
                            "E-mail: [email protected]\n" +
                            "Ilmiy ishlar va innovatsiyalar bo'yicha prorektor\n" +
                            "Qabul vaqti haftaning har juma kuni soat (1500 - 1700)\n" +
                            "ZOKIROV ISLOMJON ILHOMJONOVICH\n" +
                            "Tel: 0 (373) 244-44-29\n" +
                            "Faks: 0 (373) 244-44-91\n" +
                            "E-mail: [email protected]\n" +
                            "Xalqaro hamkorlik va moliya-iqtisod ishlari bo'yicha prorektor v.v.b.\n" +
                            "Qabul vaqti haftaning har juma kuni soat (1500 - 1700)\n" +
                            "SHUXRATOV SHAROF SHUXRATOVICH\n" +
                            "Tel: 0 (373) 244-44-29\n" +
                            "Faks: 0 (373) 244-44-91\n" +
                            "E-mail: [email protected]\n" +
                            "* Rektor xizmat safarida bo`lganda qabul prorektorlardan biri tomonidan o`tkaziladi.\n" +
                            "Eslatma: Murojaatingiz tezkor ravishda hal etilishini istasangiz, har bir masala bo‘yicha alohida murojaat yo‘llashingizni hamda mazkur murojaatni lo‘nda, oddiy va ravon tilda bayon etishingizni so‘raymiz ! ";
                    sendMessage = getSendMessageByReplyKeyboard(chatId, sendText);

                    break;
                case "Murojaat yo`llash":
                    sendText = "Murojaat turini tanlang:";  //todo STEP 1-B ////////////////////////////////////////////
                    sendMessage = getSendMessage(chatId, sendText);

                    InlineKeyboardMarkup inlineKeyboardMarkup = getInlineKeyboardMarkup();


                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    break;


            }


            if (update.hasMessage() && !getUserText.isEmpty() && !getUserText.equals("/start")                //TODO STEP 3 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                    && !getUserText.equals("Murojaat yo`llash") && !getUserText.equals("Ommaviy oferta")
                    && !getUserText.equals("Rahbariyatning qabul vaqtlari") && YesCallBackData.ismFam && !YesCallBackData.isArea) {


                dbConnect.insertFullName(chatId,getUserText);
                /*HUDUD*/      sendText = "Hududni tanlang: ";

                sendMessage = getSendMessage(chatId, sendText);
                InlineKeyboardMarkup inlineKeyboardMarkup = new Hudud().getInlineHududTanlash();
                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                YesCallBackData.isArea = true;

            }
            // the newest added at last

            if (sendMessage.getText() == null) {
                sendText = "Xatolik! Boshqatdan urinib koring!";
                sendMessage = getSendMessage(chatId, sendText);

            }


        }

        return sendMessage;
    }


    private static InlineKeyboardMarkup getJinsInlineKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton("Erkak" + EmojiParser.parseToUnicode(" :man: "));
        inlineKeyboardButton1.setCallbackData("erkak");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton("Ayol" + EmojiParser.parseToUnicode(" :woman: "));
        inlineKeyboardButton2.setCallbackData("ayol");
        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        list.add(inlineKeyboardButtonList);
        inlineKeyboardMarkup.setKeyboard(list);
        return inlineKeyboardMarkup;
    }

    private static SendMessage getSendMessageByReplyKeyboard(Long chatId, String sendText) {

        SendMessage sendMessage = getSendMessage(chatId, sendText);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = getKeyboardRows();

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);


        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private static List<KeyboardRow> getKeyboardRows() {
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton("Ommaviy oferta");
        KeyboardButton keyboardButton2 = new KeyboardButton("Murojaat yo`llash");
        KeyboardButton keyboardButton3 = new KeyboardButton("Rahbariyatning qabul vaqtlari ");
        keyboardRow1.add(keyboardButton1);
        keyboardRow2.add(keyboardButton2);
        keyboardRow3.add(keyboardButton3);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        return keyboardRows;
    }

    private static SendMessage getSendMessage(Long chatId, String sendText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(sendText);
        return sendMessage;
    }

    private static InlineKeyboardMarkup getInlineKeyboardMarkup() {
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Ariza");
        inlineKeyboardButton1.setCallbackData("ariza");
        inlineKeyboardButton2.setText("Shikoyat");
        inlineKeyboardButton2.setCallbackData("shikoyat");
        inlineKeyboardButton3.setText("Taklif");
        inlineKeyboardButton3.setCallbackData("taklif");
        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        inlineKeyboardButtonList.add(inlineKeyboardButton3);
        lists.add(inlineKeyboardButtonList);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(lists);
        return inlineKeyboardMarkup;
    }


}
