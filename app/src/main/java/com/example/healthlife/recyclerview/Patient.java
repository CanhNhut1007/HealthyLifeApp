package com.example.healthlife.recyclerview;

public class Patient {
    private String accountemployee_id;
    private String account_id;
    private String patient_name;
    private String identify_card;
    private String patient_id;
    private int image_view;

    public Patient (String accountemployeeid, String accountid, String name, String identifycard, String patientid, int image)
    {
        this.accountemployee_id = accountemployeeid;
        this.account_id = accountid;
        this.patient_name = name;
        this.identify_card = identifycard;
        this.patient_id = patientid;
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

    public String getPatientName()
    {
        return patient_name;
    }

    public void setPatientName( String name)
    {
        patient_name = name;
    }

    public String getIdentifyCard()
    {
        return identify_card;
    }

    public void setIdentifyCard( String identifycard)
    {
        identify_card = identifycard;
    }

    public String getPatientID()
    {
        return patient_id;
    }

    public void setPatientID( String patientid)
    {
        patient_id = patientid;
    }
}

