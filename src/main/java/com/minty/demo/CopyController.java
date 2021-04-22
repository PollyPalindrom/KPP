package com.minty.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController// все методы класса возвращают именно те данные, которые надо переслать клиенту
public class CopyController {
    @Autowired
    private static Logger logger = LogManager.getLogger(CopyController.class);
    Copy temp1 = new Copy();
    InteriorLogic logic = new InteriorLogic();

    @GetMapping(value = "/")
    public Copy copy(@RequestParam(value = "name", defaultValue = " ") String name, @RequestParam(value = "copyButton", defaultValue = "0") Integer copyButton) {
        if (copyButton == 1 || copyButton == 2) {
            return logic.returnNewValue(name, copyButton, temp1);
        } else {
            logger.warn("Error corrupted. Wrong input");
            throw new InvalidInputException();
        }
    }
}