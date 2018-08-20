package com.cy.comm.redis;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

public class LocalRedisSessionDao extends CachingSessionDAO{
	
	private EnterpriseCacheSessionDAO redisSessionDAO;
	
	public void setRedisSessionDAO(EnterpriseCacheSessionDAO redisSessionDAO) {
		this.redisSessionDAO = redisSessionDAO;
	}

	
	@Override
	protected void doUpdate(Session session) {
		redisSessionDAO.update(session);
		
	}

	@Override
	protected void doDelete(Session session) {
		redisSessionDAO.delete(session);
		
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session,sessionId);
		//this.cache(session, sessionId);
		return sessionId;
		
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return redisSessionDAO.readSession(sessionId);
	}

	
}
