package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withoutName
import com.lemonappdev.konsist.api.verify.assertTrue
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class ViewModelsExtendAndroidxViewModel : BehaviorSpec() {

    init {
        Given("All classes in production code") {
            val classes = Konsist.scopeFromProduction().classes().withoutName(*BASELINE)

            When("There is a ViewModel") {
                val viewModels = classes.withNameEndingWith("ViewModel")

                Then("It extends the Android Jetpack ViewModel") {
                    viewModels.assertTrue(additionalMessage = MESSAGE) {
                        it.hasParentWithName("ViewModel")
                    }
                }
            }
        }
    }

    private companion object {
        private val MESSAGE = """
            Always extend the Android Jetpack ViewModel when creating a new ViewModel,
            to take advantage of its lifecycle awareness and other features it provides.
        """.trimIndent()

        private val BASELINE = arrayOf("LoginViewModel", "ChatViewModel")
    }
}
