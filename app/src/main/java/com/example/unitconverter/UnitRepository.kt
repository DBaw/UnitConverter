package com.example.unitconverter

class UnitRepository {
fun getAllUnits(): List<Unit>{
    return listOf(
        Unit("MASS"),
        Unit("DISTANCE"),
        Unit("TIME")
    )
}
}

class MassRepository {
    fun getAllUnits(): List<Unit>{
        return listOf(
            Unit("Funt (lb)"),
            Unit("Miligram (mg)"),
            Unit("Gram (g)"),
            Unit("Kilogram (kg)"),
            Unit("Tona (t)"),
            Unit("Uncja (oz)")
        )
    }
}
class DistanceRepository {
    fun getAllUnits(): List<Unit>{
        return listOf(
            Unit("Cal (in)"),
            Unit("Milimetr (mm)"),
            Unit("Centymetr (cm)"),
            Unit("Decymetr (dm)"),
            Unit("Metr (m)"),
            Unit("Kilometr (km)"),
            Unit("Cal (in)"),
            Unit("Mila angielska (mi)"),
            Unit("Mila morska (nmi)")
        )
    }
}
class TimeRepository {
    fun getAllUnits(): List<Unit>{
        return listOf(
            Unit("Rok"),
            Unit("Kwartał"),
            Unit("Miesiąc"),
            Unit("Tydzień"),
            Unit("Dzień"),
            Unit("Godzina"),
            Unit("Minuta"),
            Unit("Sekunda"),
            Unit("Milisekunda"),
        )
    }
}

