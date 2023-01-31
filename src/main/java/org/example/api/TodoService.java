package org.example.api;

import java.util.List;

public interface TodoService {
    List<String> retrieveTodos(User user);
}
