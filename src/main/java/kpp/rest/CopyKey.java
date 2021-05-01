package kpp.rest;

public class CopyKey {
    public Copy prevCopy;
    public String name;
    public Integer buttonValue;

    public void setPrevCopy(Copy prevCopy) {
        this.prevCopy = prevCopy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setButtonValue(Integer button) {
        this.buttonValue = button;
    }

    public Copy getPrevCopy() {
        return prevCopy;
    }

    public String getName() {
        return name;
    }

    public Integer getButtonValue() {
        return buttonValue;
    }

    public boolean equals(CopyKey key) {
        if (key == null)
            return false;
        return this.name.equals(key.name) && this.buttonValue == key.buttonValue && prevCopy.equals(key.prevCopy);
    }
    public void makeEqual(CopyKey copyKey){
        this.setPrevCopy(copyKey.getPrevCopy());
        this.setName(copyKey.getName());
        this.setButtonValue(copyKey.getButtonValue());
    }
}

