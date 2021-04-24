package com.minty.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

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

    @PostMapping(value = "/")
    public ResponseEntity<?> BulkCopy(@RequestBody List<Copy> incList) {
        List<IncomingInformation> copyList = new LinkedList<>();
        for (Copy tmp : incList) {
            try {
                copyList.add(new IncomingInformation(tmp.getContent1(), Integer.parseInt(tmp.getContent2())));
            } catch (Exception e) {
                return new ResponseEntity<>("400 error", HttpStatus.BAD_REQUEST);
            }

        }

        copyList.forEach((tmp) -> {
            logic.returnNewValue(tmp.getContent1(), tmp.getContent2(), temp1);
        });
//        List<Vector> vectorList = vectorBodyList.stream()
//                .map((body) -> new Vector(body.getX1(), body.getY1(), body.getX2(), body.getY2()))
//                .collect(Collectors.toList());
//        AverageValues values = new AverageValues(VectorService.INSTANCE.calcAverageX1(vectorList), VectorService.INSTANCE.calcAverageX2(vectorList),
//                VectorService.INSTANCE.calcAverageY1(vectorList), VectorService.INSTANCE.calcAverageY2(vectorList),
//                VectorService.INSTANCE.calcAverageNorma(vectorList), VectorService.INSTANCE.calcAverageProjectionX(vectorList),
//                VectorService.INSTANCE.calcAverageProjectionY(vectorList));
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}