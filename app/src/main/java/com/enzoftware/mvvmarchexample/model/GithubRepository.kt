package com.enzoftware.mvvmarchexample.model

import java.time.LocalDateTime

data class GithubRepository(
  val id: Int,
  val owner: Owner,
  val name: String,
  val description: String,
  val createdAt: LocalDateTime,
  val updatedAt: LocalDateTime,
  val starsCount: Int,
  val watchersCount: Int,
  val forksCount: Int,
  val language: Language
)