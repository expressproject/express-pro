package com.weatherexpress.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherexpress.entity.InteractionChannel;

public interface InteractionChannelRepositoryDao extends JpaRepository<InteractionChannel, Integer> {
public InteractionChannel findInteractionChannelByUic_id(String userId);
}
