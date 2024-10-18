package org.kata.bankaccount.model

class Account(var balance: Double = 0.0, val transactions: MutableList<Transaction> = mutableListOf()) {
}