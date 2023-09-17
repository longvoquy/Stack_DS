package control;

import data.Validation;

import java.util.Stack;


public class TextEditor {
    protected StringBuilder text;
    protected Stack<String> undoStack;


    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
    }

    public void insert(String textToInsert) {
        // Lưu văn bản hiện tại vào ngăn xếp hoàn tác
        undoStack.push(text.toString());
        // Chèn văn bản mới vào
        text.append(textToInsert);
    }

//    public void delete1(int numChars) {
//        if (numChars > 0) {
//            // Lưu văn bản hiện tại vào ngăn xếp hoàn tác
//            undoStack.push(text.toString());
//            // Xóa 'numChars' ký tự cuối cùng
//            text.delete(text.length() - numChars, text.length());
//        }
//    }

    public void delete2(String numCharsStr) {
        if (Validation.isPositiveInteger(numCharsStr)) {
            int numChars = Integer.parseInt(numCharsStr);
            if (numChars > 0 && numChars <= text.length()) {
                undoStack.push(text.toString());
                text.delete(text.length() - numChars, text.length());
            } else {
                System.err.println("Lỗi: Số ký tự cần xóa không nằm trong khoảng xác định.");
            }
        } else {
            System.err.println("Lỗi: Vui lòng nhập một số nguyên dương.");
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            // Pop trạng thái trước đó của văn bản từ ngăn xếp hoàn tác và đặt nó làm văn bản hiện tại
            text = new StringBuilder(undoStack.pop());
        }
    }

    public String getText() {
        return text.toString();
    }

}
