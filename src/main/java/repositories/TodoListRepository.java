package repositories;

import entities.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();
    void add(TodoList todoList);
    boolean remove(Integer number);
}
