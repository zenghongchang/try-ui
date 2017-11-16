package edu.hnust.application.libraries.page.select;

import java.util.HashMap;
import java.util.Map;

import edu.hnust.application.common.util.MyLocale;

public class YesNo {
    
    public Map<String, String> getOptions() {
        MyLocale myLocale = new MyLocale();
        Map<String, String> options = new HashMap<String, String>();
        for (edu.hnust.application.libraries.constentEnum.YesNo yesNo : edu.hnust.application.libraries.constentEnum.YesNo.values()) {
            options.put(String.valueOf(yesNo.getYesOrNo()), myLocale.getText(yesNo.toString()));
        }
        return options;
    }
}
