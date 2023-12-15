package stacks;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("First In Last Out - FIFO")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StackTest {

  private static Stack stack;

  @BeforeAll
  static void init() {
    stack = new Stack(8);
  }

  @Test
  @Order(1)
  @DisplayName("Should create empty stack with the capacity give it")
  void createStack() {

    assertEquals(8, stack.getCapacity());
    assertTrue(stack.isEmpty());
  }

  @Test
  @Order(2)
  @DisplayName("Should push an element on the top of stack")
  void push() {
    String expect = "90";

    stack.push(90);

    assertEquals(expect, stack.getStack());
    assertEquals(1, stack.getSize());
    assertEquals(stack.getFirst(), stack.peek());

    stack.push(80);
    stack.push(70);
    stack.push(60);
    stack.push(50);

    assertEquals(5, stack.getSize());
    assertEquals(50, stack.peek());
    assertEquals(
        "90 80 70 60 50",
        stack.getStack()
    );
  }

  @Test
  @Order(3)
  @DisplayName("Should pop an element on the top of stack")
  void pop() {
    stack.pop();

    assertEquals(60, stack.peek());
    assertEquals(4, stack.getSize());

    stack.pop();
    stack.pop();
    stack.pop();

    assertEquals(stack.getFirst(), stack.peek());
    assertEquals(1, stack.getSize());

    stack.pop();

    assertEquals(-1, stack.getFirst());
    assertEquals(-1, stack.peek());
    assertEquals(0, stack.getSize());
    assertTrue(stack.isEmpty());

  }
}
