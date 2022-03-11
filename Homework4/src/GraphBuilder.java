import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class GraphBuilder extends GraphicsProgram {
    public SortionMethodsTimeData[] sortionMethodsTimeData = IntArrayTest.getSortionMethodsTimeDataArray();

    public int[] arraysSize = IntArrayTest.getArraysSize();

    public Color[] colorsOfLinesForSortionMethodsData = {
            Color.CYAN, Color.MAGENTA, Color.GREEN, Color.RED, Color.ORANGE, Color.BLACK, Color.BLUE
    };

    private void createNameOfArraysVariation(){
        GLabel nameOfArraysVariation = new GLabel(IntArrayTest.getArrayVariations()[IntArrayTest.getIndexOfArraysVariation()],170, 440);
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

    private void createLine(int index) { //index 0 - 6; i 0 - 5
        double stepX = 75;
        double scaleY = 500;

        for (int i = 0; i < arraysSize.length - 1; i++) {
             GLine line = new GLine( 200 + (stepX * i),300 - Picker.returnArrayTimeData[i].pick(index) / scaleY,200 + (stepX * (i + 1)), 300 - Picker.returnArrayTimeData[i + 1].pick(index)/scaleY);
            line.setColor(colorsOfLinesForSortionMethodsData[index]);
            add(line);
        }
    }

    public void run() {
        GRect gRect = new GRect(150, 50, 500, 300);
        gRect.setFilled(true);
        gRect.setFillColor(Color.LIGHT_GRAY);
        add(gRect);
        createNameOfArraysVariation();
        createNameOfGraph("Sortion methods time data graph");

        for (int i = 0; i < sortionMethodsTimeData.length; i++) {
            createInfoForGraph(i);
            createLine(i);
        }
    }
}