package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.RoundInfo;
import com.gi.xm.platform.view.RoundQueryInfo;

public interface RoundFacede {
		MessageInfo<Integer> deleteRound(Integer id);
		
    MessageInfo<Integer> createRound(RoundInfo roundInfo);
		
	MessageInfo<Integer> updateRound(RoundInfo roundInfo);
		
	MessageInfo<RoundInfo> getRound(Integer id);

    /**
     * 获取全部行业
     * @return
     */
    MessageInfo<List<RoundInfo>> getAllRound();
			
    //MessageInfo<QueryResultInfo<RoundInfo>> queryRound(RoundQueryInfo roundQueryInfo);
	
	

}