package com.glaucus.IncrementNumber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is the 'Number' entity which stores the number.
 *
 * @author Vipul Kumar Singh
 * @version 1.0
 * @since 2020-11-09
 */
@Entity
public class Number {

    @Id
    private Integer id;

    private Integer number;

    /**
     * Getter of id.
     *
     * @return Value of id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter of id.
     *
     * @param id Value of id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter of number.
     *
     * @return Value of number.
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Setter of number.
     *
     * @param number Value of number.
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}
