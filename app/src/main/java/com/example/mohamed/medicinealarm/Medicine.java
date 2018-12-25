package com.example.mohamed.medicinealarm;


public class Medicine {

    String med_name;
    int hour;
    int minute;
    int id;

    public Medicine() {

    }

    public Medicine(int id,String med_name, int hour, int minute) {
        this.id=id;
        this.med_name = med_name;
        this.hour = hour;
        this.minute = minute;
    }

    @Override

        public String toString() {
            return "Medicine Name "+med_name + "\t" +"At "+hour+"H " + "\t" + minute+"M";
        }


    public String getMed_name() {
        return med_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}



