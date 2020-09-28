package com.massiltech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.massiltech.entity.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
	public List<Conversation> findByPidAndDid(String pid, String did);
}
