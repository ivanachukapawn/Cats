package com.jwd.net.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface  DevEventUpdateDao extends PagingAndSortingRepository<DevEventUpdate,Integer>
{
	DevEventUpdate	findFirstByOrderByAddedDesc();

}
