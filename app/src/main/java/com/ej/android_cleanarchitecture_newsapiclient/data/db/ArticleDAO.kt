package com.ej.android_cleanarchitecture_newsapiclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ej.android_cleanarchitecture_newsapiclient.data.model.Article
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article:Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<Article>>
}