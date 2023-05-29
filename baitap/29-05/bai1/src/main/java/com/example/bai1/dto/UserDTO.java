package com.example.bai1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class UserDTO implements Validator {
    private Integer id;
    @Size(min = 5, max = 45, message = "Tên không được quá 45 kí tự hoặc dưới 5 kí tự!")
    @NotBlank(message = "Tên không được để trống")
    private String firstName;
    @Size(min = 5, max = 45, message = "Tên không được quá 45 kí tự hoặc dưới 5 kí tự!")
    @NotBlank(message = "Tên không được để trống")
    private String lastName;
    @NotBlank(message = "Password không được để trống.")
    private String password;
    @NotBlank(message = "Số điện thoại ko được để trống")
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải có 10 số,bắt đầu bằng số 0")
    private String phoneNumber;
    @NotBlank(message = "Tuổi không được để trống.")
    private String age;
    @Email(message = "Phải đúng định dangj Email(*@gmail.com)")
    @NotBlank(message = "Email không được để trống.")
    private String email;

    public UserDTO() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO(String firstName, String lastName, String password, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDTO(Integer id, String firstName, String lastName, String password, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate age = LocalDate.parse(user.getAge(), formatter);
            LocalDate now = LocalDate.now();
            int yearOld = Period.between(age, now).getYears();
            if (yearOld < 18) {
                errors.rejectValue("age", "age", "Tuổi tối thiểu là 18 vui lòng kiểm tra lại");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("age", "age", "Định dạng ngày không hợp lệ, vui lòng kiểm tra lại");
        }
    }

}
