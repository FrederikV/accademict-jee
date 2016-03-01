package com.realdolmen.tickets.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
@Embeddable
public class EmployeeId implements Serializable {
    private String ssn;
    private String lastName;

    public EmployeeId() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeId)) return false;

        EmployeeId that = (EmployeeId) o;

        if (!lastName.equals(that.lastName)) return false;
        if (!ssn.equals(that.ssn)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
