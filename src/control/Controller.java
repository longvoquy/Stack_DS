package control;

import control.TextEditor;
import data.Menu;
import java.util.Scanner;

public class Controller extends Menu<String> {
    TextEditor editor = new TextEditor();
    Scanner scanner = new Scanner(System.in);

    static String[] menu = {"Chèn văn bản", "Xóa văn bản", "Hoàn tác", "Hiển thị văn bản", "Thoát"};

    public Controller() {
        super("\n----------!!Control System!!----------", menu);

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> importText();
            case 2 -> deleteTextbyId2();
            case 3 -> unDo();
            case 4 -> displayText();

        }
    }


    private void importText() {
        System.out.print("Nhập văn bản cần chèn: ");
        String insertText = scanner.nextLine();
        editor.insert(insertText);
    }


//    private void deleteTextbyId1() {
//        System.out.print("Nhập số ký tự cần xóa: ");
//        int numChars = scanner.nextInt();
//        editor.delete1(numChars);
//    }

    private void deleteTextbyId2() {
        System.out.print("Nhập số ký tự cần xóa: ");
        String numCharsStr = scanner.nextLine();
        editor.delete2(numCharsStr);
    }

    private void unDo() {
        editor.undo();

    }

    private void displayText() {
        System.out.println("Văn bản hiện tại: " + editor.getText());
    }
}
