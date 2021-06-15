package management;

import java.util.List;

public interface GerenalManagement<T> {
   void display();
   void add(T t);
   void edit(String st);
   void delete(String st);
   T find(String st);
}
