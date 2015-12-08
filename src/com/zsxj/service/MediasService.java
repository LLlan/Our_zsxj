package com.zsxj.service; 
 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.common.service.BaseService; 
import com.zsxj.dao.MediasDao; 
import com.zsxj.model.Medias; 
 
public class MediasService extends BaseService { 
	public MediasService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public MediasService() { 
		super(); 
	} 
 
	public int add(Medias medias) { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.add(medias); 
	} 
 
	public int edit(Medias medias) { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.edit(medias); 
	} 
 
	public int delete(int medias_ID) { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.delete(medias_ID); 
	} 
 
	public List<Medias> findAll() { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Medias> findWhere(String where) { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Medias findById(int medias_ID) { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.findById(medias_ID); 
	} 
 
	public List<Medias> findByRange(int start, int size) { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		MediasDao dao = new MediasDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
