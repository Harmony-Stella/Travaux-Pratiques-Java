package TP3;

import java.util.*;

public class HTMLLogFormatter implements LogFormatter {
    @Override
    public void logObject(Object object) {
        System.out.println("<p>" + object.toString() + "</p>");
    }

    @Override
    public void logCollection(Collection<?> collection) {
        System.out.println("<ul>");
        for (Object obj : collection) {
            System.out.println("<li>" + obj.toString() + "</li>");
        }
        System.out.println("</ul>");
    }    
    
    @Override
    public void logMap(Map<?, ?> map) {
        System.out.println("<ul>");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println("<li>" + entry.getKey().toString() + " - " + entry.getValue().toString() + "</li>");
        }
        System.out.println("</ul>");
    }

}
