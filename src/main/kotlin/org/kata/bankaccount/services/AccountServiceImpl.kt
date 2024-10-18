package org.kata.bankaccount.services

import org.kata.bankaccount.model.Account
import org.kata.bankaccount.model.OperationType
import org.kata.bankaccount.model.Transaction
import java.util.*

class AccountServiceImpl : AccountService {
    @Throws(Exception::class)
    override fun deposit(account: Account, amount: Double) {
        if (amount <= 0) throw Exception("deposit amount should be greater than 0")
        val newBalance = account.balance + amount
        account.balance = newBalance
        account.transactions.add(
            Transaction(OperationType.DEPOSIT, Date(), amount, newBalance)
        )
    }

    override fun withdraw(account: Account, amount: Double) {
        if (amount <= 0 || amount > account.balance) throw Exception("insufficient balance")
        val newBalance = account.balance - amount
        account.balance = newBalance
        account.transactions.add(
            Transaction(OperationType.WITHDRAW, Date(), amount, newBalance)
        )
    }
}