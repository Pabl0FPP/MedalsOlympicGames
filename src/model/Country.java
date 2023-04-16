package model;

import exceptions.IncorrectInputException;

public class Country implements Comparable<Country>{

    private String name;
    private int goldM;
    private int silverM;
    private int bronzeM;

    public Country(String name, int goldM, int silverM, int bronzeM)throws IncorrectInputException {
        this.name = name;
        this.goldM = goldM;
        this.silverM = silverM;
        this.bronzeM = bronzeM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoldM() {
        return goldM;
    }

    public void setGoldM(int goldM) {
        this.goldM = goldM;
    }

    public int getSilverM() {
        return silverM;
    }

    public void setSilverM(int silverM) {
        this.silverM = silverM;
    }

    public int getBronzeM() {
        return bronzeM;
    }

    public void setBronzeM(int bronzeM) {
        this.bronzeM = bronzeM;
    }

    public int getTotalMedals(){

        return getGoldM()+getSilverM()+getBronzeM();
    }

    @Override
    public int compareTo(Country o) {
        int criteria1= o.goldM-this.goldM;
        int criteria2=o.silverM-this.silverM;
        int criteria3=o.bronzeM-this.bronzeM;
        int criteria4=this.name.compareTo(o.name);

        if(criteria1==0) {
            if (criteria2 == 0) {
                if (criteria3 == 0) {
                    return criteria4;
                } else return criteria3;
            } else return criteria2;
        }else return criteria1;
    }





}
