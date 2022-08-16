package tk.pankajb.sudokutest.sudokutest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.pankajb.sudokutest.sudokutest.models.Request;
import tk.pankajb.sudokutest.sudokutest.models.Response;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sudoku")
public class SudokuController {

    @PostMapping
    public Response solve(@RequestBody Request request) {
        Response res = new Response(request);

        List<List<Integer>> solvedGrid = new ArrayList<>(request.getSize());
        for (int i = 0; i< request.getSize(); i++){
            List<Integer> row = new ArrayList<>(request.getSize());
            for (int j = 0; j < request.getSize(); j++) {
                row.add(request.getGrid().get(i).get(j));
            }
            solvedGrid.add(row);
        }

        if(solveSudoku(solvedGrid)){
            res.setSolved(true);
            res.setResult(solvedGrid);
            res.setMessage("Solved Successfully");
        }else{
            res.setSolved(false);
            res.setMessage("Nahi hua solve");
        }

        return res;

    }

    private boolean solveSudoku(List<List<Integer>> solvedGrid) {
        for(int row = 0; row<solvedGrid.size(); row++){
            for(int col = 0; col<solvedGrid.size(); col++){
                if(solvedGrid.get(row).get(col) == 0){
                    for(int key = 1; key<=9; key++){

                        if(canComeInPlace(row, col, key,solvedGrid)){
                            solvedGrid.get(row).set(col, key);
                            if(solveSudoku(solvedGrid)){
                                return true;
                            }else{
                                solvedGrid.get(row).set(col,0);
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return isSolved(solvedGrid);
    }

    private boolean canComeInPlace(int row, int col, int key, List<List<Integer>> solvedGrid) {
        if (canComeInRow(row, key,solvedGrid)) {
            if (canComeInCol(col, key, solvedGrid)) {
                if (canComeInGrid(row, col, key, solvedGrid)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canComeInGrid(int i, int j, int key, List<List<Integer>> solvedGrid) {

        int m = i - (i % (int) Math.sqrt(solvedGrid.size()));
        int n = j - (j % (int) Math.sqrt(solvedGrid.size()));

        for (int row = 0; row < (int) Math.sqrt(solvedGrid.size()); row++) {
            for (int col = 0; col < (int) Math.sqrt(solvedGrid.size()); col++) {

                if (solvedGrid.get(m + row).get(n + col) == key) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean canComeInCol(int col, int key, List<List<Integer>> solvedGrid) {
        for (int row = 0; row < solvedGrid.size(); row++) {
            if (solvedGrid.get(row).get(col) == key) {
                return false;
            }
        }

        return true;
    }

    private boolean canComeInRow(int row, int key, List<List<Integer>> solvedGrid) {

        for (int col = 0; col < solvedGrid.size(); col++) {
            if (solvedGrid.get(row).get(col) == key) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSolved(List<List<Integer>> solvedGrid) {

        for (int row = 0; row < solvedGrid.size(); row++) {
            for (int col = 0; col < solvedGrid.size(); col++) {
                if (solvedGrid.get(row).get(col) == 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
