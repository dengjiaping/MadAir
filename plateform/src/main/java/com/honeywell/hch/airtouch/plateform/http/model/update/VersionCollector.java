package com.honeywell.hch.airtouch.plateform.http.model.update;


import com.google.gson.annotations.SerializedName;
import com.honeywell.hch.airtouch.plateform.download.DownloadUtils;

import java.io.Serializable;

public class VersionCollector implements Serializable {

	public static final int FORCE_UPDATE = 1;

	private static final long serialVersionUID = 5997252056146210690L;

	@SerializedName("version_name")
	public String mVersionName;
	@SerializedName("version_code")
	public int mVersionCode;

	@SerializedName("is_force_update")
	public int mIsForceUpdate;

	@SerializedName("min_version_code")
	public int mMinVersionCode;

	@SerializedName("need_to_update_list")
	public int[] mNeedUpdateList;
	@SerializedName("description_en")
	public String mDescriptionEn;
	@SerializedName("description_ch")
	public String mDescriptionCh;
	
	// Generated by DownloadManager
	private long downloadId;
	
	public VersionCollector()
	{
		downloadId = DownloadUtils.FILE_DOWNLOAD_ID_INVALID;
	}

	
	public long getDownloadId() {
		return downloadId;
	}

	public void setDownloadId(long downloadId) {
		this.downloadId = downloadId;
	}


	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("version_name=");
		strBuffer.append(mVersionName);
		strBuffer.append(";version_code=");
		strBuffer.append(mVersionCode);
		strBuffer.append(";is_force_update=");
		strBuffer.append(mIsForceUpdate);
		strBuffer.append(";min_version_code=");
		strBuffer.append(mMinVersionCode);
		strBuffer.append(";need_to_update_list=");
		strBuffer.append(mNeedUpdateList);
		strBuffer.append(";description_en=");
		strBuffer.append(mDescriptionEn);
		strBuffer.append(";description_ch=");
		strBuffer.append(mDescriptionCh);
		strBuffer.append(";downloadId=");
		strBuffer.append(downloadId);
		return strBuffer.toString();
	}



	public String getVersionName() {
		return mVersionName;
	}

	public void setVersionName(String mVersionName) {
		this.mVersionName = mVersionName;
	}

	public int getVersionCode() {
		return mVersionCode;
	}

	public void setVersionCode(int mVersionCode) {
		this.mVersionCode = mVersionCode;
	}

	public int getIsForceUpdate() {
		return mIsForceUpdate;
	}

	public void setIsForceUpdate(int mIsForceUpdate) {
		this.mIsForceUpdate = mIsForceUpdate;
	}

	public int getMinVersionCode() {
		return mMinVersionCode;
	}

	public void setMinVersionCode(int mMinVersionCode) {
		this.mMinVersionCode = mMinVersionCode;
	}

	public int[] getNeedUpdateList() {
		return mNeedUpdateList;
	}

	public String getNeedUpdateListToString(){
		String result = "";
		if (mNeedUpdateList != null && mNeedUpdateList.length > 0){
			for (int i = 0 ; i < mNeedUpdateList.length ; i++){
				result += mNeedUpdateList[i];

				if (i < mNeedUpdateList.length - 1){
					result += ",";
				}
			}
		}
		return result;
	}

	public void setNeedUpdateList(int[] mNeedUpdateList) {
		this.mNeedUpdateList = mNeedUpdateList;
	}

	public String getDescriptionEn() {
		return mDescriptionEn;
	}

	public void setDescriptionEn(String mDescriptionEn) {
		this.mDescriptionEn = mDescriptionEn;
	}

	public String getDescriptionCh() {
		return mDescriptionCh;
	}

	public void setDescriptionCh(String mDescriptionCh) {
		this.mDescriptionCh = mDescriptionCh;
	}
}