package com.lwj.ademo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwj_t on 2017/8/7.
 */

public class Feeling {


    private String loginName;
    private String loginID;
    private int resultCode;
    private String reason;
    private List<feelingsList> feelingsList  = new ArrayList<feelingsList>();

    public void addfeelingsListList(feelingsList feelingsListList){
        this.feelingsList.add(feelingsListList);
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<feelingsList> getFeelingsListList() {
        return feelingsList;
    }

    public void setFeelingsListList(List<feelingsList> feelingsListList) {
        this.feelingsList = feelingsListList;
    }


}






 class feelingsList{
     private String feelingId;
     private String loginName;
     private String nickName;
     private String headImgObjectKey;
     private String phrase;
     private String content;

     public String getFeelingId() {
         return feelingId;
     }

     public void setFeelingId(String feelingId) {
         this.feelingId = feelingId;
     }

     public String getLoginName() {
         return loginName;
     }

     public void setLoginName(String loginName) {
         this.loginName = loginName;
     }

     public String getNickName() {
         return nickName;
     }

     public void setNickName(String nickName) {
         this.nickName = nickName;
     }

     public String getHeadImgObjectKey() {
         return headImgObjectKey;
     }

     public void setHeadImgObjectKey(String headImgObjectKey) {
         this.headImgObjectKey = headImgObjectKey;
     }

     public String getPhrase() {
         return phrase;
     }

     public void setPhrase(String phrase) {
         this.phrase = phrase;
     }

     public String getContent() {
         return content;
     }

     public void setContent(String content) {
         this.content = content;
     }
 }
