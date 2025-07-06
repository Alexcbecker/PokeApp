package com.study.pokeapp.pokemon.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key")
data class RemoteKeyEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    val nextKey: Int?,
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)
