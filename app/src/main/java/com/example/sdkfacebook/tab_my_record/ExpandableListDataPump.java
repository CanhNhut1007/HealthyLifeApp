//package com.example.sdkfacebook.tab_my_record;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class ExpandableListDataPump {
//    public static HashMap<String, List<Info_class>> getData(){
//        HashMap<String, List<Info_class>> expandableListDetail;
//
//        final List<String> listHeader = new ArrayList<String>();
//        listHeader.add("About");
//        listHeader.add("Contact");
//        listHeader.add("Metrics");
//
//        expandableListDetail= new HashMap<>();
//        List<Info_class> listInfoAbout = new ArrayList<>();
//        listInfoAbout.add(new Info_class("Name","Quyen"));
//        listInfoAbout.add(new Info_class("Birthday","14/05"));
//        listInfoAbout.add(new Info_class("Sex","Female"));
//        listInfoAbout.add(new Info_class("Indentify card","1234"));
//
//        List<Info_class> listInfoContact = new ArrayList<>();
//        listInfoContact.add(new Info_class("Email","quyen@gmail.com"));
//        listInfoContact.add(new Info_class("Phone Number", "123456789"));
//        listInfoContact.add(new Info_class("Address", "UIT"));
//
//        List<Info_class> listInfoMetric = new ArrayList<>();
//        listInfoMetric.add(new Info_class("Height","160cm"));
//        listInfoMetric.add(new Info_class("Weight", "123456789"));
//        listInfoMetric.add(new Info_class("Address", "UIT"));
//        listInfoMetric.add(new Info_class("Height","160cm"));
//        listInfoMetric.add(new Info_class("Weight", "123456789"));
//        listInfoMetric.add(new Info_class("Address", "UIT"));
//
//        expandableListDetail.put(listHeader.get(0), listInfoAbout);
//        expandableListDetail.put(listHeader.get(1), listInfoContact);
//        expandableListDetail.put(listHeader.get(2), listInfoMetric);
//        return expandableListDetail;
//
//
//    }
//}
