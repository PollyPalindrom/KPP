package kpp.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

//heeeeej
@RestController// все методы класса возвращают именно те данные, которые надо переслать клиенту
public class CopyController {
    private static Logger logger = LogManager.getLogger(CopyController.class);
    Copy temp1 = new Copy();
    @Autowired
    InteriorLogic logic;

    @GetMapping(value = "/")
    public Copy copy(@RequestParam(value = "name", defaultValue = " ") String name, @RequestParam(value = "copyButton", defaultValue = "0") Integer copyButton) {
        if (copyButton == 1 || copyButton == 2) {
            return logic.returnNewValue(name, copyButton, temp1,0);
        } else {
            logger.warn("Error corrupted. Wrong input");
            throw new InvalidInputException();
        }
    }

    @PostMapping(value = "/bulk")
    public ResponseEntity<?> BulkCopy(@RequestBody List<Copy> incList) {
        List<IncomingInformation> copyList = new LinkedList<>();
        List<String> resultList = new LinkedList<>();
        for (Copy tmp : incList) {
            try {
                copyList.add(new IncomingInformation(tmp.getContent1(), Integer.parseInt(tmp.getContent2())));
            } catch (Exception e) {
                return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
            }

        }
        copyList.forEach((tmp) -> {
            logic.returnNewValue(tmp.getContent1(), tmp.getContent2(), temp1,0);
            resultList.add("\ncontent1:"+temp1.getContent1());
            resultList.add("content2:"+temp1.getContent2());
            resultList.add("content3:"+temp1.getContent3());
        });
        long counter1 = copyList
                .stream()
                .filter(p -> p.getContent2() == 1)
                .mapToInt(IncomingInformation::getContent2)
                .count();
        long counter2 = copyList
                .stream()
                .filter(p -> p.getContent2() == 2)
                .mapToInt(IncomingInformation::getContent2)
                .count();
        return new ResponseEntity<>(resultList+ "\n"+counter1 +" раз нажали первую клавишу\n"+ counter2+" раз нажали вторую клавишу", HttpStatus.OK);
    }
    @GetMapping(value = "/add")
    public Copy addCopyToBD(@RequestParam(value = "name", defaultValue = " ") String name, @RequestParam(value = "copyButton", defaultValue = "0") Integer copyButton) {
        if (copyButton == 1 || copyButton == 2) {
            return logic.returnNewValue(name, copyButton, temp1, 1);
        } else {
            logger.warn("Error corrupted. Wrong input");
            throw new InvalidInputException();
        }
    }
}
