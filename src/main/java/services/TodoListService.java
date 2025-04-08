package services;

public interface TodoListService {
    void showTodoList();
    void addTodoList(String todo);
    boolean removeTodoList(Integer number);
}
