import org.junit.Test

import org.junit.Assert.*

class AgainCommissionKtTest {

    @Test
    fun calculation_VKPayCommissionFree() {
        val typeOfCard = "VK Pay"
        val amountMonth = 0
        val amountPay = 1_000_00

        val result = calculation(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(0, result)
    }

    @Test
    fun calculation_MastercardMaestroCommissionFree() {
        val typeOfCard = "Mastercard"
        val amountMonth = 0
        val amountPay = 1_000_00

        val result = calculation(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(0, result)
    }

    @Test
    fun calculation_MastercardMaestroCommissionMin() {
        val typeOfCard = "Mastercard"
        val amountMonth = 0
        val amountPay = 100_00

        val result = calculation(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(20_60, result)
    }

    @Test
    fun calculation_MastercardMaestroCommissionMax() {
        val typeOfCard = "Mastercard"
        val amountMonth = 0
        val amountPay = 100_000_00

        val result = calculation(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(620_00, result)
    }

    @Test
    fun calculation_VisaMirCommissionMax() {
        val typeOfCard = "Visa"
        val amountMonth = 0
        val amountPay = 100_000_00

        val result = calculation(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(750_00, result)
    }

    @Test
    fun calculation_VisaMirCommissionMin() {
        val typeOfCard = "Visa"
        val amountMonth = 0
        val amountPay = 40_00

        val result = calculation(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(35_00, result)
    }

    @Test
    fun check_VKPayOKTransferLimitOfDay() {
        val typeOfCard = "VK Pay"
        val amountMonth = 0
        val amountPay = 15_000_00

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(true, result)
    }

    @Test
    fun check_VKPayOKTransferLimitOnMonth() {
        val typeOfCard = "VK Pay"
        val amountMonth = 39_000_00
        val amountPay = 0

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(true, result)
    }

    @Test
    fun check_VKPayNotTransferLimitOnDay() {
        val typeOfCard = "VK Pay"
        val amountMonth = 0
        val amountPay = 16_000_00

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(false, result)
    }

    @Test
    fun check_VKPayNotTransferLimitOnMounth() {
        val typeOfCard = "VK Pay"
        val amountMonth = 100_000_00
        val amountPay = 0

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(false, result)
    }

    @Test
    fun check_CardOKTransfer() {
        val typeOfCard = "Visa"
        val amountMonth = 20_000_00
        val amountPay = 50_000_00

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(true, result)
    }

    @Test
    fun check_CardNotTransferLimitOnMounth() {
        val typeOfCard = "Visa"
        val amountMonth = 550_000_00
        val amountPay = 60_000_00

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(false, result)
    }

    @Test
    fun check_CardNotTransferLimitOnDay() {
        val typeOfCard = "Visa"
        val amountMonth = 0
        val amountPay = 200_000_00

        val result = check(
            typeOfCard = typeOfCard,
            amountMonth = amountMonth,
            amountPay = amountPay
        )
        assertEquals(false, result)
    }

}