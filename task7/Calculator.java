package org.example.task7;

import java.util.List;

public class Calculator {

    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        // Напишите реализацию метода, который будет возвращать общее количество дней,
        // потраченных на просмотр фильмов и сериалов
        double sum = 0;
        for (MediaItem item : mediaItems) {
            if (item instanceof Movie movie) {
                sum += movie.getRuntime();
            } else if (item instanceof Series serial) {
                sum += (serial.getRuntime() * serial.getSeriesCount());
            }
        }
        return sum / 1440;
    }
}