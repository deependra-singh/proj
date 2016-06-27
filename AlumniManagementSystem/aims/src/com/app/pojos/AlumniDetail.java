package com.app.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the alumni_details database table.
 *
 */
@Entity
@Table(name = "alumni_details")
public class AlumniDetail extends UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "alumni_email", unique = true)
    private String alumniEmail;
    @Column(name = "alumni_course")
    private String alumniCourse;
    @Column(name = "alumni_roll")
    private String alumniRoll;
    @Temporal(TemporalType.DATE)
    @Column(name = "year_of_joining")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date yearOfJoining;
    @Temporal(TemporalType.DATE)
    @Column(name = "year_of_passing")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date yearOfPassing;

    @Override
    public String toString() {
        return "AlumniDetail [  alumniEmail=" + alumniEmail + ", alumniCourse=" + alumniCourse
                + ", alumniRoll=" + alumniRoll + ", yearOfJoining=" + yearOfJoining + ", yearOfPassing=" + yearOfPassing
                + "]";
    }

    public AlumniDetail() {
    }

    public String getAlumniCourse() {
        return this.alumniCourse;
    }

    public void setAlumniCourse(String alumniCourse) {
        this.alumniCourse = alumniCourse;
    }

    public String getAlumniRoll() {
        return this.alumniRoll;
    }

    public void setAlumniRoll(String alumniRoll) {
        this.alumniRoll = alumniRoll;
    }

    public Date getYearOfJoining() {
        return this.yearOfJoining;
    }

    public void setYearOfJoining(Date yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public Date getYearOfPassing() {
        return this.yearOfPassing;
    }

    public void setYearOfPassing(Date yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getAlumniEmail() {
        return alumniEmail;
    }

    public void setAlumniEmail(String alumniEmail) {
        this.alumniEmail = alumniEmail;
    }
}