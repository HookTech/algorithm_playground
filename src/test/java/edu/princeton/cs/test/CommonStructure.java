package edu.princeton.cs.test;

/**
 * CommonStructure contains all kinds of class
 *
 * @author philo
 * @create 2018-03-27 9:31 AM
 **/
public class CommonStructure {
    public static class Node<T>{
        public T value;
        public Node<T> next;
        public Node(T data){
            value = data;
        }
    }
}
