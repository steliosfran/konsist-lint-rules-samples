package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.constructors
import com.lemonappdev.konsist.api.ext.list.parameters
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class ViewModelsDoNotDependOnRepositories : BehaviorSpec() {

    init {
        Given("All classes in production code") {
            val classes = Konsist.scopeFromProduction().classes()

            When("There is a ViewModel") {
                val viewModels = classes.withNameEndingWith("ViewModel")

                Then("No Repository is listed in the constructor parameters") {
                    viewModels.constructors.parameters.assertFalse {
                        it.type.name.endsWith("Repository")
                    }
                }
            }
        }
    }
}
