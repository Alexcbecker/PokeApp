package com.study.pokeapp.pokemon.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.pokeapp.pokemon.data.local.model.RemoteKeyEntity

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeyEntity>)

    @Query("SELECT * FROM remote_key WHERE id = :id")
    suspend fun getRemoteKeyById(id: Int): RemoteKeyEntity

    @Query("DELETE FROM remote_key")
    suspend fun clearRemoteKeys()

    @Query("SELECT created_at FROM remote_key ORDER BY created_at DESC LIMIT 1")
    suspend fun getCreationTime(): Long?
}
