package TP3;

import java.util.*;

public interface LogFormatter {
    public void logObject(Object object);
    public void logCollection(Collection<?> collection);
    public void logMap(Map<?, ?> map);

}
