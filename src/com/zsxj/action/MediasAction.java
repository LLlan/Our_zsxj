package com.zsxj.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.zsxj.common.database.DatabaseTransaction; 
import com.zsxj.model.Medias; 
import com.zsxj.service.MediasService; 
 
public class MediasAction { 
	public int add(Medias medias) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MediasService(trans).add(medias); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Medias medias) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MediasService(trans).edit(medias); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int medias_ID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MediasService(trans).delete(medias_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Medias> findAll() { 
		List<Medias> lists = new ArrayList<Medias>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new MediasService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Medias> findWhere(String where) { 
		List<Medias> lists = new ArrayList<Medias>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new MediasService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Medias findById(int medias_ID) { 
		Medias medias = new Medias(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			medias = new MediasService(trans).findById(medias_ID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return medias; 
	} 
	 
	public List<Medias> findByRange(int start, int size) { 
		List<Medias> lists = new ArrayList<Medias>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new MediasService(trans).findByRange(start, size); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Integer getCount() { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new MediasService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
