package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAnnotationNamed
import com.lemonappdev.konsist.api.ext.list.withParameter
import com.lemonappdev.konsist.api.verify.assertTrue
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class RetrofitFieldParamsUseFormUrlEncoded : BehaviorSpec() {

    init {
        Given("All functions in production code") {
            val functions = Konsist.scopeFromProduction().functions()

            When("There is a function with the @POST annotation") {
                val functionsWithPost = functions.withAnnotationNamed("POST")

                And("It has at least one @Field parameter") {
                    val functionsWithFieldParams = functionsWithPost.withParameter {
                        it.hasAnnotationWithName("Field")
                    }

                    Then("It has the @FormUrlEncoded annotation") {
                        functionsWithFieldParams.assertTrue {
                            it.hasAnnotationWithName("FormUrlEncoded")
                        }
                    }
                }
            }
        }
    }
}
