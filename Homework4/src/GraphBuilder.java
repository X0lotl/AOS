import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class GraphBuilder extends GraphicsProgram {
    public SortionMethodsTimeData[] sortionMethodsTimeData = IntArrayTest.getSortionMethodsTimeDataArray();

    public Color[] colorsOfLinesForSortionMethodsData = {
            Color.CYAN, Color.MAGENTA, Color.GREEN, Color.RED, Color.ORANGE, Color.WHITE, Color.BLUE
    };

    private void createNameOfArraysVariation() {
        String arrayVariationName = (String) IntArrayTest.getHashMapOfArrayVariations().keySet().toArray()[IntArrayTest.getIndexOfArraysVariation()];
        GLabel nameOfArraysVariation = new GLabel(arrayVariationName, 700, 100);
        nameOfArraysVariation.setColor(Color.BLACK);
        nameOfArraysVariation.setFont("SansSerif-20");
        add(nameOfArraysVariation);
    }

    private void createLabelForInfo(int index) {
        GLabel nameOfMethod = new GLabel(sortionMethodsTimeData[index].name, 10, 100 + (index + 1) * 30);
        nameOfMethod.setFont("SansSerif-20");
        add(nameOfMethod);
    }

    private void createSquareForInfo(int index) {
        GRect squareForMethod = new GRect(100, 83 + (index + 1) * 30, 20, 20);
        squareForMethod.setFilled(true);
        squareForMethod.setFillColor(colorsOfLinesForSortionMethodsData[index]);
        add(squareForMethod);
    }

    private void createInfoForGraph(int index) {
        createLabelForInfo(index);
        createSquareForInfo(index);
    }

    private void createNameOfGraph(final String NAME_OF_GRAPH) {
        GLabel nameOfGraph = new GLabel(NAME_OF_GRAPH, 170, 40);
        nameOfGraph.setColor(Color.BLACK);
        nameOfGraph.setFont("SansSerif-32");
        add(nameOfGraph);
    }

    private void createBackGroundOfGraph() {
        GRect gRect = new GRect(150, 50, 500, 600);
        gRect.setFilled(true);
        gRect.setFillColor(Color.BLACK);
        add(gRect);
    }

    private double getYPoint(int indexOfSortionMethod, int scaleY, int i) {
        int arraySize = (int) sortionMethodsTimeData[indexOfSortionMethod].hashMapForTimeFromArraySize.keySet().toArray()[i];
        return 600 - (sortionMethodsTimeData[indexOfSortionMethod].hashMapForTimeFromArraySize.get(arraySize) / scaleY);
    }

    private void createLine(int index, int scaleY) { //index 0 - 6; i 0 - 5
        double stepX = 75;

        for (int i = 0; i < sortionMethodsTimeData[0].hashMapForTimeFromArraySize.size() - 1; i++) {

            GLine line = new GLine(200 + (stepX * i), getYPoint(index, scaleY, i), 200 + (stepX * (i + 1)), getYPoint(index, scaleY, i + 1));
            line.setColor(colorsOfLinesForSortionMethodsData[index]);
            add(line);
        }
    }

    private int findScaleInt(int index, int scaleY) {
        for (; index < sortionMethodsTimeData.length; index++) {
            for (int i = 0; i < sortionMethodsTimeData[0].hashMapForTimeFromArraySize.size() - 1; i++) {
                if (getYPoint(index, scaleY, i) < 50 || getYPoint(index, scaleY, i + 1) < 50) {
                    scaleY = findScaleInt(index, scaleY + 10);
                }
            }
        }

        return scaleY;
    }

    public void run() {
        createBackGroundOfGraph();
        createNameOfArraysVariation();
        createNameOfGraph("Sortion methods time data graph");

        int scaleY = findScaleInt(0, 1);

        for (int i = 0; i < sortionMethodsTimeData.length; i++) {
            createInfoForGraph(i);

            createLine(i, scaleY);
        }
    }
}