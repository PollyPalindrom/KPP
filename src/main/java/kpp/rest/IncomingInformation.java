package kpp.rest;

public class IncomingInformation {
    private String content1;
    private Integer content2;
    public IncomingInformation() {
        this.content1="";
        this.content2=0;
    }
    public IncomingInformation(String cont1,Integer cont2) {
        this.content1=cont1;
        this.content2=cont2;
    }
    public void setContent1(String name){
        this.content1=name;
    }
    public void setContent2(Integer button){
        this.content2=button;
    }
    public String getContent1() {
        return content1;
    }
    public Integer getContent2() {
        return content2;
    }
    public boolean equals(IncomingInformation inc)
    {
        if (inc == null)
            return false;
        return this.content1.equals(inc.content1) && this.content2.equals(inc.content2);
    }
    public void makeEqual(IncomingInformation inc){
        this.setContent1(inc.getContent1());
        this.setContent2(inc.getContent2());
    }
}

