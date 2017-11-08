package edu.hnust.libraries.page.select;

import java.util.HashMap;
import java.util.Map;

import edu.hnust.util.MyLocale;

public class YesNo {
    
    public Map<String, String> getOptions() {
        MyLocale myLocale = new MyLocale();
        Map<String, String> options = new HashMap<String, String>();
        for (edu.hnust.libraries.constentEnum.YesNo yesNo : edu.hnust.libraries.constentEnum.YesNo.values()) {
            options.put(String.valueOf(yesNo.getYesOrNo()), myLocale.getText(yesNo.toString()));
        }
        return options;
    }    
}
