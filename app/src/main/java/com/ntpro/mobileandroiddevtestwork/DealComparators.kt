package com.ntpro.mobileandroiddevtestwork

class DealComparators {

    fun getDealDateComparator():  Comparator<Server.Deal> {
        return DealDateComparator()
    }
    fun getDealInstrumentComparator():  Comparator<Server.Deal> {
        return DealInstrumentComparator()
    }
    fun getDealPriceComparator():  Comparator<Server.Deal> {
        return DealPriceComparator()
    }
    fun getDealAmountComparator():  Comparator<Server.Deal> {
        return DealAmountComparator()
    }
    fun getDealSideComparator():  Comparator<Server.Deal> {
        return DealSideComparator()
    }

    //дать Кире проверить

    private class DealDateComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?): Int {
            return deal1?.timeStamp?.compareTo(deal2?.timeStamp) ?: 0 // временно или !!
        }
    }

    private class DealInstrumentComparator: Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?): Int {
            return deal2?.instrumentName?.let { deal1?.instrumentName?.compareTo(it) } ?: 0 // временно или !!
        }
    }

    private class DealPriceComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?): Int {
            return deal2?.price?.let { deal1?.price?.compareTo(it) } ?: 0 // временно или !!
        }
    }

    //цену предлагают сравнивать так, вопрос как обойти вопрос с налом
    /*if (car1.getPrice() < car2.getPrice()) return -1;
    if (car1.getPrice() > car2.getPrice()) return 1;
    return 0;*/

    private class DealAmountComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?): Int {
            return deal2?.amount?.let { deal1?.amount?.compareTo(it) } ?: 0 // временно или !!
        }
    }

    private class DealSideComparator : Comparator<Server.Deal> {
        override fun compare(deal1: Server.Deal?, deal2: Server.Deal?): Int {
            return deal2?.side?.let { deal1?.side?.compareTo(it) } ?: 0 // временно или !!
        }
    }

}


