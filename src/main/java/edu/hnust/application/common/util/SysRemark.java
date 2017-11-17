package edu.hnust.application.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 系统日志工具类
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SysRemark {
    public static String startFix = "【";
    
    public static String endFix = "】";
    
    public static String newLine = "<br/>";
    
    static private String _fix(String remark) {
        return startFix + remark + endFix;
    }
    
    static public String append(String existsRemark, String newRemark) {
        int rows = StringUtils.countMatches(existsRemark, startFix);
        String newIndex = new Integer(rows + 1).toString() + ": ";
        if (null == existsRemark || existsRemark.isEmpty()) {
            existsRemark = "";
        } else {
            existsRemark += newLine;
        }
        
        return existsRemark + newIndex + _fix(newRemark);
    }
}