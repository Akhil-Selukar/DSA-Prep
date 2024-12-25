package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(addAccount("John,johnsmith@mail.com,john_newyork@mail.com"));
        accounts.add(addAccount("John,johnsmith@mail.com,john00@mail.com"));
        accounts.add(addAccount("Mary,mary@mail.com"));
        accounts.add(addAccount("John,johnnybravo@mail.com"));

        Solution sol = new Solution();
        System.out.println(sol.accountsMerge(accounts));
    }

    private static List<String> addAccount(String s) {
        String[] emails = s.split(",");
        return new ArrayList<>(Arrays.asList(emails));
    }
}