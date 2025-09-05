package in.bm.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id

    @Column(name = "Id", nullable = false,unique = true, length =4)

    private long studentId;

    @Column(name = "Name", nullable = false)
    private String firstName;

    @Column(name = "Surname", nullable = false)
    private String secondName;

    @Column(name = "Mother", nullable = false)
    private String motherName;

    @Column(name="Father",nullable = false)
    private String fatherName;

    @Column(nullable = false, length = 1)
    private String sex;

    @Embedded
    private Birth birthdate;

    @Embedded
    private Phone phone;

    @Embedded
    private Address address;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Birth getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Birth birthdate) {
        this.birthdate = birthdate;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
