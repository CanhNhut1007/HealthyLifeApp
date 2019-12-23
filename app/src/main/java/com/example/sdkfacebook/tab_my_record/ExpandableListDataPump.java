package com.example.sdkfacebook.tab_my_record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> About = new ArrayList<String>();
        About.add("Name");
        About.add("Birthday");
        About.add("Sex");

        List<String> Contract = new ArrayList<String >();
        Contract.add("Email");
        Contract.add("Phone Number");
        Contract.add("Address");

        expandableListDetail.put("About", About);
        expandableListDetail.put("Contract Information", Contract);
        return expandableListDetail;

    }
}
