package org.example.TaskList2;

import org.example.TaskList2.MountainHare;
import java.util.List;
import java.awt.*;

public class Forest {
    private List<MountainHare> hares;
    private String season;

    public Forest(List<MountainHare> hares) {
        this.hares = hares;
        this.season = "лето";
    }

    // объявите недостающие переменные и добавьте конструктор

    public void setSeason(String newSeason){
        this.season = newSeason;

        if("зима".equals(newSeason)){
            for (MountainHare hare : hares){
                hare.color = "белый";
            }
        }else if("лето".equals(newSeason)){
            for (MountainHare hare : hares){
                hare.color = "серо-рыжий";
            }
        }
    }// добавьте метод setSeason(String newSeason)
    // в этом методе реализуйте логику смены цвета шубок зайцев-беляков
    // добавьте метод printHares()
    public void printHares(){
        for (MountainHare hare : hares){
            System.out.println(hare);
        }

    }

}


