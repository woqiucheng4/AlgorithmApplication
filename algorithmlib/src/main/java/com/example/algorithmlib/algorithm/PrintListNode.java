package com.example.algorithmlib.algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListNode {

    public static void main(String[] args){
        textPrintListFromTailToHead();
    }

    public static void textPrintListFromTailToHead() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        printListFromTailToHead(listNode1);
        printListFromTailToHead1(listNode1);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null) {
            list.add(0, tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    public static int[] printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode tmp = listNode;
        while (tmp != null) {
            stack.add(listNode.val);
            tmp = tmp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop();
        }
        return print;
    }

    public static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


