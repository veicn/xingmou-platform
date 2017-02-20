

package ctdn.biz;

import com.gi.ctdn.dao.TeamMemberStudyDAO;
import com.gi.ctdn.pojo.TeamMemberStudyInfo;
import com.gi.ctdn.query.TeamMemberStudyQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teamMemberStudyBiz")
public class TeamMemberStudyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TeamMemberStudyBiz.class);

    @Autowired
	TeamMemberStudyDAO teamMemberStudyDAO;



    public MessageInfo<Long> createTeamMemberStudy(TeamMemberStudyInfo teamMemberStudy){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
									teamMemberStudyDAO.insert( teamMemberStudy );
			messageInfo.setData(teamMemberStudy.getId());

		} catch (Exception e) {
			LOGGER.error("createTeamMemberStudy","创建TeamMemberStudy失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	


	public MessageInfo<QueryResultInfo<TeamMemberStudyInfo>> queryTeamMemberStudy(TeamMemberStudyQueryInfo teamMemberStudyQuery) {
		MessageInfo<QueryResultInfo<TeamMemberStudyInfo>> messageInfo = new MessageInfo<QueryResultInfo<TeamMemberStudyInfo>>();
		try {
			QueryResultInfo<TeamMemberStudyInfo> queryResult = new QueryResultInfo<TeamMemberStudyInfo>();
			PageHelper.startPage(teamMemberStudyQuery.getPageIndex(), teamMemberStudyQuery.getPageSize());
			List<TeamMemberStudyInfo> teamMemberStudyList = teamMemberStudyDAO.queryTeamMemberStudy(teamMemberStudyQuery);
			PageInfo<TeamMemberStudyInfo> pageInfo = new PageInfo<TeamMemberStudyInfo>(teamMemberStudyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(teamMemberStudyList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryTeamMemberStudy", "分页查询TeamMemberStudy失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}