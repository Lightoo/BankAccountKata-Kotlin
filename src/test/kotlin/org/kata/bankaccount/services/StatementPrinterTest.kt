package org.kata.bankaccount.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.kata.bankaccount.model.Account
import java.text.SimpleDateFormat
import java.util.*

class StatementPrinterTest {
    private lateinit var statementPrinter: StatementPrinter
    private lateinit var accountService: AccountService

    @BeforeEach
    fun setUp() {
        accountService = AccountServiceImpl()
        statementPrinter = TODO()
    }

    @Test
    @Throws(Exception::class)
    fun print_non_empty_account_transaction() {
        val account = Account()
        accountService.deposit(account, 200.0)
        accountService.deposit(account, 400.0)
        accountService.withdraw(account, 100.0)
        val date = SimpleDateFormat("dd-MM-yyyy").format(Date())
        val expectedValue = """
                Operation;Date;Amount;Balance
                DEPOSIT;$date;200.0;200.0
                DEPOSIT;$date;400.0;600.0
                WITHDRAW;$date;100.0;500.0
                """.trimIndent()
        Assertions.assertEquals(expectedValue, statementPrinter.print(account))
    }

    @Test
    @Throws(Exception::class)
    fun print_empty_account_transaction() {
        val account = Account()
        val expectedValue = "Operation;Date;Amount;Balance"
        Assertions.assertEquals(expectedValue, statementPrinter.print(account))
    }
}