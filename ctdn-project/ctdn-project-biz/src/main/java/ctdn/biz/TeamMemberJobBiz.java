

package ctdn.biz;

import com.gi.ctdn.dao.TeamMemberJobDAO;
import com.gi.ctdn.pojo.TeamMemberJobInfo;
import com.gi.ctdn.query.TeamMemberJobQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teamMemberJobBiz")
public class TeamMemberJobBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TeamMemberJobBiz.class);

    @Autowired
	TeamMemberJobDAO teamMemberJobDAO;



    public MessageInfo<Long> createTeamMemberJob(TeamMemberJobInfo teamMemberJob){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
									teamMemberJobDAO.insert( teamMemberJob );
			messageInfo.setData(teamMemberJob.getId());

		} catch (Exception e) {
			LOGGER.error("createTeamMemberJob","创建TeamMemberJob失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	


	public MessageInfo<QueryResultInfo<TeamMemberJobInfo>> queryTeamMemberJob(TeamMemberJobQueryInfo teamMemberJobQuery) {
		MessageInfo<QueryResultInfo<TeamMemberJobInfo>> messageInfo = new MessageInfo<QueryResultInfo<TeamMemberJobInfo>>();
		try {
			QueryResultInfo<TeamMemberJobInfo> queryResult = new QueryResultInfo<TeamMemberJobInfo>();
			PageHelper.startPage(teamMemberJobQuery.getPageIndex(), teamMemberJobQuery.getPageSize());
			List<TeamMemberJobInfo> teamMemberJobList = teamMemberJobDAO.queryTeamMemberJob(teamMemberJobQuery);
			PageInfo<TeamMemberJobInfo> pageInfo = new PageInfo<TeamMemberJobInfo>(teamMemberJobList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(teamMemberJobList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryTeamMemberJob", "分页查询TeamMemberJob失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}