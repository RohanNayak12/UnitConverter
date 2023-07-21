package com.converter.unit

interface Destinations {
    val route:String
}
object LengthConverter:Destinations{
    override val route="LengthRoute"
}
object MassConverter:Destinations{
    override val route="MassRoute"
}
object TempConverter:Destinations{
    override val route="TempRoute"
}
object NavControl:Destinations{
    override val route="NavRoute"
}
