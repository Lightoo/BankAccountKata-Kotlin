package org.kata.bankaccount.services

import org.kata.bankaccount.model.Account

interface StatementPrinter {
    fun print(account: Account?): String
}