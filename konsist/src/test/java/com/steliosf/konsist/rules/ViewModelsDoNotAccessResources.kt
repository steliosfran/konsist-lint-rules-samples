package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.imports
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class ViewModelsDoNotAccessResources : BehaviorSpec() {

    init {
        Given("All files in production code") {
            val files = Konsist.scopeFromProduction().files

            When("There is a ViewModel") {
                val viewModels = files.withNameEndingWith("ViewModel")

                Then("It does not access resources") {
                    viewModels.imports.assertFalse {
                        it.hasNameStartingWith("com.steliosf.konsist.samples.R")
                    }
                }
            }
        }
    }
}
