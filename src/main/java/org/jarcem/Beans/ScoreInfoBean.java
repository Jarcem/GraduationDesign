package org.jarcem.Beans;

import java.math.BigDecimal;

public class ScoreInfoBean {
    private Integer sco_id;
    private String stu_id;
    private Integer cla_id;
    private BigDecimal score;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSco_id() {
        return sco_id;
    }

    public void setSco_id(Integer sco_id) {
        this.sco_id = sco_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public Integer getCla_id() {
        return cla_id;
    }

    public void setCla_id(Integer cla_id) {
        this.cla_id = cla_id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
