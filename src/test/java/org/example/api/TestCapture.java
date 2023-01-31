package org.example.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCapture {
    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoBusinessImpl todoBusiness;

    @Test
    public void testUserCapture(){
        User user = new User(1, "mvey", "1357463");
        List<String> todosRelatedToSpring = todoBusiness.retrieveTodosRelatedToSpring(user);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(todoService).retrieveTodos(userCaptor.capture());
        User value = userCaptor.getValue();

        assertEquals("mvey", value.getLogin());
    }

    @Test
    public void testMock(){
        ArrayList arrayList = mock(ArrayList.class);
        arrayList.add(1);
        assertEquals(arrayList.size(), 0);
    }

    @Test
    public void tesySpy(){
        ArrayList list = spy(ArrayList.class);
        list.add(1);
        assertEquals(list.size(), 1);

    }
}
