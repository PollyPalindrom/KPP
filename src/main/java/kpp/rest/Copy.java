package kpp.rest;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
public class Copy {
    private String content1;
    private String content2;
    private String content3;
    public Copy() {
        this.content1 = "";
        this.content2 = "";
        this.content3 = "";
    }

    public Copy(String cont1, String cont2) {
        this.content1 = cont1;
        this.content2 = cont2;
        this.content3 = "";
    }

    public Copy(String cont1, String cont2, String cont3) {
        this.content1 = cont1;
        this.content2 = cont2;
        this.content3 = cont3;
    }

    public void setContent1(String name) {
        this.content1 = name;
    }

    public void setContent2(String name) {
        this.content2 = name;
    }

    public void setContent3(String name) {
        this.content3 = name;
    }

    public void copy1() {
        this.content2 = this.content1;
    }

    public void copy2() {
        this.content3 = this.content2;
    }

    public String getContent1() {
        return content1;
    }

    public String getContent2() {
        return content2;
    }

    public String getContent3() {
        return content3;
    }

    public boolean equals(Copy copy) {
        if (copy == null)
            return false;
        return this.content1.equals(copy.content1) && this.content2.equals(copy.content2) && this.content3.equals(copy.content3);
    }

    public void makeEqual(Copy copy) {
        this.setContent1(copy.getContent1());
        this.setContent2(copy.getContent2());
        this.setContent3(copy.getContent3());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id=1;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

