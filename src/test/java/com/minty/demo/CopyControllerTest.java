package com.minty.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CopyControllerTest {

    InteriorLogic logic = new InteriorLogic();

    @Test
    public void testCopyReturnsCorrectValueFirstButton() {
        Copy temp = new Copy();
        temp = logic.returnNewValue("polly", 1, new Copy());
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("polly", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
    }

    @Test
    public void testCopyReturnsCorrectValueSecondButton() {
        Copy temp = new Copy();
        temp = logic.returnNewValue("polly", 2, new Copy());
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
    }

    @Test
    public void testCopyReturnsCorrectValueFirstSecondButton() {
        Copy temp = new Copy();
        temp = logic.returnNewValue("polly", 1, temp);
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("polly", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
        temp = logic.returnNewValue("polly", 2, temp);
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("polly", temp.getContent2());
        Assertions.assertEquals("polly", temp.getContent3());
    }

    @Test
    public void testCopyReturnsCorrectValueAnotherValue() {
        Copy temp = new Copy();
        temp = logic.returnNewValue("polly", 1, temp);
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("polly", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
        temp = logic.returnNewValue("minty", 2, temp);
        Assertions.assertEquals("minty", temp.getContent1());
        Assertions.assertEquals("", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
    }

    @Test
    public void testCopyReturnsCorrectValueFromCache() {
        Copy temp = new Copy();
        temp = logic.returnNewValue("polly", 1, temp);
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("polly", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
        temp = logic.returnNewValue("minty", 2, temp);
        Assertions.assertEquals("minty", temp.getContent1());
        Assertions.assertEquals("", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
        temp = logic.returnNewValue("polly", 1, temp);
        Assertions.assertEquals("polly", temp.getContent1());
        Assertions.assertEquals("polly", temp.getContent2());
        Assertions.assertEquals("", temp.getContent3());
    }

    @Test
    public void testCacheGet() {
        Cache cache = new Cache();
        Assertions.assertEquals(null, cache.get(null));
    }

    @Test
    public void testCopyControllerError() throws InvalidInputException {
        boolean result = false;
        try {
            CopyController copyController = new CopyController();
            copyController.copy("minty", 4);
        } catch (InvalidInputException e) {
            result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    public void testCopyController() throws InvalidInputException {
        boolean result = false;
        try {
            CopyController copyController = new CopyController();
            copyController.copy("minty", 1);
        } catch (InvalidInputException e) {
            result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    public void testCopyEquals() {
        Copy copy = new Copy();
        Assertions.assertEquals(false, copy.equals(null));
    }
}