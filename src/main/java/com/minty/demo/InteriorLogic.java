package com.minty.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InteriorLogic {
    @Autowired
    private Cache cache = new Cache();
    private static Logger logger = LogManager.getLogger(CopyController.class);
    static CopyCounter copyCounter = new CopyCounter();
    public Copy returnNewValue(String name, Integer button, Copy temp) {
        logger.info("Successfully get params");
        CopyKey key = new CopyKey();
        key.setButtonValue(button);
        key.setPrevCopy(temp);
        key.setName(name);
        if (copyCounter.isRunnable()) {
            copyCounter.incrementCounter();
        } else {
            copyCounter.start();
            copyCounter.incrementCounter();
        }
        if (cache.IsContains(key)) {
            logger.info("we have this situation in map");
            return cache.get(key);
        } else {
            logger.info("new situation");
            if (!name.contains(temp.getContent1())) {
                temp.setContent1(name);
                temp.setContent2("");
                temp.setContent3("");
            }
            if (name != " ") {
                temp.setContent1(name);
                if (button == 1) {
                    temp.copy1();
                }
                if (button == 2) {
                    temp.copy2();
                }
            }
            Copy temp2 = new Copy();
            temp2.makeEqual(temp);
            cache.add(key, temp2);
            return temp;
        }
    }
}
