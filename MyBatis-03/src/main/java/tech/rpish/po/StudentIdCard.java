package tech.rpish.po;

public class StudentIdCard {
    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    private Integer id;
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
