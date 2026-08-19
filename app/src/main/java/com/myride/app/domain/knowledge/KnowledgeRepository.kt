package com.myride.app.domain.knowledge

interface KnowledgeRepository {
    fun get(entryId: String): KnowledgeEntry?
    fun save(entry: KnowledgeEntry)
    fun delete(entryId: String)
}
