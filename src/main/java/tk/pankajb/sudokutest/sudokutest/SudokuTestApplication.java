package tk.pankajb.sudokutest.sudokutest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SudokuTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SudokuTestApplication.class, args);
    }

}
