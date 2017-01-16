package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.model

/**
 * Created by michael.babenkov on 16/01/17.
 */
data class SubmitForm(
        val email: String,
        val phone: String,
        val name: String,
        val points: Int
)
