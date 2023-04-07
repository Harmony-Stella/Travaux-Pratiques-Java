package TP3;

import java.util.*;

public class TextLogFormatter implements LogFormatter{
    @Override
    public void logObject(Object object) {
        System.out.println(object.toString());
    }

    @Override
    public void logCollection(Collection<?> collection) {
        for (Object obj : collection) {
            System.out.println(obj.toString());
        }
    }

    @Override
    public void logMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue().toString());
        }
    }

}
