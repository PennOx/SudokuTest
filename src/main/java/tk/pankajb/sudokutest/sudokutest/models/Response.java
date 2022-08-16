package tk.pankajb.sudokutest.sudokutest.models;

import java.util.List;

public class Response extends Request{
    private boolean solved;
    private String message;
    private List<List<Integer>> result;

    public Response(){}

    public Response(Request request){
        super(request);
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public List<List<Integer>> getResult() {
        return result;
    }

    public void setResult(List<List<Integer>> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
