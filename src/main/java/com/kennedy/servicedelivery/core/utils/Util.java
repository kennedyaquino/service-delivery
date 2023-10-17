package com.kennedy.servicedelivery.core.utils;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static String convertDataCoordinatesCoverageAreaAsString(List<List<List<List<Double>>>> coordinates) {

        List<List<Double>> listDataCoordinates = coordinates.get(0).get(0);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < listDataCoordinates.size(); i++) {
            for (int j = 0; j < listDataCoordinates.get(i).size(); j++) {
                stringBuilder.append(listDataCoordinates.get(i).get(j));
                if (j != (coordinates.get(i).size() - 1)) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(";");
        }

        return stringBuilder.toString();
    }

    public static String convertDataCoordinatesAddressAsString(List<Double> coordinates) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < coordinates.size(); i++) {
            stringBuilder.append(coordinates.get(i));
            if (i != (coordinates.size() - 1)) {
                stringBuilder.append(";");
            }
        }

        return stringBuilder.toString();
    }

    public static List<List<List<List<Double>>>> convertDataCoordinatesCoverageAreaStringAsDouble(String coordinatesString) {
        String[] a = coordinatesString.split(";");
        List<Double> coordinates = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            String[] b = a[i].split(",");
            for (int j = 0; j < b.length; j++) {
                coordinates.add(Double.parseDouble(b[j]));
            }
        }

        return List.of(List.of(List.of(coordinates)));
    }

    public static List<Double> convertDataCoordinatesAddressStringAsDouble(String addressString) {
        String[] a = addressString.split(";");
        List<Double> coordinates = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            coordinates.add(Double.parseDouble(a[i]));
        }

        return coordinates;
    }
}
