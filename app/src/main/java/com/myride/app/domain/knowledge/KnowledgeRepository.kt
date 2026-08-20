package com.myride.app.domain.knowledge

interface KnowledgeRepository {
    suspend fun get(entryId: String): KnowledgeEntry?
    suspend fun save(entry: KnowledgeEntry)
    suspend fun delete(entryId: String)
}
