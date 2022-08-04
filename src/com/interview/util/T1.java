package com.interview.util;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-05-20 17:58
 */
public class T1 {

    public static void main(String[] args) {
        String jsonString = null;
        String jsonString2 = null;
        try {
            jsonString = ToStringUtils.toJSONString("CustomerFeeParams(operator=kalebao002, customerNo=87291519147, fees=[CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=87291519147, brandCode=YHK, rate=0.6, settleCycle=T0, capsAmout=null, effectTime=null, expireTime=null, operator=null, defaultEstreat=3, allowTransStart=null, allowTransEnd=null, canTrans=null, feeConfigBean=null), CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=87291519147, brandCode=YHK, rate=0.6, settleCycle=T1, capsAmout=null, effectTime=null, expireTime=null, operator=null, defaultEstreat=0, allowTransStart=null, allowTransEnd=null, canTrans=null, feeConfigBean=null), CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=87291519147, brandCode=CX, rate=0.6, settleCycle=T0, capsAmout=null, effectTime=null, expireTime=null, operator=null, defaultEstreat=3, allowTransStart=null, allowTransEnd=null, canTrans=null, feeConfigBean=null), CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=87291519147, brandCode=CX, rate=0.6, settleCycle=T1, capsAmout=null, effectTime=null, expireTime=null, operator=null, defaultEstreat=0, allowTransStart=null, allowTransEnd=null, canTrans=null, feeConfigBean=null)], validate=false, status=OFF, effectTimeString=null, expireTimeString=null, policyCode=null, expiryRate=null, skT0OldRate=null, skT1OldRate=null, cxT0OldRate=null, cxT1OldRate=null, source=MANAGE_PORTAL)");
            jsonString2 = ToStringUtils.toJSONString("CustomerFeeParams(operator=kalebao002, customerNo=87291519147, fees=[CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=, brandCode=YHK, rate=0.6, settleCycle=T0, capsAmout=null, effectTime=null, expireTime=null, operator=, defaultEstreat=3, allowTransStart=, allowTransEnd=, canTrans=null, feeConfigBean=null), CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=, brandCode=YHK, rate=0.6, settleCycle=T1, capsAmout=null, effectTime=null, expireTime=null, operator=, defaultEstreat=null, allowTransStart=, allowTransEnd=, canTrans=null, feeConfigBean=null), CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=, brandCode=CX, rate=0.6, settleCycle=T0, capsAmout=null, effectTime=null, expireTime=null, operator=, defaultEstreat=3, allowTransStart=, allowTransEnd=, canTrans=null, feeConfigBean=null), CustomerFeeBean(createTime=null, lastUpdateTime=null, customerNo=, brandCode=CX, rate=0.6, settleCycle=T1, capsAmout=null, effectTime=null, expireTime=null, operator=, defaultEstreat=null, allowTransStart=, allowTransEnd=, canTrans=null, feeConfigBean=null)], validate=false, status=OFF, effectTimeString=, expireTimeString=, policyCode=317040, expiryRate=null, skT0OldRate=null, skT1OldRate=null, cxT0OldRate=null, cxT1OldRate=null, source=)");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(jsonString);
        System.out.println(jsonString2);
    }

}