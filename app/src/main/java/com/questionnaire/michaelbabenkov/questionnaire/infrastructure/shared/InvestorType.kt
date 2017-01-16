package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.shared

import com.questionnaire.michaelbabenkov.questionnaire.R

/**
 * Created by michael.babenkov on 16/01/17.
 */
enum class InvestorType(val investorName: String, val investorDescRes: Int, val investorChartRes: Int) {
    DEFENSIVE("Defensive", R.string.lbl_defensive, R.drawable.defensive_chart),
    CONSERVATIVE("Conservative", R.string.lbl_conservative, R.drawable.conservative_chart),
    BALANCED("Balanced", R.string.lbl_balanced, R.drawable.balanced_chart),
    BALANCED_GROWTH("Balanced Growth", R.string.lbl_balanced_growth, R.drawable.growth_chart),
    GROWTH("Growth", R.string.lbl_growth, R.drawable.growth_chart),
    AGGRESSIVE_GROWTH("Aggressive Growth", R.string.lbl_aggressive_growth, R.drawable.aggressive_chart)
}