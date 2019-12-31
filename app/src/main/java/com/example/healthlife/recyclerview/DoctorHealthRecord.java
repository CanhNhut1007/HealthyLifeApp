package com.example.healthlife.recyclerview;


public class DoctorHealthRecord {
    private String accountemployee_id;
    private String accountpatient_id;
    private String healthrecord_id;
    private String employee_id;
    private String date;
    private int image_view;

    public DoctorHealthRecord (String accountemployeeid, String accountpatientid, String healthrecordid, String employeeid, String Date, int image)
    {
        this.accountemployee_id = accountemployeeid;
        this.accountpatient_id = accountpatientid;
        this.healthrecord_id =healthrecordid;
        this.employee_id = employeeid;
        this.date = Date;
        this.image_view = image;
    }

    public String getAccountEmployeeID()
    {
        return accountemployee_id;
    }

    public void setAccountEmployeeID(String accountemployeeid)
    {
        accountemployee_id = accountemployeeid;
    }

    public String getAccountPatientID()
    {
        return accountpatient_id;
    }

    public void setAccountPatientID(String accountpatientid)
    {
        accountpatient_id = accountpatientid;
    }

    public String getHealthRecordID()
    {
        return healthrecord_id;
    }

    public void setHealthRecordID(String healthrecordid)
    {
        healthrecord_id = healthrecordid;
    }

    public int getImageView()
    {
        return image_view;
    }

    public void setImageView( int image)
    {
        image_view = image;
    }

    public String getEmployeeID()
    {
        return employee_id;
    }

    public void setEmployeeID( String employeeid)
    {
        employee_id = employeeid;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate( String Date)
    {
        date = Date;
    }

}
