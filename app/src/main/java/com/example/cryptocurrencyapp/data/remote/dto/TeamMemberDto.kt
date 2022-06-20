package com.example.cryptocurrencyapp.data.remote.dto

import com.example.cryptocurrencyapp.domain.model.TeamMember

data class TeamMemberDto(
    val id: String,
    val name: String,
    val position: String
)

fun TeamMemberDto.toTeamMember(): TeamMember {
    return TeamMember(
        id = id,
        name = name,
        position = position
    )
}