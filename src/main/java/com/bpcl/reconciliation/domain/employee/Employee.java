package com.bpcl.reconciliation.domain.employee;

import java.time.LocalDate;

import com.bpcl.reconciliation.domain.organization.Organization;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "employee",
        schema = "reconciliation"
)
public class Employee extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "organization_id",
            nullable = false
    )
    private Organization organization;

    @Column(
            name = "employee_code",
            nullable = false,
            length = 30
    )
    private String employeeCode;

    @Column(
            name = "employee_name",
            nullable = false,
            length = 150
    )
    private String employeeName;

    @Column(
            name = "mobile_number",
            length = 30
    )
    private String mobileNumber;

    @Column(
            name = "email_address",
            length = 150
    )
    private String emailAddress;

    @Column(
            name = "aadhaar_number",
            length = 20
    )
    private String aadhaarNumber;

    @Column(
            name = "address_line_1",
            length = 200
    )
    private String addressLine1;

    @Column(
            name = "address_line_2",
            length = 200
    )
    private String addressLine2;

    @Column(
            name = "city",
            length = 100
    )
    private String city;

    @Column(
            name = "state",
            length = 100
    )
    private String state;

    @Column(
            name = "postal_code",
            length = 20
    )
    private String postalCode;

    @Column(
            name = "photograph_storage_path",
            length = 1000
    )
    private String photographStoragePath;

    @Column(
            name = "date_of_joining",
            nullable = false
    )
    private LocalDate dateOfJoining;

    @Column(
            name = "date_of_leaving"
    )
    private LocalDate dateOfLeaving;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "employment_status",
            nullable = false,
            length = 20
    )
    private EmploymentStatus employmentStatus = EmploymentStatus.ACTIVE;

    protected Employee() {
    }

    public Employee(
            Organization organization,
            String employeeCode,
            String employeeName,
            LocalDate dateOfJoining) {

        this.organization = organization;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.dateOfJoining = dateOfJoining;
        this.employmentStatus = EmploymentStatus.ACTIVE;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhotographStoragePath() {
        return photographStoragePath;
    }

    public void setPhotographStoragePath(
            String photographStoragePath) {

        this.photographStoragePath = photographStoragePath;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public LocalDate getDateOfLeaving() {
        return dateOfLeaving;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void activate() {
        this.employmentStatus = EmploymentStatus.ACTIVE;
        this.dateOfLeaving = null;
    }

    public void deactivate() {
        this.employmentStatus = EmploymentStatus.INACTIVE;
    }

    public void markAsLeft(LocalDate dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
        this.employmentStatus = EmploymentStatus.LEFT;
    }
}