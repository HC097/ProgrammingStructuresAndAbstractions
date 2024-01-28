import java.util.*;
public class myStack<E>{
  Stack<E> stk = new Stack<E>();
  
  public void push(E obj){
    stk.puch(obj);
  }
  
  public E pop(){
    E obj = stk.pop();
    return obj;
  }
  
}