package org.kata.bankaccount.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.kata.bankaccount.model.Account

class AccountServiceTest {
    private lateinit var accountService: AccountService

    @BeforeEach
    fun setUp() {
        accountService = AccountServiceImpl();
    }
    @Test
    @Throws(Exception::class)
    fun deposit_with_positive_amount() {
        val account = Account()
        accountService.deposit(account, 200.0)
        assertEquals(200.0, account.balance)
    }
    @Test
    fun deposit_with_negative_amount() {
        val account = Account()
        Assertions.assertThrows(
            Exception::class.java
        ) { accountService.deposit(account, -200.0) }
    }
    @Test
    @Throws(Exception::class)
    fun withdraw_with_sufficient_amount() {
        val account = Account(2000.0, ArrayList())
        accountService.withdraw(account, 500.0)
        assertEquals(1500.0, account.balance)
        assertEquals(1, account.transactions.size)
    }

    @Test
    fun withdraw_with_insufficient_amount() {
        val account = Account(1000.0, ArrayList())
        Assertions.assertThrows(
            Exception::class.java
        ) { accountService.withdraw(account, 2000.0) }
    }
}