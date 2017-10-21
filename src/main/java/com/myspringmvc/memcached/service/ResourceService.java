package com.myspringmvc.memcached.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.spy.memcached.MemcachedClient;

@Component
public class ResourceService {
	
	@Resource(name = "memcachedClient")
	private MemcachedClient memcachedClient;
	

}
