/*Iliya Klishin
 *Dr. Steinberg
 *COP3330 Spring 2022
 *Programming Assignment 5
 */
 
  class Node <T>{
  
  Node <T> next;
  T data;
  
    public Node()// Default Constructor.
    {
      this.next = null;
      this.data = null;
      System.out.println("Node() Constructor Invoked...");
    }
  
    public Node(T data)// Overloaded constructor which assigns values to the attribute of the Node class.
    {
      this.data = data;
      this.next = null;
      System.out.println("Node(T data) Constructor Invoked...");
      
    }
  }
  
  public class LinkedList<T> {
  
  
    Node <T> head;
    int length = 0;
    
    
      public LinkedList(){
      
        this.head = null;
        System.out.println("LinkedList() Constructor Invoked...");
      }
      
      public void insert(T data)// This method inserts node with data of type variable T to the end of the linked list.
      {
      
        if(length == 0)
        {
          head = new Node<T>(data);
          length = 1;
        }
        
        else
        {
        
          Node <T> temp = head;
          
          while(temp.next != null)
          {
          
            temp = temp.next;
          
          }
          
          temp.next = new Node <T>(data);
          length++;
        
        }
      
      }
      
      public void insert(int position, T data){ // This method inserts a node to the specified position which is not out of range.
      
        if(length + 1 < position)
        {
          System.out.println("Out of range!");
        }
        
        else
        {
        
          Node <T> temp = head;
          int count = 1;
        
          while(temp.next != null && position > count)
          {
            temp = temp.next;
            count++;
          }
          
          Node <T> new_node = new Node <T>();
          new_node = new Node <T>(data);
          
          new_node.next = temp.next;
          temp.next = new_node;
          length++;
      
        }
        
      }
      
      public boolean empty()// This method checks if linked list is empty.
      {
      
        if(length == 0)
        {
          return true;
        }
        
        else
        {
          return false;
        }
      
      }
      
      public void remove(T data)// This method removes a node from the linked list.
      {
      
        if(empty())
        {
        
          System.out.println("The list is empty.");
        
        }
        
        else
        {
        
          
          if(head.data == data)
          {
            head = head.next;
            length--;
          }
          
          else if(length == 1)
          {
          
            head = null;
            length--;
          
          }
          
          else
          {
          
            Node <T> temp = head;
            Node <T> remove = new Node<T>();
            while(temp.next.data != data)
            {
              temp = temp.next;
            }
            
            remove.data = temp.next.data;
            temp.next = temp.next.next;
            length--;
          
          }
          
        
        }
      
      
      }
      
      
      public int length()// This method returns the length of the linked list.
      {
      
        return this.length;
      
      }
      
      public void clear()// This method removes all nodes from the linked list.
      {
      
        while(head != null)
        {
          head = head.next;
          length--;
        }
      
      }
      
      public String toString()// This method converts values in all of the nodes to String with format "data ---> data ---> ..." and returns this String.
      {
      
        Node <T> temp = head;
        String result = "";
        while(temp != null)
        {
        
          if(temp.next == null)
            result += temp.data;
          else
          {
            result = result + temp.data + " ---> ";
            //System.out.printf("%s" + " ---> ", temp.data);
          }
          
          temp = temp.next;
        
        }
        
        if(result != "")
          return result;
          
        else
          return("Empty List");
      
      }
      
  }