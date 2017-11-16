/*
 * Copyright © 2004-2012 Tomtop Inc. All Rights Reserved.  
 *
 * This software is the confidential and proprietary information of 
 * Shenzhen Tomtop Technology Co., Ltd. 
 * No body can copy or modify any part of this source without the permission of 
 * Shenzhen Tomtop Technology Co., Ltd. 
 *  __ __                                 _   __ __                   [`---- `.
 * [     ]   .- -- -.    [` `\         /` `] [     ]     .- -- -.     |       \
 * `-. .-'  /        \   |    \       /    | `-. .-'   /         \    |       |
 *   | |   |          |  |     \     /     |   | |    |           |   |   _._ /
 *   | |   |          |  |      \_._/      |   | |    |           |   |   |
 *   | |    \         /  |                 |   | |     \         /    |   |
 *   | |     `._  _.'    |_/             \_|   | |      `._  _.'      |._.`
 *   `'`                                       `'`
 *
 */
package edu.hnust.application.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * @version 1.00 Nov 15, 2011
 * @author Software Team Of Tomtop Technology Co., Ltd
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
