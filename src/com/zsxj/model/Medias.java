package com.zsxj.model; 
 
import com.zsxj.common.database.DataModel; 
 
public class Medias extends DataModel{ 
	public int medias_ID; 
	public int medias_Type; 
	public String medias_Title; 
	public String medias_AddTime; 
	public String medias_Url; 
	public String medias_BelongtoTable; 
	public int medias_BelongtoID; 
 
	public Medias(int medias_ID) { 
		super(); 
		this.medias_ID = medias_ID; 
	} 
 
	public Medias() { 
		super(); 
	} 
 
	public int getMedias_ID() { 
		return medias_ID; 
	} 
 
	public void setMedias_ID(int medias_ID) { 
		this.medias_ID = medias_ID; 
	} 
 
	public int getMedias_Type() { 
		return medias_Type; 
	} 
 
	public void setMedias_Type(int medias_Type) { 
		this.medias_Type = medias_Type; 
	} 
 
	public String getMedias_Title() { 
		return medias_Title; 
	} 
 
	public void setMedias_Title(String medias_Title) { 
		this.medias_Title = medias_Title; 
	} 
 
	public String getMedias_AddTime() { 
		return medias_AddTime; 
	} 
 
	public void setMedias_AddTime(String medias_AddTime) { 
		this.medias_AddTime = medias_AddTime; 
	} 
 
	public String getMedias_Url() { 
		return medias_Url; 
	} 
 
	public void setMedias_Url(String medias_Url) { 
		this.medias_Url = medias_Url; 
	} 
 
	public String getMedias_BelongtoTable() { 
		return medias_BelongtoTable; 
	} 
 
	public void setMedias_BelongtoTable(String medias_BelongtoTable) { 
		this.medias_BelongtoTable = medias_BelongtoTable; 
	} 
 
	public int getMedias_BelongtoID() { 
		return medias_BelongtoID; 
	} 
 
	public void setMedias_BelongtoID(int medias_BelongtoID) { 
		this.medias_BelongtoID = medias_BelongtoID; 
	} 
 
 
} 
