package com.backtobasics.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 
 * Just a bunch of classes which Gemini generated for me to try our Stream API.
 * 
 */
public class StreamReferenceClasses {

}

/* Level 1 - Easy */
class Usr {
    private String uname;
    private List<String> uEmails;

    public Usr(String uname, String... uEmails) {
        this.uname = uname;
        this.uEmails = Arrays.asList(uEmails);
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<String> getuEmails() {
        return uEmails;
    }

    public void setuEmails(List<String> uEmails) {
        this.uEmails = uEmails;
    }

}
/* Level 1 - Easy | END */

/* Level 2 - Medium Problem */
class Order {
    private String orderId;
    private List<LineItem> lineItems;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}

class LineItem {
    private String productName;
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
/* Level 2 - Medium Problem | END */

/* Level 3 - Hard Problem */
class Department {
    private String name;
    private List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

class Course {
    private String courseCode;
    private boolean active;
    private List<Student> enrolledStudents;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/* Level 4- Hard with Optional */
class Employee {
    private String name;
    private Profile profile; // profile can be null!

    public Employee(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    // Returns Optional.empty() if profile is null
    public Optional<Profile> getProfile() {
        return Optional.ofNullable(profile);
    }
}

class Profile {
    private String bio; // bio can be null or empty!

    public Profile(String bio) {
        this.bio = bio;
    }

    // Returns Optional.empty() if bio is null or empty
    public Optional<String> getBio() {
        return (bio == null || bio.isEmpty()) ? Optional.empty() : Optional.of(bio);
    }

}