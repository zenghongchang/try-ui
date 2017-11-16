package edu.hnust.application.common.util;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (null == ip) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }
    
    public static List<String> getRealIP() {
        ArrayList<String> ipsList = new ArrayList<String>();
        try {
            Enumeration<?> ex = NetworkInterface.getNetworkInterfaces();
            while (true) {
                NetworkInterface item;
                do {
                    do {
                        do {
                            if (!ex.hasMoreElements()) {
                                return ipsList;
                            }
                            item = (NetworkInterface)ex.nextElement();
                        } while (item.isVirtual());
                    } while (!item.isUp());
                } while (item.isLoopback());                
                Iterator<?> arg2 = item.getInterfaceAddresses().iterator();                
                while (arg2.hasNext()) {
                    InterfaceAddress address = (InterfaceAddress)arg2.next();
                    if (address.getAddress() instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address)address.getAddress();
                        System.out.println(inet4Address.getHostAddress());
                        ipsList.add(inet4Address.getHostAddress());
                    }
                }
            }
        } catch (IOException arg5) {
            return ipsList;
        }
    }
}