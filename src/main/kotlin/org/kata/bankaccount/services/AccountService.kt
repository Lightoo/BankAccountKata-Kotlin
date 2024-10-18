package org.kata.bankaccount.services

import org.kata.bankaccount.model.Account

interface AccountService {
    @Throws(Exception::class)
    fun deposit(account: Account, amount: Double)
    @Throws(Exception::class)
    fun withdraw(account: Account, amount: Double): Boolean
}