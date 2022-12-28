package com.constant;

public enum PROFESSION {
    General("General"),Student("Student");
    String profession;

    private PROFESSION(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return this.profession;
    }
}
