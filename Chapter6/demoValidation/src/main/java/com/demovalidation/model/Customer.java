package com.demovalidation.model;

import com.demovalidation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;


    private String firstName;


    @NotNull(message = "is required")
    @Min(value = 0, message = "The fee must be greater than or equal to zero")
    @Max(value = 10, message = "The fee must be less than or equal to 10")
    private Integer feeGas;


    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "This is only 5 chars/digits")
    private String postalCode;


    @CourseCode(value = "SANG", message = "This must be start with SANG")
    private String courseCode;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFeeGas() {
        return feeGas;
    }

    public void setFeeGas(Integer feeGas) {
        this.feeGas = feeGas;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
