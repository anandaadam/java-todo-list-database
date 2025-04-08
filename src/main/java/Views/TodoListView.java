package Views;

import services.TodoListService;
import utils.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Done");

            var input = InputUtil.input("Choose");
            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Choose 1 or 2 or 3");
            }
        }
    }

    public void addTodoList() {
        System.out.println("Add Todo List");

        var todo = InputUtil.input("Todo (x for cancel)");
        if (todo.equals("x")) {

        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("Remove Todo List");

        var number = InputUtil.input("Number todo (x for cancel)");
        if (number.equals("x")) {

        } else {
            var isSuccess = todoListService.removeTodoList(Integer.valueOf(number));
            if (!isSuccess) {
                System.out.println("Fail to remove todo at " + number);
            }
        }
    }
}
