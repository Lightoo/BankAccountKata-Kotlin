package org.kata.bankaccount.services

import org.kata.bankaccount.model.Account
import org.kata.bankaccount.model.Transaction
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.function.Consumer

class StatementPrinterImpl : StatementPrinter {
    private val STATEMENT_HEADER = "Operation;Date;Amount;Balance"
    private val dateFormat: DateFormat = SimpleDateFormat("dd-MM-yyyy")
    override fun print(account: Account): String {
        val statementsBuilder: StringBuilder = StringBuilder(STATEMENT_HEADER)
        account.transactions.forEach(Consumer { transaction: Transaction ->
            statementsBuilder.append("\n")
                .append(transaction.operationType.name)
                .append(";")
                .append(dateFormat.format(transaction.date))
                .append(";")
                .append(transaction.amount)
                .append(";")
                .append(transaction.balance)
        })
        return statementsBuilder.toString()
    }
}