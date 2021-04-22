package com.minty.demo;


import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Cache {
    private final HashMap<CopyKey, Copy> hashMap = new HashMap<>();

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
