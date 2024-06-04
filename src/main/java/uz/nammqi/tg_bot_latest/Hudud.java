package uz.nammqi.tg_bot_latest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.nammqi.tg_bot_latest.entity.Regions;
import uz.nammqi.tg_bot_latest.repository.RegionRepository;
import uz.nammqi.tg_bot_latest.service.DBConnect;

import java.util.ArrayList;
import java.util.List;

@Component
public class Hudud {
    @Autowired
    RegionRepository regionRepository;

    DBConnect dbConnect=new DBConnect();

    public InlineKeyboardMarkup getInlineHududTanlash() {
        DBConnect dbConnect=new DBConnect();
//        List<Regions> allRegions = regionRepository.findAll();
        List<String> allRegions =dbConnect.getRegions();
        ArrayList<List<InlineKeyboardButton>> listsss = new ArrayList<>();
        int temp=0;
        for (int i = 0; i <allRegions.size()/2; i++) {
            List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String region = allRegions.get(temp+j);
                if (region==null)
                    break;
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                inlineKeyboardButton.setText(region);
                inlineKeyboardButton.setCallbackData(region);
                inlineKeyboardButtonList.add(inlineKeyboardButton);
            }
            temp=temp+2;
            listsss.add(inlineKeyboardButtonList);
        }


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(listsss);


        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineTumanTanlash(String region) {

//        List<Regions> allRegions = regionRepository.findAll();
        List<String> allDistricts =dbConnect.getDistricts(region);
        ArrayList<List<InlineKeyboardButton>> listss = new ArrayList<>();
        int temp=0;
        boolean isBreak=false;
        for (int i = 0; i <allDistricts.size()/2+1; i++) {
            List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                if ((temp+j)== allDistricts.size()){
                    isBreak=true;
                    break;
                }
                String district = allDistricts.get(temp+j);

                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                inlineKeyboardButton.setText(district);
                inlineKeyboardButton.setCallbackData(district);
                inlineKeyboardButtonList.add(inlineKeyboardButton);
            }
            listss.add(inlineKeyboardButtonList);
            if (isBreak) break;
            temp=temp+2;
        }


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(listss);


        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineSelectVillage(String district) {

        List<String> allVillages =dbConnect.getVillages(district);
        ArrayList<List<InlineKeyboardButton>> listssV = new ArrayList<>();
        int temp=0;
        boolean isBreak=false;
        for (int i = 0; i <allVillages.size()/2+1; i++) {
            List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                if ((temp+j)== allVillages.size()){
                    isBreak=true;
                    break;
                }
                String village = allVillages.get(temp+j);

                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                inlineKeyboardButton.setText(village);
                inlineKeyboardButton.setCallbackData(village);
                inlineKeyboardButtonList.add(inlineKeyboardButton);
            }
            listssV.add(inlineKeyboardButtonList);
            if (isBreak) break;
            temp=temp+2;
        }


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(listssV);


        return inlineKeyboardMarkup;
    }


}
