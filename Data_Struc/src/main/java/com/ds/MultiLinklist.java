package com.ds;
import java.io.*;

class MultiLinklist{
    public static class Node {
        int data;
        Node next;
        Node child;
    };
    public static Node createList(int arr[], int n)
    {
        Node head = null;
        Node tmp = null;

        for (int i = 0; i < n; i++)
        {
            if (head == null) {
                tmp = head = new Node();
            }
            else {
                tmp.next = new Node();
                tmp = tmp.next;
            }

            tmp.data = arr[i];
            tmp.next = tmp.child = null;
        }
        return head;
    }

    public static void printMultiLevelList(Node head)
    {
        while (head != null) {
            if (head.child != null) {
                printMultiLevelList(head.child);
            }
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr1[] = { 1, 2, 3 };
        int arr2[] = { 5, 6 };
        int arr3[] = { 4 };
        int arr4[] = { 7, 8, 9 };

        Node head1 = createList(arr1, 3);
        Node head2 = createList(arr2, 2);
        Node head3 = createList(arr3, 1);
        Node head4 = createList(arr4, 3);

        head1.child = head2;
        head1.next.next.child = head3;
        head2.next.child = head4;

        Node head = null;
        head = head1;

        printMultiLevelList(head);
    }
}

