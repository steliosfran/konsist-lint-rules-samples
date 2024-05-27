package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withoutName
import com.lemonappdev.konsist.api.verify.assertTrue
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class ViewModelsDependencyInjection : BehaviorSpec() {

    init {
        Given("All classes in production code") {
            val classes = Konsist.scopeFromProduction().classes().withoutName(*BASELINE)

            When("There is a ViewModel") {
                val viewModels = classes.withNameEndingWith("ViewModel")

                Then("It has the necessary dependency injection annotation") {
                    viewModels.assertTrue {
                        it.hasAnnotationWithName("HiltViewModel", "KoinViewModel")
                    }
                }
            }
        }
    }

    private companion object {
        private val BASELINE = arrayOf("SampleViewModel", "LoginViewModel", "ChatViewModel")
    }
}
