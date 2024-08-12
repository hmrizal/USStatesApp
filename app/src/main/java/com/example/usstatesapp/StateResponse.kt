package com.example.usstatesapp

data class StateResponse(
    val data: List<StateData>
)

data class StateData(
    val State: String,
    val Population: Long,
    val Year: Int
)