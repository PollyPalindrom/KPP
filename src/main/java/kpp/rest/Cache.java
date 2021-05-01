package kpp.rest;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class Cache {
    private final ConcurrentHashMap<CopyKey, Copy> hashMap = new ConcurrentHashMap<>();

    public synchronized boolean IsContains(CopyKey key) {
        boolean result = false;
        for (CopyKey copyKey : hashMap.keySet()) {
            if (copyKey.equals(key))
                result = true;
        }
        return result;
    }

    public synchronized void add(CopyKey key, Copy content) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, content);
        }
    }

    public synchronized Copy get(CopyKey key) {
        for (CopyKey copyKey : hashMap.keySet()) {
            if (copyKey.equals(key)) {
                return hashMap.get(copyKey);
            }
        }
        return null;
    }
}

