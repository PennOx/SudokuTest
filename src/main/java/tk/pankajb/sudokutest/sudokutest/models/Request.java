package tk.pankajb.sudokutest.sudokutest.models;

import java.util.List;

public class Request {
    private int size;
    private List<List<Integer>> grid;

    public Request(){}

    public Request(Request request) {
        this.grid = request.grid;
        this.size = request.size;
    }

    public List<List<Integer>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Integer>> grid) {
        this.grid = grid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
