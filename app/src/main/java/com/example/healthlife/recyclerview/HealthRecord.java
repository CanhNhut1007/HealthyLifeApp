package com.example.healthlife.recyclerview;

public class HealthRecord {
    private String healthrecord_id;
    private String employee_id;
    private String date;
    private int image_view;

    public HealthRecord (String healthrecordid, String employeeid, String Date, int image)
    {
        this.healthrecord_id =healthrecordid;
        this.employee_id = employeeid;
        this.date = Date;
        this.image_view = image;
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
