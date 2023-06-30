package org.usvm.samples.wrappers

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.usvm.samples.JavaMethodTestRunner
import org.usvm.test.util.checkers.eq


@Suppress("SimplifyNegatedBinaryExpression")
internal class DoubleWrapperTest : JavaMethodTestRunner() {
    @Test
    @Disabled("Can not set static final double field java.lang.Double.POSITIVE_INFINITY to java.lang.Double")
    fun primitiveToWrapperTest() {
        checkDiscoveredProperties(
            DoubleWrapper::primitiveToWrapper,
            eq(2),
            { _, x, r -> x >= 0 && r != null && r.toDouble() >= 0 },
            { _, x, r -> (x < 0 || x.isNaN()) && (r != null && r.toDouble() > 0 || r!!.isNaN()) },
        )
    }

    @Test
    @Disabled("Can not set static final double field java.lang.Double.POSITIVE_INFINITY to java.lang.Double")
    fun wrapperToPrimitiveTest() {
        checkDiscoveredProperties(
            DoubleWrapper::wrapperToPrimitive,
            eq(3),
            { _, x, _ -> x == null },
            { _, x, r -> x >= 0 && r != null && r >= 0 },
            { _, x, r -> (x < 0 || x.isNaN()) && (r != null && r > 0 || r!!.isNaN()) },
        )
    }
}