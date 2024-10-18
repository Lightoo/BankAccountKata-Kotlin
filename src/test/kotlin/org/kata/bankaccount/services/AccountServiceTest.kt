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
}