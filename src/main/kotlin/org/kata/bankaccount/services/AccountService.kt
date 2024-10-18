package org.kata.bankaccount.services

import org.kata.bankaccount.model.Account

interface AccountService {
    fun deposit(account: Account, amount: Double): Boolean
    fun withdraw(account: Account, amount: Double): Boolean
}