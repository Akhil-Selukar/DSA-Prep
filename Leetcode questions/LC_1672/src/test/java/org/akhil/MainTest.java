package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMaximumWealth_OneCustomer() {
        int[][] accounts = {{1,5}};
        assertEquals(6, Main.maximumWealth(accounts));
    }

    @Test
    public void testMaximumWealth_MultipleCustomrs() {
        int[][] accounts = {{1,5},{2,6},{8,5},{1,6}};
        assertEquals(13, Main.maximumWealth(accounts));
    }

    @Test
    public void testMaximumWealth_CustomerWithZeroAccount() {
        int[][] accounts = {{1,5},{},{8,5}};
        assertEquals(13, Main.maximumWealth(accounts));
    }

    @Test
    public void testMaximumWealth_CustomerWithZeroBalance() {
        int[][] accounts = {{1,5},{0,0},{8,5}};
        assertEquals(13, Main.maximumWealth(accounts));
    }

    @Test
    public void testMaximumWealth_TwoCustomersWithMaxWealth() {
        int[][] accounts = {{6,7},{2,6},{8,5}};
        assertEquals(13, Main.maximumWealth(accounts));
    }

    @Test
    public void testMaximumWealth_CustomersWithDifferentNumberOfAccounts() {
        int[][] accounts = {{6,7},{2,6,5},{8},{1,5,6,3}};
        assertEquals(15, Main.maximumWealth(accounts));
    }

    @Test
    public void testMaximumWealth_NoCustomers() {
        int[][] accounts = {};
        assertEquals(Integer.MIN_VALUE, Main.maximumWealth(accounts));
    }
}