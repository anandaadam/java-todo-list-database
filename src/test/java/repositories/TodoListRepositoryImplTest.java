package repositories;

import com.zaxxer.hikari.HikariDataSource;
import entities.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DatabaseUtil;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testGetAll() {
        TodoList[] todoLists = todoListRepository.getAll();
        for (var todo : todoLists) {
            System.out.println(todo.getId() + " " + todo.getTodo());
        }
    }

    @Test
    void testAdd() {
        TodoList todoList = new TodoList();
        todoList.setTodo("adam");

        todoListRepository.add(todoList);
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
