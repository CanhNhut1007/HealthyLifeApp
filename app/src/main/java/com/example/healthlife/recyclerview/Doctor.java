package com.example.healthlife.recyclerview;

public class Doctor {
    private String account_id;
    private String employee_name;
    private String speciality;
    private String employee_id;
    private int image_view;

    public Doctor (String accountid, String name, String Speciality, String employeeid, int image)
    {
        this.account_id = accountid;
        this.employee_name = name;
        this.speciality = Speciality;
        this.employee_id = employeeid;
        this.image_view = image;
    }

    public String getAccountID()
    {
        return account_id;
    }

    public void setAccountID(String accountid)
    {
        account_id = accountid;
    }

    public int getImageView()
    {
        return image_view;
    }

    public void setImageView( int image)
    {
        image_view = image;
    }

    public String getEmployeeName()
    {
        return employee_name;
    }

    public void setPatientName( String name)
    {
        employee_name = name;
    }

    public String getSpeciality()
    {
        return speciality;
    }

    public void setSpeciality( String Speciality)
    {
        speciality = Speciality;
    }

    public String getEmployeeID()
    {
        return employee_id;
    }

    public void setPatientID( String employeeid)
    {
        employee_id = employeeid;
    }
}
